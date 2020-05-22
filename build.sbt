import com.typesafe.sbt.packager.docker.{Cmd, ExecCmd}

name := "scalaCloud"

version := "0.1"

scalaVersion := "2.13.1"

def common = Seq(
  publishArtifact in(Compile, packageDoc) := false,
  publishArtifact in packageDoc := false,
  sources in(Compile, doc) := Seq.empty,
  dockerCommands := Seq(
    Cmd("FROM", "hub.52toys.com/library/alpine-java:8"),
    Cmd("USER", "root"),
    Cmd("COPY", "opt",  "/opt"),
    Cmd("WORKDIR", "/opt/docker"),
    Cmd("RUN", "chmod", "-R", "777", "/opt/docker"),
    Cmd("ENV", "JAVA_OPTS='-XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap'")
  ),
  bashScriptExtraDefines ++= Seq( "addJava '-Dpidfile.path=/dev/null'" )
)

lazy val parent = (project in file("toys-parent")).
  enablePlugins(JavaAppPackaging).
  settings(common: _*)

lazy val eureka = (project in file("toys-eureka")).
  dependsOn(parent).
  enablePlugins(JavaAppPackaging).
  settings(common: _*).
  settings(Seq(
    dockerCommands += ExecCmd("ENTRYPOINT", "/opt/docker/bin/eureka", "-Dlogger.resource=logback.xml")
  ))

lazy val api = (project in file("toys-api")).
  dependsOn(parent).
  enablePlugins(JavaAppPackaging).
  settings(common: _*).
  settings(Seq(
    dockerCommands += ExecCmd("ENTRYPOINT", "/opt/docker/bin/api", "-Dlogger.resource=logback.xml")
  ))

lazy val ribbon = (project in file("toys-ribbon")).
  dependsOn(parent).
  enablePlugins(JavaAppPackaging).
  settings(common: _*).
  settings(Seq(
    dockerCommands += ExecCmd("ENTRYPOINT", "/opt/docker/bin/ribbon", "-Dlogger.resource=logback.xml")
  ))

lazy val root = (project in file(".")).
  aggregate(parent, api, eureka, ribbon)



