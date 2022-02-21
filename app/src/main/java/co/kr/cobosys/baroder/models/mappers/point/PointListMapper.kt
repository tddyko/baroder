package co.kr.cobosys.baroder.models.mappers.point

import co.kr.cobosys.baroder.models.PointListUI
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.PointList

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