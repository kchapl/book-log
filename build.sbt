lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    name := "book-log",
    version := "1.0-SNAPSHOT",
    scalaVersion := "2.13.10",
    libraryDependencies ++= Seq(
      ws,
      guice,
      "org.scala-lang.modules" %% "scala-xml" % "2.1.0",
      "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test
    ),
    scalacOptions ++= Seq(
      "-feature",
      "-deprecation",
      "-Xfatal-warnings"
    )
  )
