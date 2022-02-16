package co.kr.cobosys.data.mappers.point

import co.kr.cobosys.data.api.PointListResponse
import co.kr.cobosys.domain.base.map.Mapper
import co.kr.cobosys.domain.model.PointList

class PointListMapper: Mapper<PointListResponse, PointList> {
    override fun mapLeftToRight(obj: PointListResponse): PointList = with(obj) {
        PointList(
            code = code,
            storeName = storeName,
            point = point,
            pointHistory = pointHistory.map { pointHistory ->
                PointHistoryMapper().mapLeftToRight(pointHistory)
            }
        )
    }
}