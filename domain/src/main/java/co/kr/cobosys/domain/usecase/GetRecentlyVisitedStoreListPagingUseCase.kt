package co.kr.cobosys.domain.usecase

import co.kr.cobosys.domain.base.usecase.GeneralPagingUseCase
import co.kr.cobosys.domain.model.RecentlyVisitedStoreList
import co.kr.cobosys.domain.repo.BaroderRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRecentlyVisitedStoreListPagingUseCase @Inject constructor(
    private val recentlyVisitedStoreList: BaroderRepository
) : GeneralPagingUseCase<Flow<RecentlyVisitedStoreList>, GetRecentlyVisitedStoreListParams> {
    override fun invoke(params: GetRecentlyVisitedStoreListParams): Flow<RecentlyVisitedStoreList> =
        recentlyVisitedStoreList.getRecentlyVisitedStoreList(params.ids)
}

@JvmInline
value class GetRecentlyVisitedStoreListParams(val ids: String)