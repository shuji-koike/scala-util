name := "scala-util"
version := "1.0.0"
scalaVersion := "2.12.4"
crossScalaVersions := Seq("2.12.4", "2.11.12", "2.10.7")

libraryDependencies ++= Seq(
  "org.slf4j" % "slf4j-api" % "1.7.25",
  "org.slf4j" % "slf4j-log4j12" % "1.7.25" % "test",
  "org.scalatest" %% "scalatest" % "3.0.4" % "test")

initialCommands in console := """
import org.koike.shuji.util._
"""
