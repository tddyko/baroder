package co.kr.cobosys.domain.usecases.store

import co.kr.cobosys.domain.base.usecases.GeneralPagingUseCase
import co.kr.cobosys.domain.models.RegularStoreList
import co.kr.cobosys.domain.repos.store.RegularStoreListRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRegularStoreListPagingUseCase @Inject constructor(
    private val regularStoreRepository: RegularStoreListRepo
) : GeneralPagingUseCase<Flow<RegularStoreList>, GetRegularStoreListParams> {
    override fun invoke(params: GetRegularStoreListParams): Flow<RegularStoreList> =
        regularStoreRepository.getRegularStoreList(params.ids)
}

@JvmInline
value class GetRegularStoreListParams(val ids: String)