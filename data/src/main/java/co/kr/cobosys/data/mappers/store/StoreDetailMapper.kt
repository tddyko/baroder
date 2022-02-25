package co.kr.cobosys.data.mappers.store

import co.kr.cobosys.data.api.StoreDetailResponseModel
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.MenuList
import co.kr.cobosys.domain.models.StoreDetailData
import co.kr.cobosys.domain.models.StoreDetailModel

class StoreDetailMapper : Mapper<StoreDetailResponseModel, StoreDetailModel> {
    override fun mapLeftToRight(obj: StoreDetailResponseModel): StoreDetailModel = with(obj) {
        StoreDetailModel(
            code = code,
            message = message,
            data = data.map { data ->
                StoreDetailData(
                    data.code,
                    data.storeName,
                    data.address,
                    data.addressDetail,
                    data.storeInfo,
                    data.businessHour,
                    data.storeLatitude,
                    data.storeLongitude,
                    data.couponCount,
                    data.favoriteStatus,
                    data.regular,
                    data.distance,
                    data.telNumber,
                    data.imgUrl,
                    data.menuList.map { menu ->
                        MenuListMapper().mapLeftToRight(menu.copy())
                    }
                )
            }
        )
    }
}