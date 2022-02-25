package co.kr.cobosys.baroder.models.mappers.store

import co.kr.cobosys.baroder.models.StoreDetailDataUI
import co.kr.cobosys.baroder.models.StoreDetailModelUI
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.StoreDetailModel

class StoreDetailMapper: Mapper<StoreDetailModel, StoreDetailModelUI> {
    override fun mapLeftToRight(obj: StoreDetailModel): StoreDetailModelUI = with(obj){
        StoreDetailModelUI(
            code = code,
            message = message,
            data = data.map { data ->
                StoreDetailDataUI(
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