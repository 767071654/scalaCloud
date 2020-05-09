name := "scalaCloud"

version := "0.1"

def common = Seq(
  publishArtifact in(Compile, packageDoc) := false,
  publishArtifact in packageDoc := false,
  sources in(Compile, doc) := Seq.empty
)

lazy val parent = (project in file("parent")).
  settings(common: _*)

lazy val api = (project in file("api")).
  dependsOn(parent).
  settings(common: _*)

lazy val eureka = (project in file("eureka")).
  dependsOn(parent).
  settings(common: _*)                     

lazy val root = (project in file(".")).
  aggregate(parent, api, eureka)

