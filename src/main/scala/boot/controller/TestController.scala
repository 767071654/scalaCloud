package boot.controller

import boot.dao.BannerDAO
import com.typesafe.scalalogging.LazyLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.{PathVariable, PostMapping, RequestMapping, RestController}
import reactor.core.scala.publisher.SMono

import scala.beans.BeanProperty
import scala.concurrent.ExecutionContext.Implicits.global

@RestController
class TestController @Autowired()(
  bannerDAO: BannerDAO) extends LazyLogging{

  @RequestMapping(Array("/test"))
  def testHello = {
    logger.error("日志测试：sdfdsfgdfgffff")
    "hello"
  }

  @PostMapping(path = Array("/mono/{id}"))
  def testMono(name: String, @PathVariable("id")id: Int) = {
    SMono.fromFuture(bannerDAO.getBanners).asJava
  }


}


case class User(@BeanProperty id: Int, @BeanProperty name: String)