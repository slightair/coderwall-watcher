import sbt._
import sbt.Keys._

object ProjectBuild extends Build {

  lazy val root = Project(
    id = "root",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "coderwall-watcher",
      organization := "cc.clv",
      version := "0.1-SNAPSHOT",
      scalaVersion := "2.9.1",
      libraryDependencies ++= Seq(
        // test
        "org.specs2" %% "specs2" % "1.9" % "test",
            
        //log
        "org.clapper" %% "grizzled-slf4j" % "0.6.8",
        "ch.qos.logback" % "logback-classic" % "1.0.1"
      )
      // add other settings here
    )
  ).dependsOn(coderwall_scala)
  lazy val coderwall_scala = uri("git://github.com/yoshiori/coderwall-scala.git")
}
