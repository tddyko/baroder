package co.kr.cobosys.data.model

import co.kr.cobosys.data.api.FavoriteStoreResponse
import co.kr.cobosys.domain.base.map.Mapper
import co.kr.cobosys.domain.model.favoriteStore

class FavoriteStoreMapper: Mapper<FavoriteStoreResponse, favoriteStore> {
    override fun mapLeftToRight(obj: FavoriteStoreResponse): favoriteStore = with(obj) {
        favoriteStore(
            id = id,
            storeName = storeName,
            point = point,
            mainText = mainText,
            minPoint = minPoint,
            maxPoint = maxPoint,
            coupon = coupon,
            bestProduct = bestProduct,
            bestProductImgUrl = bestProductImgUrl
        )
    }
}