package co.kr.cobosys.baroder.model.mappers.home

import co.kr.cobosys.baroder.model.HomeUI
import co.kr.cobosys.domain.base.map.Mapper
import co.kr.cobosys.domain.model.Home

class HomeMapper: Mapper<Home, HomeUI> {
    override fun mapLeftToRight(obj:Home): HomeUI = with(obj) {
        HomeUI(
            regularStoreList = regularStoreList.map { regular ->
                RegularStoreListMapper().mapLeftToRight(regular)
            },
            recentlyVisitedStoreList = recentlyVisitedStoreList.map { recently ->
                RecentlyVisitedStoreListMapper().mapLeftToRight(recently)
            }
        )
    }
}