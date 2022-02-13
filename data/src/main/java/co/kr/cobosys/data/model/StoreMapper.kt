package co.kr.cobosys.data.model

import co.kr.cobosys.data.api.StoreListResponse
import co.kr.cobosys.domain.base.map.Mapper
import co.kr.cobosys.domain.model.StoreList

class StoreMapper: Mapper<StoreListResponse, StoreList> {
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