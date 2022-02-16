package co.kr.cobosys.baroder.model.mappers.point

import co.kr.cobosys.baroder.model.AddUI
import co.kr.cobosys.baroder.model.PointHistoryUI
import co.kr.cobosys.baroder.model.TotalUI
import co.kr.cobosys.baroder.model.UseUI
import co.kr.cobosys.domain.base.map.Mapper
import co.kr.cobosys.domain.model.PointHistory

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