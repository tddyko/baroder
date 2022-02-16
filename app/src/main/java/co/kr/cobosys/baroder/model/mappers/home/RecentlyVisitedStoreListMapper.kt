package co.kr.cobosys.baroder.model.mappers.home

import co.kr.cobosys.baroder.model.RecentlyVisitedStoreListUI
import co.kr.cobosys.baroder.model.mappers.store.StoreListMapper
import co.kr.cobosys.domain.base.map.Mapper
import co.kr.cobosys.domain.model.RecentlyVisitedStoreList

class RecentlyVisitedStoreListMapper: Mapper<RecentlyVisitedStoreList, RecentlyVisitedStoreListUI> {
    override fun mapLeftToRight(obj: RecentlyVisitedStoreList): RecentlyVisitedStoreListUI = with(obj) {
        RecentlyVisitedStoreListUI(
            recentlyStoreList = recentlyStoreList.map { recently ->
                StoreListMapper().mapLeftToRight(recently)
            }
        )
    }
}