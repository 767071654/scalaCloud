package src.dao

import io.getquill.context.monix.Runner
import io.getquill._
import monix.execution.Scheduler


trait BaseDAO {
  //getQuill-DBConnect
  lazy val ctx = new MysqlMonixJdbcContext(SnakeCase, "ctx", Runner.default) with ImplicitQuery
  implicit val scheduler: Scheduler = Scheduler.global
}
