package boot

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.{EnableAutoConfiguration, SpringBootApplication}
import org.springframework.web.reactive.config.EnableWebFlux


@SpringBootApplication
class SpringScalaApplication

object SpringScalaApplication extends App {
  SpringApplication.run(classOf[SpringScalaApplication], args: _*)
}

