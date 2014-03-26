name := "dM Math"

normalizedName := "dm-math"

description := "a library for doing math for elementary, middle, and high school"

organization := "org.dupontmanual"

organizationName := "duPont Manual High School"

version := "0.1-SNAPSHOT"

scalaVersion := "2.10.3"

scalacOptions ++= Seq("-deprecation", "-feature")

fork := true

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.0",
  "commons-codec" % "commons-codec" % "1.8",
  "ch.qos.logback" % "logback-core" % "1.0.13",
  "ch.qos.logback" % "logback-classic" % "1.0.13",
  "org.slf4j" % "log4j-over-slf4j" % "1.7.5"
)

site.settings

site.sphinxSupport()

site.includeScaladoc()

ghpages.settings

git.remoteRepo := "git@github.com:dupontmanual/dm-math.git"

publishMavenStyle := true

publishTo <<= version { (v: String) =>
  val nexus = "https://oss.sonatype.org/"
  if (v.trim.endsWith("SNAPSHOT"))
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases" at nexus + "service/local/staging/deploy/maven2") 
}

publishArtifact in Test := false

credentials += Credentials(Path.userHome / ".ssh" / ".credentials")

pomExtra := (
  <url>http://dupontmanual.github.io/dm-math</url>
  <licenses>
    <license>
      <name>Apache 2</name>
      <url>http://www.apache.org/licenses/LICENSE-2.0.html</url>
    </license>
  </licenses>
  <scm>
    <url>git://github.com/dupontmanual/dm-math.git</url>
    <connection>scm:git://github.com/dupontmanual/dm-math.git</connection>
  </scm>
  <developers>
    <developer>
      <name>Jim Miller</name>
      <roles>
        <role>Student, Class of 2014</role>
      </roles>
    </developer>
    <developer>
      <name>Todd O'Bryan</name>
      <roles>
        <role>Teacher</role>
      </roles>
    </developer>
  </developers>
)

