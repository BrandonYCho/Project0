import java.sql.{Connection, DriverManager}

class dbConnect {
  def dbConnection(): Connection = {
    val driver = "com.mysql.cj.jdbc.Driver"
    val url = "jdbc:mysql://localhost:3306/test"
    val username = "BranCho"
    val password = "HuzmUR@6Wy3GuV6N"

    var connection:Connection = null
    try {
      // make the connection
      Class.forName(driver)
      connection = DriverManager.getConnection(url, username, password)
    }
    catch {
      case e: Throwable => e.printStackTrace
    }
    connection
  }
}