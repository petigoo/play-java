name := """play-java"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  "org.mongodb" % "mongo-java-driver" % "3.3.0",
  "org.mongojack" % "mongojack" % "2.6.1"
)

libraryDependencies ++= Seq(
  "org.mockito" % "mockito-core" % "2.2.9",
  "org.assertj" % "assertj-core" % "3.5.2"
)
fork in run := false
