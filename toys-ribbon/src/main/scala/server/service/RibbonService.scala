package server.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class RibbonService @Autowired() (
  restTemplate: RestTemplate){

  def getApiTest = restTemplate.getForObject("http://Api/test", classOf[String])


}
