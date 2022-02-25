package co.kr.cobosys.baroder.models.mappers.store

import co.kr.cobosys.baroder.models.StoreDataUI
import co.kr.cobosys.baroder.models.StoreModelUI
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.StoreModel

class StoreMapper: Mapper<StoreModel, StoreModelUI> {
    override fun mapLeftToRight(obj:StoreModel): StoreModelUI = with(obj) {
       StoreModelUI(
           code = code,
           message = message,
           data = StoreDataUI(data.storeList.map { list ->
               StoreListMapper().mapLeftToRight(list.copy())
           })
       )
    }
}