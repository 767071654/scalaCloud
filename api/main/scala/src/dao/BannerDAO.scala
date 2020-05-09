package src.dao

import monix.execution.CancelableFuture
import org.springframework.stereotype.Repository
import src.repository.PageBanner

@Repository
class BannerDAO extends BaseDAO {
  import ctx._

  def getBanners(): CancelableFuture[List[PageBanner]] = {
    ctx.run(quote(query[PageBanner])).runToFuture
  }

  def insert(banner: PageBanner): CancelableFuture[Long] = {
    ctx.run(quote(query[PageBanner]).insert(lift(banner)).returningGenerated(_.id)).runToFuture
  }

}
