package src.actors

import akka.actor.{Actor, Props}
import org.springframework.beans.factory.annotation.Autowired
import src.dao.BannerDAO
import src.repository.PageBanner

import scala.concurrent.Await

class InsertActor (@Autowired bannerDAO: BannerDAO) extends Actor {

  override def receive: Receive = {
    case banner: PageBanner => {
      bannerDAO.insert(banner)
    }


  }
}


