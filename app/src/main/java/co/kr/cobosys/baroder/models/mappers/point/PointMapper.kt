package co.kr.cobosys.baroder.models.mappers.point

import co.kr.cobosys.baroder.models.*
import co.kr.cobosys.domain.models.*

fun PointModelUI.toPointModel(): PointModel = PointModel(
    code, message, data = PointData(data.pointList.map { list ->
        PointList(
            list.code,
            list.storeName,
            list.point,
            list.pointHistory.map { history ->
                PointHistory(
                    history.total.map { total ->
                        Total(
                            total.pointCategory,
                            total.pointAmt,
                            total.pointAssignAt
                        )
                    },
                    history.use.map { use ->
                        Use(
                            use.pointCategory,
                            use.pointAmt,
                            use.pointAssignAt
                        )
                    },
                    history.add.map { add ->
                        Add(
                            add.pointCategory,
                            add.pointAmt,
                            add.pointAssignAt
                        )
                    }
                )
            }
        )
    })
)

fun PointModel.toPointModelUI(): PointModelUI = PointModelUI(
    code, message, data = PointDataUI(data.pointList.map { list ->
        PointListUI(
            list.code,
            list.storeName,
            list.point,
            list.pointHistory.map { history ->
                PointHistoryUI(
                    history.total.map { total ->
                        TotalUI(
                            total.pointCategory,
                            total.pointAmt,
                            total.pointAssignAt
                        )
                    },
                    history.use.map { use ->
                        UseUI(
                            use.pointCategory,
                            use.pointAmt,
                            use.pointAssignAt
                        )
                    },
                    history.add.map { add ->
                        AddUI(
                            add.pointCategory,
                            add.pointAmt,
                            add.pointAssignAt
                        )
                    }
                )
            }
        )
    })
)