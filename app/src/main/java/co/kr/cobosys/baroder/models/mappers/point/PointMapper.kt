package co.kr.cobosys.baroder.models.mappers.point

import co.kr.cobosys.baroder.models.PointDataUI
import co.kr.cobosys.baroder.models.PointListUI
import co.kr.cobosys.baroder.models.PointModelUI
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.PointModel

class PointMapper: Mapper<PointModel, PointModelUI> {
    override fun mapLeftToRight(obj: PointModel): PointModelUI = with(obj) {
        PointModelUI(
            code = code,
            message = message,
            data = PointDataUI(data.pointList.map { data ->
                PointListMapper().mapLeftToRight(
                    data.copy()
                )
            })
        )
    }
}