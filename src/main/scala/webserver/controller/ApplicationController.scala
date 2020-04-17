package webserver.controller

import org.springframework.web.bind.annotation.{GetMapping, RequestMapping, RestController}

@RestController
class ApplicationController {

  @GetMapping(Array("/"))
  def index = {
    "Application is Started"
  }

  /**
   * 心跳
   */
  @GetMapping(Array("/health"))
  def monitor = {
    "heartbeat is ok"
  }

}
