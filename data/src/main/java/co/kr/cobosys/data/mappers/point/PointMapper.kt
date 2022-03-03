package co.kr.cobosys.data.mappers.point

import co.kr.cobosys.data.api.*
import co.kr.cobosys.domain.models.*

fun PointResponseModel.toPointModel(): PointModel = PointModel(
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

fun PointModel.toPointResponseModel(): PointResponseModel = PointResponseModel(
    code, message, data = PointResponseData(data.pointList.map { list ->
        PointListResponse(
            list.code,
            list.storeName,
            list.point,
            list.pointHistory.map { history ->
                PointHistoryResponse(
                    history.total.map { total ->
                        TotalResponse(
                            total.pointCategory,
                            total.pointAmt,
                            total.pointAssignAt
                        )
                    },
                    history.use.map { use ->
                        UseResponse(
                            use.pointCategory,
                            use.pointAmt,
                            use.pointAssignAt
                        )
                    },
                    history.add.map { add ->
                        AddResponse(
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