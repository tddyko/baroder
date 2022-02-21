package co.kr.cobosys.baroder.models.mappers.store

import co.kr.cobosys.baroder.models.StoreDetailUI
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.StoreDetail

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