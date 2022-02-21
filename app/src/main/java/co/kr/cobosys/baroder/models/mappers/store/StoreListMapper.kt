package co.kr.cobosys.baroder.models.mappers.store

import co.kr.cobosys.baroder.models.StoreListUI
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.StoreList

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