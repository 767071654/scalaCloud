package server

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.{EnableAutoConfiguration, SpringBootApplication}
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
//@EnableCircuitBreaker
class RibbonServer

@EnableAutoConfiguration
object RibbonServer {

  def main(args: Array[String]): Unit = {
    SpringApplication.run(classOf[RibbonServer], args: _*)
  }

}
