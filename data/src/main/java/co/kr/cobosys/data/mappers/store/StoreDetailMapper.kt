package co.kr.cobosys.data.mappers.store

import co.kr.cobosys.data.api.StoreDetailResponse
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.StoreDetail

class StoreDetailMapper: Mapper<StoreDetailResponse, StoreDetail> {
    override fun mapLeftToRight(obj: StoreDetailResponse): StoreDetail = with(obj){
        StoreDetail(
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