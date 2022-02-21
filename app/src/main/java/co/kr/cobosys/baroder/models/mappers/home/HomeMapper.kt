package co.kr.cobosys.baroder.models.mappers.home

import co.kr.cobosys.baroder.models.HomeUI
import co.kr.cobosys.baroder.models.mappers.store.RegularStoreListMapper
import co.kr.cobosys.baroder.models.mappers.store.StoreListMapper
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.Home

class HomeMapper: Mapper<Home, HomeUI> {
    override fun mapLeftToRight(obj:Home): HomeUI = with(obj) {
        HomeUI(
            regularStoreList = regularStoreList.map { regular ->
                RegularStoreListMapper().mapLeftToRight(regular)
            },
             recentlyVisitedStoreList = recentlyVisitedStoreList.map { recently ->
                StoreListMapper().mapLeftToRight(recently)
            }
        )
    }
}