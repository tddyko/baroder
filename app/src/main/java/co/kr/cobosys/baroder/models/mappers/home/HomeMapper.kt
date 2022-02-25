package co.kr.cobosys.baroder.models.mappers.home

import co.kr.cobosys.baroder.models.HomeDataUI
import co.kr.cobosys.baroder.models.HomeModelUI
import co.kr.cobosys.baroder.models.mappers.store.RegularStoreListMapper
import co.kr.cobosys.baroder.models.mappers.store.StoreListMapper
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.HomeModel

class HomeMapper : Mapper<HomeModel, HomeModelUI> {
    override fun mapLeftToRight(obj: HomeModel): HomeModelUI = with(obj) {
        HomeModelUI(
            code = code,
            message = message,
            data = data.map { data ->
                HomeDataUI(
                    data.regularStoreList.map { regular ->
                        RegularStoreListMapper().mapLeftToRight(regular.copy())
                    },
                    data.recentlyVisitedStoreList.map { recent ->
                        StoreListMapper().mapLeftToRight(recent.copy())
                    })
            }
        )
    }
}