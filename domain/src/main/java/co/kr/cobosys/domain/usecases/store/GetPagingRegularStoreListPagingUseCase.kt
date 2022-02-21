package co.kr.cobosys.domain.usecases.store

import androidx.paging.PagingData
import co.kr.cobosys.domain.base.usecases.GeneralPagingUseCase
import co.kr.cobosys.domain.models.RegularStoreList
import co.kr.cobosys.domain.repos.store.PagingRegularStoreListRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPagingRegularStoreListPagingUseCase @Inject constructor(
    private val regularStoreRepository: PagingRegularStoreListRepo
) : GeneralPagingUseCase<Flow<PagingData<RegularStoreList>>, GetPagingRegularStoreListParams> {
    override fun invoke(params: GetPagingRegularStoreListParams): Flow<PagingData<RegularStoreList>> =
        regularStoreRepository.getPagingRegularStoreList(params.ids)
}

@JvmInline
value class GetPagingRegularStoreListParams(val ids: String)