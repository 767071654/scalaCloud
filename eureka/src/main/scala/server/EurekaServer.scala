package server

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.{EnableAutoConfiguration, SpringBootApplication}
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer


@SpringBootApplication
@EnableEurekaServer
class EurekaServer

object EurekaServer extends App {
  SpringApplication.run(classOf[EurekaServer], args: _*)
}

