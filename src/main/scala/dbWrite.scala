import java.sql.{BatchUpdateException, Connection, ResultSet, SQLException}

object dbWrite extends dbConnect {
  def insertUserData(UserName:String, FirstName:String, LastName:String): Unit = {
    val dbCon = new dbConnect
    val conn = dbCon.dbConnection()

    try {
      val stmt = conn.createStatement()

      val userDataID = uuid
      val userName = UserName.trim
      val firstName = FirstName.trim
      val lastName = LastName.trim

      val insertSQLUserData =
        s"""
           |INSERT INTO musiclibrary.UserData (UserDataID, UserName, FirstName, LastName)
           |VALUES ("$userDataID", "$userName", "$firstName", "$lastName");
           |""".stripMargin

      // will create a resultSet where there is a row when there is a match, but no row when there is not
      val existCheckUD = stmt.executeQuery(s"""SELECT 1 FROM musiclibrary.UserData WHERE UserName = "$userName"""")
      // next will return false when there is no row and true when there is a next row
      val existUD = existCheckUD.next()

      if (existUD == false) {
        try {
          stmt.executeUpdate(insertSQLUserData)
        } catch {
          case e: SQLException => e.printStackTrace
        }
      } else {
        println(s"Username already in database: $userName")
        println("Please try again")
      }
    } catch {
      case e: BatchUpdateException => try {
        conn.rollback()
      } catch {
        case e2: Exception => e.printStackTrace
      }
    }
    finally
    {
      conn.close()
    }
  }

  def insertMusicData(array:Array[Array[String]], userName:String): Unit = {
    val dbCon = new dbConnect
    val conn = dbCon.dbConnection()
    //val userDataID = stmt.executeQuery(s"""SELECT UserDataID FROM musiclibrary.UserData WHERE UserName = "$userName"""")

    try {
      if (array.length > 0) {
        for (i <- 0 until array.length) {
          val stmt = conn.createStatement()

          var trackID = array(i)(0).replaceAll("spotify:track:", "").trim
          var title = array(i)(1).trim
          var artist = array(i)(3).trim
          var album = array(i)(5).trim
          var duration = array(i)(12).toInt
          var genre = array(i)(18).trim
          val userLibraryID = uuid // random uuid to keep track of individual UserLibrary entries

          // Template for inserting values into Music Data
          val insertSQLMusicData =
            s"""
               |INSERT INTO musiclibrary.MusicData (TrackID, Title, Artist, Album, Duration, Genre)
               |VALUES ("$trackID", "$title", "$artist", "$album", $duration, "$genre");
               |""".stripMargin

          // Template for inserting values into User Library
          val insertSQLUserLibrary =
            s"""
               |INSERT INTO musiclibrary.UserLibrary (UserLibraryID, UserName, TrackID)
               |VALUES ("$userLibraryID", "$userName", "$trackID");
               |""".stripMargin

          val existCheckMD = stmt.executeQuery(s"""SELECT 1 FROM musiclibrary.MusicData WHERE TrackID = "$trackID";""")
          // returns true if trackID is already in MusicData and false if not

          // println("Comparing tracks to the Database...")
          if (existCheckMD.next() == false) { // Runs if trackID is not in MusicData
            try {
              stmt.executeUpdate(insertSQLMusicData) // Insert Track into MusicData
            } catch {
              case e: SQLException => e.printStackTrace
            }
          }
          else {
            println(s"Track is already in database: $title")
          }

          val existCheckUL = stmt.executeQuery(s"""SELECT 1 FROM musiclibrary.UserLibrary WHERE UserName = "$userName" AND TrackID = "$trackID"""")
          // returns true if UserDataID AND TrackID are already in UserLibrary and false if not

          // println("Comparing tracks in your Library...")
          if (existCheckUL.next() == false) { // Runs if UserDataID AND TrackID are not in UserLibrary
            try {
              stmt.executeUpdate(insertSQLUserLibrary)
            } catch {
              case e: SQLException => e.printStackTrace
            }
          }
          else {
            println(s"Track is already in your library: $title")
          }
        }
      }
      else {
        println("Your file is empty. Please try again")
      }
      println("Write Complete")
    }
    finally{
      conn.close()
    }
  }

  def checkUserName(userName:String): Boolean ={
    val dbCon = new dbConnect
    val conn = dbCon.dbConnection()
    val stmt = conn.createStatement()

    val existCheckUD = stmt.executeQuery(s"""SELECT 1 FROM musiclibrary.UserData WHERE UserName = "$userName"""")
    val existUD = existCheckUD.next()
    try{
      if (existUD == true){
        return true // return true if UserName exists
      }
      else {
        return false // return false if UserName doesn't exist
      }
    }
    finally {
      conn.close()
      stmt.close()
    }
  }

  def uuid = java.util.UUID.randomUUID.toString
  // generates random strings that can be used for id
}
