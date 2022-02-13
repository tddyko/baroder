package co.kr.cobosys.baroder.model.adapters.home

import co.kr.cobosys.baroder.model.RecentlyVisitedStoreListUI
import co.kr.cobosys.domain.base.map.Mapper
import co.kr.cobosys.domain.model.RecentlyVisitedStoreList

class RecentlyVisitedStoreListMapper: Mapper<RecentlyVisitedStoreList, RecentlyVisitedStoreListUI> {
    override fun mapLeftToRight(obj: RecentlyVisitedStoreList): RecentlyVisitedStoreListUI = with(obj) {
        RecentlyVisitedStoreListUI(
            code = code,
            storeName = storeName,
            address = address,
            favorite = favorite,
            regular = regular,
            distance = distance,
            storeImgUrl = storeImgUrl
        )
    }
}