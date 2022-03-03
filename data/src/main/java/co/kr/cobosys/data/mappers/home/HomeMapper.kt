package co.kr.cobosys.data.mappers.home

import co.kr.cobosys.data.api.*
import co.kr.cobosys.domain.models.*

fun HomeResponseModel.toHomeModel(): HomeModel = HomeModel(
    code, message, data = data.map { data ->
        HomeData(
            data.regularStoreList.map { regular ->
                RegularStoreList(
                    regular.code,
                    regular.storeName,
                    regular.point,
                    regular.maxPoint,
                    regular.minPoint,
                    regular.coupon,
                    regular.bestProductImgUrl,
                    regular.bestProduct.map { best ->
                        ProductList(
                            best.productName,
                            best.productFileName,
                            best.amt
                        )
                    }
                )
            },
            data.recentlyVisitedStoreList.map { recent ->
                StoreList(
                    recent.code,
                    recent.name,
                    recent.address,
                    recent.favorite,
                    recent.regular,
                    recent.distance,
                    recent.imgUrl
                )
            }
        )
    }
)

fun HomeModel.toHomeResponseModel(): HomeResponseModel = HomeResponseModel(
    code, message, data = data.map { data ->
        HomeResponseData(
            data.regularStoreList.map { regular ->
                RegularStoreListResponse(
                    regular.code,
                    regular.regularStoreName,
                    regular.point,
                    regular.maxPoint,
                    regular.minPoint,
                    regular.coupon,
                    regular.bestProductImgUrl,
                    regular.bestProduct.map { best ->
                        ProductListResponse(
                            best.productName,
                            best.productFileName,
                            best.amt
                        )
                    }
                )
            },
            data.recentlyVisitedStoreList.map { recent ->
                StoreListResponse(
                    recent.code,
                    recent.name,
                    recent.address,
                    recent.favorite,
                    recent.regular,
                    recent.distance,
                    recent.imgUrl
                )
            }
        )
    }
)