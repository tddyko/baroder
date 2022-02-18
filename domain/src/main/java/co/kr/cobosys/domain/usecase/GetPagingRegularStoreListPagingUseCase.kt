package co.kr.cobosys.domain.usecase

import androidx.paging.PagingData
import co.kr.cobosys.domain.base.usecase.GeneralPagingUseCase
import co.kr.cobosys.domain.model.RegularStoreList
import co.kr.cobosys.domain.repo.BaroderRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPagingRegularStoreListPagingUseCase @Inject constructor(
    private val regularStoreRepository: BaroderRepository
) : GeneralPagingUseCase<Flow<PagingData<RegularStoreList>>, GetPagingRegularStoreListParams> {
    override fun invoke(params: GetPagingRegularStoreListParams): Flow<PagingData<RegularStoreList>> =
        regularStoreRepository.getPagingRegularStoreList(params.ids)
}

@JvmInline
value class GetPagingRegularStoreListParams(val ids: String)