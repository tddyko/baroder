package co.kr.cobosys.data.mappers.store

import co.kr.cobosys.data.api.MenuListResponse
import co.kr.cobosys.data.api.ProductListResponse
import co.kr.cobosys.data.api.StoreDetailResponseData
import co.kr.cobosys.data.api.StoreDetailResponseModel
import co.kr.cobosys.domain.models.MenuList
import co.kr.cobosys.domain.models.ProductList
import co.kr.cobosys.domain.models.StoreDetailData
import co.kr.cobosys.domain.models.StoreDetailModel

fun StoreDetailResponseModel.toStoreDetialModel(): StoreDetailModel = StoreDetailModel(
    code, message, data = data.map { data ->
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
    }
)

fun StoreDetailModel.toStoreDetialResponseModel(): StoreDetailResponseModel = StoreDetailResponseModel(
    code, message, data = data.map { data ->
        StoreDetailResponseData(
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
                MenuListResponse(
                    list.menu,
                    list.product.map { product ->
                        ProductListResponse(
                            product.productName,
                            product.productFileName,
                            product.amt
                        )
                    }
                )
            }
        )
    }
)