package co.kr.cobosys.baroder.models.mappers.store

import co.kr.cobosys.baroder.models.StoreDataUI
import co.kr.cobosys.baroder.models.StoreListUI
import co.kr.cobosys.baroder.models.StoreModelUI
import co.kr.cobosys.domain.models.StoreData
import co.kr.cobosys.domain.models.StoreList
import co.kr.cobosys.domain.models.StoreModel

fun StoreModelUI.toStoreModel(): StoreModel = StoreModel(
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

fun StoreModel.toStoreModelUI(): StoreModelUI = StoreModelUI(
    code, message, data = StoreDataUI(data.storeList.map { list ->
        StoreListUI(
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