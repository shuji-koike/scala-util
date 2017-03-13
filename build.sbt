name := "scala-util"
version := "1.0.0"
scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "org.slf4j" % "slf4j-api" % "1.7.24",
  "org.slf4j" % "slf4j-log4j12" % "1.7.24" % "test",
  "org.scalatest" %% "scalatest" % "3.0.1" % "test")

initialCommands in console := """
import org.koike.shuji.util._
"""
