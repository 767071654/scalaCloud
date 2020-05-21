package server.config

import akka.actor.ActorSystem
import org.springframework.context.annotation.{Bean, Configuration, Scope}

import scala.concurrent.ExecutionContext

@Configuration
class AkkaConfig {

  @Bean
  def actorSystem: ActorSystem = ActorSystem.create("actor")

  @Bean
  def ec: ExecutionContext = scala.concurrent.ExecutionContext.Implicits.global

}
