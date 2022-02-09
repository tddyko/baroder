package co.kr.cobosys.data.model

import co.kr.cobosys.data.api.PointListResponse
import co.kr.cobosys.domain.base.map.Mapper
import co.kr.cobosys.domain.model.PointList

class PointListMapper: Mapper<PointListResponse, PointList> {
    override fun mapLeftToRight(obj: PointListResponse): PointList = with(obj) {
        PointList(
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