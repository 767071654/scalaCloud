package webserver.dao

import monix.execution.CancelableFuture
import webserver.repository.PageBanner
import org.springframework.stereotype.Service

@Service
class BannerDAO extends BaseDAO {
  import ctx._

  def getBanners(): CancelableFuture[List[PageBanner]] = {
    ctx.run(quote(query[PageBanner])).runToFuture
  }

  def insert(banner: PageBanner): CancelableFuture[Long] = {
    ctx.run(quote(query[PageBanner]).insert(lift(banner)).returningGenerated(_.id)).runToFuture
  }

}
