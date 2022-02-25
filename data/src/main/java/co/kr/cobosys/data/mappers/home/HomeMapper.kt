package co.kr.cobosys.data.mappers.home

import co.kr.cobosys.data.api.HomeResponseModel
import co.kr.cobosys.data.mappers.store.RegularStoreListMapper
import co.kr.cobosys.data.mappers.store.StoreListMapper
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.HomeData
import co.kr.cobosys.domain.models.HomeModel

class HomeMapper : Mapper<HomeResponseModel, HomeModel> {
    override fun mapLeftToRight(obj: HomeResponseModel): HomeModel = with(obj) {
        HomeModel(
            code = code,
            message = message,
            data = data.map { data ->
                HomeData(
                    data.regularStoreList.map { regular ->
                        RegularStoreListMapper().mapLeftToRight(regular.copy())
                    },
                    data.recentlyVisitedStoreList.map { recently ->
                        StoreListMapper().mapLeftToRight(recently.copy())
                    }
                )
            }
        )
    }
}