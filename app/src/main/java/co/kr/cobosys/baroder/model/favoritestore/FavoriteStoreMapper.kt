package co.kr.cobosys.baroder.model.favoritestore

import co.kr.cobosys.baroder.model.FavoriteStoreUI
import co.kr.cobosys.domain.base.map.Mapper
import co.kr.cobosys.domain.model.FavoriteStore

class FavoriteStoreMapper: Mapper<FavoriteStore, FavoriteStoreUI> {
    override fun mapLeftToRight(obj: FavoriteStore): FavoriteStoreUI = with(obj) {
        FavoriteStoreUI(
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