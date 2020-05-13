name := "api"

version := "0.1"

scalaVersion := "2.13.1"

ThisBuild / useCoursier := false

libraryDependencies ++= {
  val verEureka = "2.2.2.RELEASE"
  Seq(
    "org.springframework.cloud"           % "spring-cloud-starter-netflix-eureka-client"  % verEureka,
    "com.typesafe.akka"                   %% "akka-actor"                                 % "2.6.4",
    "io.projectreactor"                   %% "reactor-scala-extensions"                   % "0.6.0",
    "com.fasterxml.jackson.module"        %% "jackson-module-scala"                       % "2.10.3",
    "mysql"                               %  "mysql-connector-java"                       % "5.1.48",
    "io.getquill"                         %% "quill-jdbc-monix"                           % "3.5.0",
  )
}
