package co.kr.cobosys.domain.usecase

import co.kr.cobosys.domain.base.usecase.GeneralUseCase
import co.kr.cobosys.domain.model.RegularStoreList
import co.kr.cobosys.domain.repo.BaroderRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRegularStoreListUseCase @Inject constructor(
    private val regularStoreRepository: BaroderRepository
) : GeneralUseCase<Flow<RegularStoreList>, GetRegularStoreListParams> {
    override fun invoke(params: GetRegularStoreListParams): Flow<RegularStoreList> =
        regularStoreRepository.getPointList(params.ids)
}

@JvmInline
value class GetRegularStoreListParams(val ids: String)