ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(
    name := "sentry_logging_lib"
  )

libraryDependencies ++= Seq(
  "io.sentry" % "sentry" % "6.13.1",
  "io.sentry" % "sentry-logback" % "1.7.16",
  "ch.qos.logback" % "logback-classic" % "1.2.3",
  "com.typesafe.play" %% "play-json" % "2.9.4"
)