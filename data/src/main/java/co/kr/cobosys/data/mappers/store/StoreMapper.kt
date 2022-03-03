package co.kr.cobosys.data.mappers.store

import co.kr.cobosys.data.api.StoreListResponse
import co.kr.cobosys.data.api.StoreResponseData
import co.kr.cobosys.data.api.StoreResponseModel
import co.kr.cobosys.domain.models.StoreData
import co.kr.cobosys.domain.models.StoreList
import co.kr.cobosys.domain.models.StoreModel

fun StoreResponseModel.toStoreModel(): StoreModel = StoreModel(
    code, message, data = StoreData(data.storeList.map { list ->
        StoreList(
            list.code,
            list.name,
            list.address,
            list.favorite,
            list.regular,
            list.distance,
            list.imgUrl
        )
    })
)

fun StoreModel.toStoreResponseModel(): StoreResponseModel = StoreResponseModel(
    code, message, data = StoreResponseData(data.storeList.map { list ->
        StoreListResponse(
            list.code,
            list.name,
            list.address,
            list.favorite,
            list.regular,
            list.distance,
            list.imgUrl
        )
    })
)