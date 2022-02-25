package co.kr.cobosys.data.mappers.point

import co.kr.cobosys.data.api.PointResponseModel
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.PointData
import co.kr.cobosys.domain.models.PointModel

class PointMapper : Mapper<PointResponseModel, PointModel> {
    override fun mapLeftToRight(obj: PointResponseModel): PointModel = with(obj) {
        PointModel(
            code = code,
            message = message,
            data = PointData(data.pointList.map { list ->
                PointListMapper().mapLeftToRight(list.copy())
            })
        )
    }
}