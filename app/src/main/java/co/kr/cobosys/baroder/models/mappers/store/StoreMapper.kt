package co.kr.cobosys.baroder.models.mappers.store

import co.kr.cobosys.baroder.models.StoreUI
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.Store

class StoreMapper: Mapper<Store, StoreUI> {
    override fun mapLeftToRight(obj:Store): StoreUI = with(obj) {
        StoreUI(
            storeList = storeList.map { storeList ->
                StoreListMapper().mapLeftToRight(storeList)
            }
        )
    }
}