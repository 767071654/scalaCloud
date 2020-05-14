package server.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation._
import server.service.RibbonService

@RestController
class TestController @Autowired()(
  ribbonService: RibbonService) {

  @GetMapping(Array("/test"))
  def testHello = {
    ribbonService.getApiTest+"ssdsa"
  }


}


