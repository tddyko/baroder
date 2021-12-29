package co.kr.cobosys.data.model

import co.kr.cobosys.data.api.FavoriteStoreResponse
import co.kr.cobosys.domain.base.map.Mapper
import co.kr.cobosys.domain.model.FavoriteStore

class FavoriteStoreMapper: Mapper<FavoriteStoreResponse, FavoriteStore> {
    override fun mapLeftToRight(obj: FavoriteStoreResponse): FavoriteStore = with(obj) {
        FavoriteStore(
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