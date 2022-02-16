package co.kr.cobosys.baroder.model.mappers.store

import co.kr.cobosys.baroder.model.StoreListUI
import co.kr.cobosys.domain.base.map.Mapper
import co.kr.cobosys.domain.model.StoreList

class StoreListMapper: Mapper<StoreList, StoreListUI> {
    override fun mapLeftToRight(obj: StoreList): StoreListUI = with(obj){
        StoreListUI(
            code = code,
            name = name,
            address = address,
            favorite = favorite,
            regular = regular,
            distance = distance,
            imgUrl = imgUrl
        )
    }

}