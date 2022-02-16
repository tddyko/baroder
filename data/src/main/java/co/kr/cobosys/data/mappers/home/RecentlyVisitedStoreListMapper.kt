package co.kr.cobosys.data.mappers.home

import co.kr.cobosys.data.api.RecentlyVisitedStoreListResponse
import co.kr.cobosys.data.mappers.store.StoreListMapper
import co.kr.cobosys.domain.base.map.Mapper
import co.kr.cobosys.domain.model.RecentlyVisitedStoreList

class RecentlyVisitedStoreListMapper: Mapper<RecentlyVisitedStoreListResponse, RecentlyVisitedStoreList> {
    override fun mapLeftToRight(obj: RecentlyVisitedStoreListResponse): RecentlyVisitedStoreList = with(obj) {
        RecentlyVisitedStoreList(
            recentlyStoreList = recentlyStoreList.map { storeList ->
                StoreListMapper().mapLeftToRight(storeList)
            }
        )
    }
}