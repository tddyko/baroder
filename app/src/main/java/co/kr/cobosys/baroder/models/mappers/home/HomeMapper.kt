package co.kr.cobosys.baroder.models.mappers.home

import co.kr.cobosys.baroder.models.*
import co.kr.cobosys.domain.models.*

fun HomeModelUI.toHomeModel(): HomeModel = HomeModel(
    code, message, data = data.map { data ->
        HomeData(
            data.regularStoreList.map { regular ->
                RegularStoreList(
                    regular.code,
                    regular.regularStoreName,
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

fun HomeModel.toHomeModelUI(): HomeModelUI = HomeModelUI(
    code, message, data = data.map { data ->
        HomeDataUI(
            data.regularStoreList.map { regular ->
                RegularStoreListUI(
                    regular.code,
                    regular.regularStoreName,
                    regular.point,
                    regular.maxPoint,
                    regular.minPoint,
                    regular.coupon,
                    regular.bestProductImgUrl,
                    regular.bestProduct.map { best ->
                        ProductListUI(
                            best.productName,
                            best.productFileName,
                            best.amt
                        )
                    }
                )
            },
            data.recentlyVisitedStoreList.map { recent ->
                StoreListUI(
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