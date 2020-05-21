package server.actors

import akka.actor.Actor
import org.springframework.beans.factory.annotation.Autowired
import server.dao.BannerDAO
import server.repository.PageBanner

import scala.concurrent.ExecutionContext

class InsertActor @Autowired()(
  bannerDAO: BannerDAO)(
  implicit
  executionContext: ExecutionContext) extends Actor {

  override def receive: Receive = {
    case banner: PageBanner => {
      bannerDAO.insert(banner)
    }


  }
}


