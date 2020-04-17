package boot.controller

import org.springframework.web.bind.annotation.{RequestMapping, RestController}

@RestController
class ApplicationController {

  @RequestMapping(Array("/"))
  def index = {
    "Application is Started"
  }

  /**
   * 心跳
   * @return
   */
  @RequestMapping(Array("/health"))
  def monitor = {
    "heartbeat is ok"
  }

}
