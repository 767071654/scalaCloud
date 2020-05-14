package server

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient


@SpringBootApplication
@EnableDiscoveryClient
class ApiServer

object ApiServer {

  def main(args: Array[String]): Unit = {
    SpringApplication.run(classOf[ApiServer], args: _*)
  }
}

