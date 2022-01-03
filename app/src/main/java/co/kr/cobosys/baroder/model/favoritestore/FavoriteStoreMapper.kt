package co.kr.cobosys.baroder.model.favoritestore

import co.kr.cobosys.baroder.model.favoriteStoreUI
import co.kr.cobosys.domain.base.map.Mapper
import co.kr.cobosys.domain.model.FavoriteStore

class favoriteStoreMapper: Mapper<FavoriteStore, favoriteStoreUI> {
    override fun mapLeftToRight(obj: FavoriteStore): favoriteStoreUI = with(obj) {
        favoriteStoreUI(
            id = id,
            storeName = storeName,
            point = point,
            mainText =  mainText,
            minPoint = minPoint,
            maxPoint = maxPoint,
            coupon = coupon,
            bestProduct = bestProduct,
            bestProductImgUrl = bestProductImgUrl
        )
    }
}