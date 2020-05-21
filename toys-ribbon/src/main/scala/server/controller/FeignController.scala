package server.controller

import com.typesafe.scalalogging.LazyLogging
import org.springframework.web.bind.annotation.{GetMapping, RestController}
import server.respository.PageBanner

@RestController
class FeignController extends LazyLogging {

  @GetMapping(Array("/feignRoute"))
  def feignRoute = {
    logger.error("谁来调用我，feign")
    List(PageBanner(title = "aaa", images = "ssw"))
  }
}
