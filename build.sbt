name := "book-log"

version := "1.0-SNAPSHOT"

scalaVersion := "2.13.11"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  "postgresql" % "postgresql" % "9.1-901.jdbc4"
)

routesGenerator := InjectedRoutesGenerator

lazy val root = (project in file(".")).enablePlugins(PlayScala)
