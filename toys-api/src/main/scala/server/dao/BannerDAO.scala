package server.dao

import com.typesafe.scalalogging.LazyLogging
import monix.execution.CancelableFuture
import org.springframework.stereotype.Repository
import server.repository.PageBanner

@Repository
class BannerDAO extends BaseDAO with LazyLogging {
  import ctx._

  def getBanners(): CancelableFuture[List[PageBanner]] = {
    ctx.run(quote(query[PageBanner])).runToFuture
  }

  def insert(banner: PageBanner): CancelableFuture[Any] = {
    ctx.run(quote(query[PageBanner]).insert(lift(banner)).returningGenerated(_.id)).runToFuture.recover {
      case e: Exception => logger.error("ss", e)
    }
  }

}
