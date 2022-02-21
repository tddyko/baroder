package co.kr.cobosys.baroder.models.mappers.point

import co.kr.cobosys.baroder.models.AddUI
import co.kr.cobosys.baroder.models.PointHistoryUI
import co.kr.cobosys.baroder.models.TotalUI
import co.kr.cobosys.baroder.models.UseUI
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.PointHistory

class PointHistoryMapper: Mapper<PointHistory, PointHistoryUI> {
    override fun mapLeftToRight(obj: PointHistory): PointHistoryUI = with(obj) {
        PointHistoryUI(
            total = total.map { total ->
                TotalUI(
                    total.pointCategory,
                    total.pointAmt,
                    total.pointAssignAt
                )
            },
            use = use.map { use ->
                UseUI(
                    use.pointCategory,
                    use.pointAmt,
                    use.pointAssignAt
                )
            },
            add = add.map { add ->
                AddUI(
                    add.pointCategory,
                    add.pointAmt,
                    add.pointAssignAt
                )
            }
        )
    }
}