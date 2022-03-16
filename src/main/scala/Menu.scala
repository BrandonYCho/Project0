import CSVReadFile.readCSV
import CaseClasses.UserData
import dbView.{musicDBView, userLibraryView}
import dbWrite.{checkUserName, insertMusicData, insertUserData}

import scala.io.StdIn.{readInt, readLine}

class Menu {
  def firstUserInput(input:Int): String = {
    var id = ""

    input match {

      case 1 => {
        val newUserName = readLine("Enter your username: ")
        checkUserName(newUserName)
        if(checkUserName(newUserName) == false){
          println("Username available!")
          Thread.sleep(3000)
          val newFirstName = readLine("Enter your first name: ")
          val newLastName = readLine("Enter your last name: ")
          insertUserData(newUserName, newFirstName, newLastName)
          id = newUserName
          Thread.sleep(3000)
        }
        else{
          println("Username has been taken")
          println("Please try again")
          Thread.sleep(3000)
          sys.exit()
        }
      }
        return id

      case 2 => {
        val oldUserName = readLine("Enter your username: ")
        if(checkUserName(oldUserName) == true){
          println("Welcome back!")
          Thread.sleep(3000)
          id = oldUserName
        }
      }
        return id

      case 0 => {
        println("Goodbye!")
        Thread.sleep(3000)
        sys.exit()
      }

    }
  }

  def secondUserInput(input:Int, user:String): Unit = {
    var id = ""

    input match {
      case 1 => { // Import CSV
        val filePath = readLine("Enter CSV filepath: ")
        println("Getting things ready...")
        Thread.sleep(3000)
        insertMusicData(readCSV(filePath),user)
      }

      case 2 => { // View User Library
        userLibraryView(user)
        Thread.sleep(5000)
      }

      case 3 => { // View Music Database
        musicDBView()
        Thread.sleep(5000)
      }

      case 4 => { // Change User
        println(
          """
            |----------------------------------|
            |             Spoofify             |
            |----------------------------------|
            | 1 -> Create New User             |
            |----------------------------------|
            | 2 -> Use Existing User           |
            |----------------------------------|
            | 0 -> Exit                        |
            |----------------------------------|
            |""".stripMargin)
        val newInput = readInt()
        val menu = new Menu
        val tempMenu = menu.firstUserInput(newInput)
      }

      case 0 => { // Exit
        println("Goodbye!")
        Thread.sleep(3000)
        sys.exit()
      }
    }
  }

}
