package webserver.config

import akka.actor.ActorSystem
import org.springframework.context.annotation.{Bean, Configuration, Scope}

@Configuration
class AkkaConfig {

  @Bean
  def actorSystem: ActorSystem = ActorSystem.create("actor")

//  @Bean
//  def insertActor = actorSystem.actorOf(Props[InsertActor], "insertActor")

}
