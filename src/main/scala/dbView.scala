object dbView {
  def userLibraryView(user:String):Unit = {
    val dbCon = new dbConnect
    val conn = dbCon.dbConnection()
    val stmt = conn.createStatement()

    try {
      val viewSQLUL =
        s"""
           |SELECT Title,Artist,Album,Duration,Genre FROM musiclibrary.musicdata
           |INNER JOIN musiclibrary.UserLibrary ON musiclibrary.musicdata.TrackID = musiclibrary.userlibrary.TrackID
           |WHERE musiclibrary.userlibrary.UserName = "$user";
           |""".stripMargin

      val resultSet = stmt.executeQuery(viewSQLUL)
      while(resultSet.next()){
        println("|\tTitle:\t" + resultSet.getString(1) + "\t | \tArtist:\t" + resultSet.getString(2) + "\t | \tAlbum\t" + resultSet.getString(3) + "\t | \tDuration:\t" + resultSet.getString(4) + "\t | \tGenre:\t" + resultSet.getString(5) + "\t |")
      }
    } catch {
      case e: Throwable => e.printStackTrace()
    }
    finally{
      conn.close()
      stmt.close()
    }

  }

  def musicDBView():Unit = {
    val dbCon = new dbConnect
    val conn = dbCon.dbConnection()
    val stmt = conn.createStatement()

    try {
      val viewSQLMD = "SELECT Title,Artist,Album,Duration,Genre FROM musiclibrary.musicdata ORDER BY Title;"
      val resultSet = stmt.executeQuery(viewSQLMD)
      //println("| \t" + " Title " + "\t | \t" + " Artist " + "\t | \t" + " Album " + "\t | \t" + " Duration (ms) " + "\t | \t" + " Genre ")
      while(resultSet.next()){
        println("|\tTitle:\t" + resultSet.getString(1) + "\t | \tArtist:\t" + resultSet.getString(2) + "\t | \tAlbum\t" + resultSet.getString(3) + "\t | \tDuration:\t" + resultSet.getString(4) + "\t | \tGenre:\t" + resultSet.getString(5) + "\t |")
      }
    } catch {
        case e: Throwable => e.printStackTrace()
      }
    finally{
      conn.close()
      stmt.close()
    }

  }

}
