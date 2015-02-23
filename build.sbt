
name := "S3cala"

organization := "com.roundeights"

version := "0.1"

scalaVersion := "2.11.2"

// append -deprecation to the options passed to the Scala compiler
scalacOptions ++= Seq("-deprecation", "-feature")

//publishTo := Some("Spikemark" at "https://spikemark.herokuapp.com/maven/roundeights")

//credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")

// Application dependencies
libraryDependencies ++= Seq(
    "commons-io" % "commons-io" % "2.4" % "optional",
    "com.amazonaws" % "aws-java-sdk" % "1.7.8.1"
)

val nexus = "http://nexus.lckymn.com/"

publishTo <<= version { (v: String) =>
  if (v.trim.endsWith("SNAPSHOT"))
    Some("snapshots" at nexus + "content/repositories/kevin-public-snapshots")
  else
    Some("releases"  at nexus + "content/repositories/kevin-public-releases")
}

publishMavenStyle := true

credentials += Credentials(Path.userHome / ".ivy2" / ".nexus-deploy-credentials")

pomIncludeRepository := { _ => false }

pomExtra := (
  <url>https://github.com/Kevin-Lee/S3cala</url>
    <licenses>
      <license>
        <name>The MIT License</name>
        <url>https://github.com/Kevin-Lee/S3cala/blob/master/LICENSE.md</url>
      </license>
    </licenses>
    <scm>
      <url>git@github.com:Kevin-Lee/S3cala.git</url>
      <connection>scm:git:git@github.com:Kevin-Lee/S3cala.git</connection>
    </scm>)

