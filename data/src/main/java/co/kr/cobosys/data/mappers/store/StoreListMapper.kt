package co.kr.cobosys.data.mappers.store

import co.kr.cobosys.data.api.StoreListResponse
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.StoreList

class StoreListMapper: Mapper<StoreListResponse, StoreList> {
    override fun mapLeftToRight(obj: StoreListResponse): StoreList = with(obj){
        StoreList(
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