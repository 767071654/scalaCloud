package server.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation._
import server.remote.RibbonService

@RestController
class TestController @Autowired()(
  ribbonService: RibbonService) {

  @GetMapping(Array("/testFirst"))
  def testFirst = {
    ribbonService.getTest
  }

  @GetMapping(Array("/test"))
  def testHello = {
    ribbonService.getApiBanners
  }

  @GetMapping(Array("/testInsert"))
  def testApiInsert = {
    ribbonService.insertApiBanners
  }


}


