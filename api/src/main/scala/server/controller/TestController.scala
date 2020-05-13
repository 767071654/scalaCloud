package server.controller

import akka.actor.{ActorSystem, Props}
import com.typesafe.scalalogging.LazyLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation._
import reactor.core.scala.publisher.SMono
import server.actors.InsertActor
import server.dao.BannerDAO
import server.repository.PageBanner

import scala.beans.BeanProperty
import scala.concurrent.ExecutionContext.Implicits.global

@RestController
class TestController @Autowired()(
  actorSystem: ActorSystem,
  bannerDAO: BannerDAO) extends LazyLogging {

  @GetMapping(Array("/test"))
  def testHello = {
    logger.error("日志测试：sdfdsfgdfgffff")
    "hello"
  }

  @GetMapping(path = Array("/mono/{id}"))
  def testMono(@PathVariable("id")id: Int) = {
    SMono.fromFuture(bannerDAO.getBanners()).asJava
  }

  @PostMapping(path = Array("/actor"))
  def testActor(@RequestBody banner: PageBanner) = {
    val insertActor = actorSystem.actorOf(Props(new InsertActor(bannerDAO)))
    insertActor ! banner
    "ddddd"
  }




}


case class User(@BeanProperty id: Int, @BeanProperty name: String)