package co.kr.cobosys.baroder.models.mappers.store

import co.kr.cobosys.baroder.models.MenuListUI
import co.kr.cobosys.baroder.models.ProductListUI
import co.kr.cobosys.baroder.models.StoreDetailDataUI
import co.kr.cobosys.baroder.models.StoreDetailModelUI
import co.kr.cobosys.domain.models.MenuList
import co.kr.cobosys.domain.models.ProductList
import co.kr.cobosys.domain.models.StoreDetailData
import co.kr.cobosys.domain.models.StoreDetailModel

fun StoreDetailModelUI.toStoreDetailModel(): StoreDetailModel = StoreDetailModel(code, message, data = data.map { data ->
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
        data.menuList.map { list ->
            MenuList(
                list.menu,
                list.product.map { product ->
                    ProductList(
                        product.productName,
                        product.productFileName,
                        product.amt
                    )
                }
            )
        }
    )
})

fun StoreDetailModel.toStoreDetailModelUI(): StoreDetailModelUI = StoreDetailModelUI(code, message, data = data.map { data ->
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
        data.menuList.map { list ->
            MenuListUI(
                list.menu,
                list.product.map { product ->
                    ProductListUI(
                        product.productName,
                        product.productFileName,
                        product.amt
                    )
                }
            )
        }
    )
})