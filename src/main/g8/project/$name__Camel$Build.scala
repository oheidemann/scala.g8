import sbt._
import sbt.Keys._

object BuildSettings {
  val buildOrganization = "$organization$"
  val projectName = "$name;format="norm"$"
  val buildScalaVersion = "$scala_version$"
  val buildVersion = "$version$"

  val buildSettings = Defaults.defaultSettings ++ 
  	Seq(name := projectName, organization := buildOrganization, scalaVersion := buildScalaVersion, version := buildVersion)
}

object Resolvers {
  val typesafeRepo = "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
  val sonatypeRepo = "Sonatype Releases" at "http://oss.sonatype.org/content/repositories/releases"

  val scalaResolvers = Seq(typesafeRepo, sonatypeRepo)
}

object Dependencies {
	val compileDeps = Seq(
//		"joda-time" % "joda-time" % "2.1",
//      "org.joda" % "joda-convert" % "1.2",
  	)
  
  	val testDeps = Seq(
    	"org.specs2" %% "specs2" % "1.13",
    	"junit" % "junit" % "4.10"
  	).map(_ % "test")
}

object $name;format="Camel"$Build extends Build {

  import Resolvers._
  import Dependencies._
  import BuildSettings._

  lazy val $name;format="camel"$Prj = Project(
  	id = projectName, 
  	base = file("."), 
  	settings = buildSettings ++ Seq(
  		resolvers := scalaResolvers, 
  		libraryDependencies := compileDeps ++ testDeps)
  )
}