package co.kr.cobosys.data.mappers.home

import co.kr.cobosys.data.api.RegularStoreListResponse
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.RegularStoreList

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