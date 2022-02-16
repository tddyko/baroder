package co.kr.cobosys.baroder.model.mappers.store

import co.kr.cobosys.baroder.model.StoreDetailUI
import co.kr.cobosys.data.api.StoreDetailResponse
import co.kr.cobosys.domain.base.map.Mapper
import co.kr.cobosys.domain.model.StoreDetail

class StoreDetailMapper: Mapper<StoreDetail, StoreDetailUI> {
    override fun mapLeftToRight(obj: StoreDetail): StoreDetailUI = with(obj){
        StoreDetailUI(
            code = code,
            storeName = storeName,
            address = address,
            addressDetail = addressDetail,
            storeInfo = storeInfo,
            businessHour = businessHour,
            storeLatitude = storeLatitude,
            storeLongitude = storeLongitude,
            couponCount = couponCount,
            favoriteStatus = favoriteStatus,
            regular = regular,
            distance = distance,
            telNumber = telNumber,
            imgUrl = imgUrl,
            menuList = menuList.map { menu ->
                MenuListMapper().mapLeftToRight(menu)
            }
        )
    }
}