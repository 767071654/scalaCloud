package server.remote

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import server.respository.PageBanner

@Service
class RibbonService @Autowired() (
  objectMapper: ObjectMapper,
  restTemplate: RestTemplate) {

  def getTest = restTemplate.getForObject("http://Api/test/1", classOf[PageBanner])

  def getApiBanners = restTemplate.getForObject("http://Api/mons/1", classOf[List[PageBanner]])

  def insertApiBanners = {
    val banner = PageBanner(title = "哈哈哈", images = "ssssssdad")
    restTemplate.postForObject("http://Api/actor", banner, classOf[String])
  }

}
