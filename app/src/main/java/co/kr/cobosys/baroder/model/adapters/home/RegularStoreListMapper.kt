package co.kr.cobosys.baroder.model.adapters.home

import co.kr.cobosys.baroder.model.RegularStoreListUI
import co.kr.cobosys.domain.base.map.Mapper
import co.kr.cobosys.domain.model.RegularStoreList

class RegularStoreListMapper : Mapper<RegularStoreList, RegularStoreListUI> {
    override fun mapLeftToRight(obj: RegularStoreList): RegularStoreListUI = with(obj) {
        RegularStoreListUI(
            code = code,
            storeName = storeName,
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