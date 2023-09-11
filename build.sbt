//libraryDependencies ++= Seq(
// // jdbc,
// // cache,
////  ws,
////  "postgresql" % "postgresql" % "9.1-901.jdbc4"
//)

//routesGenerator := InjectedRoutesGenerator

//lazy val root = (project in file(".")).enablePlugins(PlayScala)

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    name := "book-log",
    version := "1.0-SNAPSHOT",
    scalaVersion := "2.13.12",
    libraryDependencies ++= Seq(
      ws,
      guice,
      "org.scalatestplus.play" %% "scalatestplus-play" % "5.1.0" % Test
    ),
    scalacOptions ++= Seq(
      "-feature",
      "-deprecation",
      "-Xfatal-warnings"
    )
  )
