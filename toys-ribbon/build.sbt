name := "api"

version := "0.1"

scalaVersion := "2.13.1"

ThisBuild / useCoursier := false

libraryDependencies ++= {
  val verEureka = "2.2.2.RELEASE"
  Seq(
    "org.springframework.cloud"           % "spring-cloud-starter-netflix-eureka-client"  % verEureka,
    "com.fasterxml.jackson.module"        %% "jackson-module-scala"                       % "2.10.2",
    "org.projectlombok"                   % "lombok"                                      % "1.18.10" % "provided"
  )
}
