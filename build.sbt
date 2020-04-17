name := "scalaCloud"

version := "0.1"

scalaVersion := "2.13.1"

libraryDependencies ++= {
  val springbtVersion = "2.2.6.RELEASE"
  Seq(
//    "org.springframework.boot"          % "spring-boot"                           % springbtVersion,
//    "org.springframework.boot"          % "spring-boot-autoconfigure"             % springbtVersion,
//    "org.springframework.boot"          % "spring-boot-devtools"                  % springbtVersion,
    "org.springframework.boot"            % "spring-boot-starter-webflux"             % springbtVersion,
    "com.typesafe.akka"                   %% "akka-actor"                             % "2.6.4",
    "io.projectreactor"                   %% "reactor-scala-extensions"               % "0.6.0",
    "com.fasterxml.jackson.module"        %% "jackson-module-scala"                   % "2.10.3",
    "mysql"                               %  "mysql-connector-java"                   % "5.1.48",
    "io.getquill"                         %% "quill-jdbc-monix"                       % "3.5.0",
    "ch.qos.logback"                      %  "logback-classic"                        % "1.2.3",
    "org.apache.logging.log4j"            %  "log4j-core"                             % "2.13.0",
    "com.typesafe.scala-logging"          %% "scala-logging"                          % "3.9.2",
  )
}
