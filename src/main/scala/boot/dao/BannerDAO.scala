package boot.dao

import boot.bean.PageBanner
import org.springframework.stereotype.Service

@Service
class BannerDAO extends BaseDAO {
  import ctx._

  def getBanners = {
    ctx.run(quote(query[PageBanner])).map(_.headOption).runToFuture
  }

}
