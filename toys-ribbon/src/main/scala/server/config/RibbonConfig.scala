package server.config


import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.context.annotation.{Bean, Configuration}
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.client.RestTemplate

import scala.jdk.CollectionConverters._

@Configuration
class RibbonConfig @Autowired()(objectMapper: ObjectMapper) {

  @Bean
  @LoadBalanced
  def restTemplate: RestTemplate = {
    val restTemplate = new RestTemplate()
    val converters= restTemplate.getMessageConverters.asScala
    //objectMapper引入scalaModule，重新赋值HttpMessageConverter
    val newConverts = converters.filterNot(_.isInstanceOf[MappingJackson2HttpMessageConverter]).addOne(new MappingJackson2HttpMessageConverter(objectMapper)).toList
    restTemplate.setMessageConverters(newConverts.asJava)
    restTemplate
  }


}
