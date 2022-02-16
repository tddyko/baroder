package co.kr.cobosys.data.mappers.point

import co.kr.cobosys.data.api.PointHistoryResponse
import co.kr.cobosys.domain.base.map.Mapper
import co.kr.cobosys.domain.model.Add
import co.kr.cobosys.domain.model.PointHistory
import co.kr.cobosys.domain.model.Total
import co.kr.cobosys.domain.model.Use

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