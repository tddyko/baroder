package co.kr.cobosys.data.mappers.store

import co.kr.cobosys.data.api.*
import co.kr.cobosys.domain.models.StoreData
import co.kr.cobosys.domain.models.StoreList
import co.kr.cobosys.domain.models.StoreModel

fun StoreResponseModel.toStoreModel(): StoreModel = StoreModel(
    code, message, data = StoreData(data.storeList.map { list ->
        StoreList(
            list.store.code,
            list.store.name,
            list.store.address,
            list.store.favorite,
            list.store.regular,
            list.store.distance,
            list.images.map { i -> i.imgUrl }
        )
    })
)

fun StoreModel.toStoreResponseModel(): StoreResponseModel = StoreResponseModel(
    code, message, data = StoreResponseData(data.storeList.map { list ->
        StoreListResponse(
            StoreListItemResponse(
                list.code,
                list.name,
                list.address,
                list.favorite,
                list.regular,
                list.distance
            ),
            (if (null != list.imgUrl) { list.imgUrl!!.map { i -> StoreListItemImageResponse(i) } } else { emptyList() }) as List<StoreListItemImageResponse>
        )
    })
)