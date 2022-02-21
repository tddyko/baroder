package co.kr.cobosys.data.mappers.point

import co.kr.cobosys.data.api.PointHistoryResponse
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.Add
import co.kr.cobosys.domain.models.PointHistory
import co.kr.cobosys.domain.models.Total
import co.kr.cobosys.domain.models.Use

class PointHistoryMapper: Mapper<PointHistoryResponse, PointHistory> {
    override fun mapLeftToRight(obj: PointHistoryResponse): PointHistory = with(obj) {
        PointHistory(
            total = total.map { total ->
                Total(
                    total.pointCategory,
                    total.pointAmt,
                    total.pointAssignAt
                )
            },
            use = use.map { use ->
                Use(
                    use.pointCategory,
                    use.pointAmt,
                    use.pointAssignAt
                )
            },
            add = add.map { add ->
                Add(
                    add.pointCategory,
                    add.pointAmt,
                    add.pointAssignAt
                )
            }
        )
    }
}