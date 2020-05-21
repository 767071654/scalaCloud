name := "parent"

version := "0.1"

scalaVersion := "2.13.1"

libraryDependencies ++= {
  val verSpringBoot = "2.2.4.RELEASE"
  val verSpringCloud = "Hoxton.SR3"
  Seq(
//    "org.springframework.boot"          % "spring-boot"                             % verSpringBoot,
//    "org.springframework.boot"          % "spring-boot-autoconfigure"               % verSpringBoot,
//    "org.springframework.boot"          % "spring-boot-devtools"                    % verSpringBoot,
    "org.springframework.boot"            % "spring-boot-starter-webflux"             % verSpringBoot,
//    "org.springframework.boot"            % "spring-boot-starter-hateoas"             % verSpringBoot,
    "org.springframework.cloud"           % "spring-cloud-dependencies"               % verSpringCloud,
    "com.google.code.gson"                % "gson"                                    % "2.8.6",
    "ch.qos.logback"                      %  "logback-classic"                        % "1.2.3",
    "org.apache.logging.log4j"            %  "log4j-core"                             % "2.13.0",
    "com.typesafe.scala-logging"          %% "scala-logging"                          % "3.9.2",
  )
}
