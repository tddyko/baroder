package co.kr.cobosys.domain.usecase

import androidx.paging.PagingData
import co.kr.cobosys.domain.base.usecase.GeneralPagingUseCase
import co.kr.cobosys.domain.model.RecentlyVisitedStoreList
import co.kr.cobosys.domain.repo.BaroderRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPagingRecentlyVisitedStoreListPagingUseCase @Inject constructor(
    private val pagingRecentlyVisitedStoreList: BaroderRepository
) : GeneralPagingUseCase<Flow<PagingData<RecentlyVisitedStoreList>>, GetPagingRecentlyVisitedStoreListParams> {
    override fun invoke(params: GetPagingRecentlyVisitedStoreListParams): Flow<PagingData<RecentlyVisitedStoreList>> =
        pagingRecentlyVisitedStoreList.getPagingRecentlyVisitedStoreList(params.ids)
}

@JvmInline
value class GetPagingRecentlyVisitedStoreListParams(val ids: String)