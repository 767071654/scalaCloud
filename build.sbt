
name := "scalaCloud"

version := "0.1"

scalaVersion := "2.13.1"

def common = Seq(
  publishArtifact in(Compile, packageDoc) := false,
  publishArtifact in packageDoc := false,
  sources in(Compile, doc) := Seq.empty
)

lazy val parent = (project in file("toys-parent")).
  enablePlugins(JavaAppPackaging).
  settings(common: _*)

lazy val eureka = (project in file("toys-eureka")).
  dependsOn(parent).
  enablePlugins(JavaAppPackaging).
  settings(common: _*)

lazy val api = (project in file("toys-api")).
  dependsOn(parent).
  enablePlugins(JavaAppPackaging).
  settings(common: _*)

lazy val ribbon = (project in file("toys-ribbon")).
  dependsOn(parent).
  enablePlugins(JavaAppPackaging).
  settings(common: _*)

lazy val root = (project in file(".")).
  aggregate(parent, api, eureka).
  enablePlugins(JavaAppPackaging)

