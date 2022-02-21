package co.kr.cobosys.baroder.models.mappers.store

import co.kr.cobosys.baroder.models.RegularStoreListUI
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.RegularStoreList

class RegularStoreListMapper : Mapper<RegularStoreList, RegularStoreListUI> {
    override fun mapLeftToRight(obj: RegularStoreList): RegularStoreListUI = with(obj) {
        RegularStoreListUI(
            code = code,
            regularStoreName = regularStoreName,
            point = point,
            minPoint = minPoint,
            maxPoint = maxPoint,
            coupon = coupon,
            bestProductImgUrl = bestProductImgUrl,
            bestProduct = bestProduct.map { product ->
                ProductListMapper().mapLeftToRight(product)
            }
        )
    }
}