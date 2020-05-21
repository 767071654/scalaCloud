package server.controller

import akka.actor.{ActorSystem, Props}
import com.typesafe.scalalogging.LazyLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation._
import reactor.core.publisher.Mono
import reactor.core.scala.publisher.SMono
import server.actors.InsertActor
import server.dao.BannerDAO
import server.remote.FeignTrait
import server.repository.PageBanner

import scala.beans.BeanProperty
import scala.concurrent.ExecutionContext

@RestController
class TestController @Autowired()(
  actorSystem: ActorSystem,
  feignTrait: FeignTrait,
  bannerDAO: BannerDAO)(implicit ec: ExecutionContext) extends LazyLogging {

  @GetMapping(Array("/test/{id}"))
  def testHello(@PathVariable("id")id: Int) = {
    logger.error("日志测试：sdfdsfgdfgffff")
    PageBanner(title = "ssd", images = "sdfs")
  }

  @GetMapping(path = Array("/mons/{id}"))
  def testMono(@PathVariable("id")id: Int): Mono[List[PageBanner]] = {
    SMono.fromFuture(bannerDAO.getBanners()).asJava
  }

  @PostMapping(path = Array("/actor"))
  def testActor(@RequestBody banner: PageBanner) = {
    val insertActor = actorSystem.actorOf(Props(new InsertActor(bannerDAO)))
    insertActor ! banner
    "ddddd"
  }

  @GetMapping(path = Array("/testFeign"))
  def testFeign() = {
    feignTrait.feignRoute()
  }


}


case class User(@BeanProperty id: Int, @BeanProperty name: String)