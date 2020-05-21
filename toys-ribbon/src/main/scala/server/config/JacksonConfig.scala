package server.config

import com.fasterxml.jackson.annotation.{JsonAutoDetect, PropertyAccessor}
import com.fasterxml.jackson.databind.{DeserializationFeature, ObjectMapper, SerializationFeature}
import com.fasterxml.jackson.module.scala.{DefaultScalaModule, ScalaObjectMapper}
import org.springframework.context.annotation.{Bean, Configuration}

@Configuration
class JacksonConfig {

  @Bean
  def objectMapper: ObjectMapper = {
    val mapper: ObjectMapper = new ObjectMapper() with ScalaObjectMapper
    mapper.registerModule(DefaultScalaModule)
    mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY)
    // 忽略json字符串中不识别的属性
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
    // 忽略无法转换的对象 “No serializer found for class com.xxx.xxx”
    mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS,false)
  }


}


