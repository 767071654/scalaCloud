package server.remote

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.{RequestMapping, RequestMethod}
import server.config.FeignConfig
import server.repository.PageBanner

@Component
@FeignClient(name = "ribbon", fallback = classOf[FeignFallback], configuration = Array(classOf[FeignConfig]))
trait FeignTrait {

  @RequestMapping(value = Array("/feignRoute"), method = Array(RequestMethod.GET))
  def feignRoute(): List[PageBanner]
}

@Component
class FeignFallback extends FeignTrait {
  override def feignRoute(): List[PageBanner] = List(PageBanner(title = "a", images = "b"))
}

