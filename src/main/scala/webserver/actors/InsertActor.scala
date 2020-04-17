package webserver.actors

import akka.actor.{Actor, Props}
import org.springframework.beans.factory.annotation.Autowired
import webserver.dao.BannerDAO
import webserver.repository.PageBanner

import scala.concurrent.Await

class InsertActor (@Autowired bannerDAO: BannerDAO) extends Actor {

  override def receive: Receive = {
    case banner: PageBanner => {
      bannerDAO.insert(banner)
    }


  }
}


