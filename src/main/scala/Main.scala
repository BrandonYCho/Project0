import CSVReadFile.readCSV
import dbWrite.{insertUserData, insertMusicData}
import scala.io.StdIn.{readInt, readLine}

object Main {
  /*Project Idea: take in user music data (Artist,Song Name, Album Genre, Plays)
  Do something similar to Spotify
  Compare 2 users artist/genres, what songs are popular for each,
    what they don't have in common as well
    Create a playlist of commonly liked songs
    If they don't have anything in common, can create a playlist of
      their favorite songs
    Can also just store music data, keep things updated
   */
  def main(args: Array[String]): Unit = {
    println(
      """
        ||----------------------------------|
        ||             Spoofify             |
        ||----------------------------------|
        || 1 -> Create New User             |
        ||----------------------------------|
        || 2 -> Use Existing User           |
        ||----------------------------------|
        || 0 -> Exit                        |
        ||----------------------------------|
        |""".stripMargin
    ) // prints user inputs for user selection (New User/ Existing User / Exit)

    val userInput = readInt()
    var tempMenu = ""

    val menu = new Menu
    tempMenu = menu.firstUserInput(userInput)

    println(
      """
        ||----------------------------------|
        || 1 -> Import CSV File             |
        ||----------------------------------|
        || 2 -> View User Library           |
        ||----------------------------------|
        || 3 -> View Music Database         |
        ||----------------------------------|
        || 4 -> Change User                 |
        ||----------------------------------|
        || 0 -> Exit                        |
        ||----------------------------------|
        |""".stripMargin) // prints user inputs for importing / viewing database / etc..

    val userInput2 = readInt()
    var tempMenu2 = menu.secondUserInput(userInput2, tempMenu)

  }
}
