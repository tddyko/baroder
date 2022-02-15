package co.kr.cobosys.data.model

import co.kr.cobosys.data.api.RegularStoreListResponse
import co.kr.cobosys.domain.base.map.Mapper
import co.kr.cobosys.domain.model.RegularStoreList

class RegularStoreListMapper: Mapper<RegularStoreListResponse, RegularStoreList> {
    override fun mapLeftToRight(obj: RegularStoreListResponse): RegularStoreList = with(obj) {
        RegularStoreList(
            code = code,
            regularStoreName = storeName,
            point = point,
            minPoint = minPoint,
            maxPoint = maxPoint,
            coupon = coupon,
            bestProduct = bestProduct.map { product ->
                RegularBestProductMapper().mapLeftToRight(product)
            },
            bestProductImgUrl = bestProductImgUrl
        )
    }
}