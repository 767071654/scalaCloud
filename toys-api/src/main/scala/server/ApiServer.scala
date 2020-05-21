package server

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.openfeign.EnableFeignClients


@EnableFeignClients(basePackages = Array("server.remote"))
@EnableDiscoveryClient
@SpringBootApplication
//@EnableHypermediaSupport(`type` = Array(HypermediaType.HAL))
//@EnableCircuitBreaker
//@EnableHystrix
class ApiServer

object ApiServer {

  def main(args: Array[String]): Unit = {
    SpringApplication.run(classOf[ApiServer], args: _*)
  }
}

