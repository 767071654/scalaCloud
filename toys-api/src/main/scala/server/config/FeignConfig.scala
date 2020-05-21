package server.config

import com.fasterxml.jackson.databind.ObjectMapper
import feign.Logger
import org.springframework.beans.factory.ObjectFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.http.HttpMessageConverters
import org.springframework.cloud.openfeign.support.{ResponseEntityDecoder, SpringDecoder}
import org.springframework.context.annotation.{Bean, Configuration}
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter

@Configuration
class FeignConfig @Autowired()(objectMapper: ObjectMapper) {

  @Bean
  def feignLogger: Logger.Level = Logger.Level.FULL

//  @Bean
//  def feignDecoder() = new ResponseEntityDecoder(new Default)

  @Bean
  def feignDecoder(): ResponseEntityDecoder = new ResponseEntityDecoder(new SpringDecoder(feignHttpMessageConverter()))

  def feignHttpMessageConverter(): ObjectFactory[HttpMessageConverters] = {
    val httpMessageConverters = new HttpMessageConverters(new MappingJackson2HttpMessageConverter(objectMapper))
    new ObjectFactory[HttpMessageConverters] {
      override def getObject: HttpMessageConverters = httpMessageConverters
    }
  }

//  def trans = {
//    val converter = new MappingJackson2HttpMessageConverter(objectMapper)
//    converter.setSupportedMediaTypes(List(MediaType.valueOf(MediaType.TEXT_HTML_VALUE + ";charset=UTF-8")).asJava)
//    converter
//  }

}

