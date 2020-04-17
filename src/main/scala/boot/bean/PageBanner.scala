package boot.bean

import scala.beans.BeanProperty

case class PageBanner(
  @BeanProperty
  id:  Long = 0L,
  @BeanProperty
  title:  String,  //轮播图标题
  @BeanProperty
  images:  String,  //图片
  @BeanProperty
  targetUri:  Option[String] = None,  //链接地址
  @BeanProperty
  createAt:  Int = 0,  //null
  @BeanProperty
  updateAt:  Int = 0,  //null
)
