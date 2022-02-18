package co.kr.cobosys.domain.usecase

import co.kr.cobosys.domain.base.usecase.GeneralPagingUseCase
import co.kr.cobosys.domain.model.RegularStoreList
import co.kr.cobosys.domain.repo.BaroderRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRegularStoreListPagingUseCase @Inject constructor(
    private val regularStoreRepository: BaroderRepository
) : GeneralPagingUseCase<Flow<RegularStoreList>, GetRegularStoreListParams> {
    override fun invoke(params: GetRegularStoreListParams): Flow<RegularStoreList> =
        regularStoreRepository.getRegularStoreList(params.ids)
}

@JvmInline
value class GetRegularStoreListParams(val ids: String)