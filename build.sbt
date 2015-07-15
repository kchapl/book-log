name := "book-log"

version := "1.0-SNAPSHOT"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  "postgresql" % "postgresql" % "9.1-901.jdbc4"
)

lazy val root = (project in file(".")).enablePlugins(PlayScala)
