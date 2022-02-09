package co.kr.cobosys.baroder.model.pointlist

import co.kr.cobosys.baroder.model.PointListUI
import co.kr.cobosys.domain.base.map.Mapper
import co.kr.cobosys.domain.model.PointList

class PointListMapper: Mapper<PointList, PointListUI> {
    override fun mapLeftToRight(obj: PointList): PointListUI = with(obj) {
        PointListUI(
            code = code,
            storeName = storeName,
            point = point,
            minPoint = minPoint,
            maxPoint = maxPoint,
            coupon = coupon,
            bestProduct = bestProduct,
            bestProductImgUrl = bestProductImgUrl
        )
    }
}