name := "eureka"

version := "0.1"

scalaVersion := "2.13.1"

libraryDependencies ++= {
  val verEureka = "2.2.2.RELEASE"
  Seq(
    "org.springframework.cloud"           % "spring-cloud-starter-netflix-eureka-server"  % verEureka,
  )
}
