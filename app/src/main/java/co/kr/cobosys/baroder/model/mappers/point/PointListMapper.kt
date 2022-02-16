package co.kr.cobosys.baroder.model.mappers.point

import co.kr.cobosys.baroder.model.PointListUI
import co.kr.cobosys.data.api.PointListResponse
import co.kr.cobosys.domain.base.map.Mapper
import co.kr.cobosys.domain.model.PointList

class PointListMapper: Mapper<PointList, PointListUI> {
    override fun mapLeftToRight(obj: PointList): PointListUI = with(obj) {
        PointListUI(
            code = code,
            storeName = storeName,
            point = point,
            pointHistory = pointHistory.map { pointHistory ->
                PointHistoryMapper().mapLeftToRight(pointHistory)
            }
        )
    }
}