ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.12.10"

lazy val root = (project in file("."))
  .settings(
    name := "Project0"
  )

libraryDependencies += "org.apache.spark" %% "spark-core" % "3.1.2"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "3.1.2"
libraryDependencies += "org.apache.spark" %% "spark-hive" % "3.1.2"
libraryDependencies += "mysql" % "mysql-connector-java" % "8.0.28"
//libraryDependencies += "io.github.zamblauskas" %% "scala-csv-parser" % "<0.13.1>"
// Apache Commons
libraryDependencies += "commons-io" % "commons-io" % "20030203.000550"
libraryDependencies ++= Seq(
  "net.liftweb" %% "lift-json" % "3.1.1"
)