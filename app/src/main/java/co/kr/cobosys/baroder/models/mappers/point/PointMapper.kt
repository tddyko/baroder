package co.kr.cobosys.baroder.models.mappers.point

import co.kr.cobosys.baroder.models.*
import co.kr.cobosys.domain.models.*

fun PointModelUI.toPointModel(): PointModel = PointModel(
    code, message, data = PointData(data.pointList.map { list ->
        PointList(
            list.code,
            list.storeName,
            list.point,
            PointHistory(
                list.pointHistory.total.map { total ->
                    Total(
                        total.pointCategory,
                        total.pointAmt,
                        total.pointAssignAt
                    )
                },
                list.pointHistory.use.map { use ->
                    Use(
                        use.pointCategory,
                        use.pointAmt,
                        use.pointAssignAt
                    )
                },
                list.pointHistory.add.map { add ->
                    Add(
                        add.pointCategory,
                        add.pointAmt,
                        add.pointAssignAt
                    )
                }
            )
        )
    }

//    code, message, data = PointData(data.pointList.map { list ->
//        PointList(
//            list.code,
//            list.storeName,
//            list.point,
//            PointHistory(
//                list.pointHistory.total.map { total ->
//                    Total(
//                        total.pointCategory,
//                        total.pointAmt,
//                        total.pointAssignAt
//                    )
//                },
//                list.pointHistory.use.map { use ->
//                    Use(
//                        use.pointCategory,
//                        use.pointAmt,
//                        use.pointAssignAt
//                    )
//                },
//                list.pointHistory.add.map { add ->
//                    Add(
//                        add.pointCategory,
//                        add.pointAmt,
//                        add.pointAssignAt
//                    )
//                }
//            )
//        )
//    }
    )
)

fun PointModel.toPointModelUI(): PointModelUI = PointModelUI(
    code, message, data = PointDataUI(data.pointList.map { list ->
        PointListUI(
            list.code,
            list.storeName,
            list.point,

            PointHistoryUI(
                list.pointHistory.total.map { total ->
                    TotalUI(
                        total.pointCategory,
                        total.pointAmt,
                        total.pointAssignAt
                    )
                },
                list.pointHistory.use.map { use ->
                    UseUI(
                        use.pointCategory,
                        use.pointAmt,
                        use.pointAssignAt
                    )
                },
                list.pointHistory.add.map { add ->
                    AddUI(
                        add.pointCategory,
                        add.pointAmt,
                        add.pointAssignAt
                    )
                }
            )

        )
    })
)