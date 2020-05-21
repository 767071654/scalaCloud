name := "api"

version := "0.1"

scalaVersion := "2.13.1"

ThisBuild / useCoursier := false

libraryDependencies ++= {
  val verEureka = "2.2.2.RELEASE"
  val verFeign = "2.2.2.RELEASE"
  val verHystrix = "2.2.2.RELEASE"
  Seq(
    "org.springframework.cloud"           % "spring-cloud-starter-netflix-eureka-client"  % verEureka,
    "org.springframework.cloud"           % "spring-cloud-starter-openfeign"              % verFeign,
//    "org.springframework.cloud"           % "spring-cloud-starter-netflix-hystrix"        % verHystrix,
    "com.typesafe.akka"                   %% "akka-actor"                                 % "2.6.4",
    "io.projectreactor"                   %% "reactor-scala-extensions"                   % "0.6.0",
    "com.fasterxml.jackson.module"        %% "jackson-module-scala"                       % "2.10.2",
    "mysql"                               %  "mysql-connector-java"                       % "5.1.48",
    "io.getquill"                         %% "quill-jdbc-monix"                           % "3.5.0",
  )
}
