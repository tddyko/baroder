package co.kr.cobosys.data.mappers.home

import co.kr.cobosys.data.api.HomeResponse
import co.kr.cobosys.domain.base.map.Mapper
import co.kr.cobosys.domain.model.Home

class HomeMapper: Mapper<HomeResponse, Home> {
    override fun mapLeftToRight(obj: HomeResponse): Home = with(obj) {
        Home(
            regularStoreList = regularStoreList.map { regular ->
                RegularStoreListMapper().mapLeftToRight(regular)
            },
            recentlyVisitedStoreList = recentlyVisitedStoreList.map { recently ->
                RecentlyVisitedStoreListMapper().mapLeftToRight(recently)
            }
        )
    }
}