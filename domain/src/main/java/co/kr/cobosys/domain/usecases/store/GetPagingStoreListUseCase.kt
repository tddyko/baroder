package co.kr.cobosys.domain.usecases.store

import androidx.paging.PagingData
import co.kr.cobosys.domain.base.usecases.GeneralPagingUseCase
import co.kr.cobosys.domain.models.StoreList
import co.kr.cobosys.domain.repos.store.PagingStoreListRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPagingStoreListUseCase @Inject constructor(
    private val pagingStoreList: PagingStoreListRepo
) : GeneralPagingUseCase<Flow<PagingData<StoreList>>, GetPagingStoreListParams> {
    override fun invoke(params: GetPagingStoreListParams): Flow<PagingData<StoreList>> =
        pagingStoreList.getPagingStoreList(params.ids)
}

@JvmInline
value class GetPagingStoreListParams(val ids: String)