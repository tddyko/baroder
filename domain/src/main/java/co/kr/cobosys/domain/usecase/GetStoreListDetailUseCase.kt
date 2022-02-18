package co.kr.cobosys.domain.usecase

import co.kr.cobosys.domain.base.usecase.GeneralPagingUseCase
import co.kr.cobosys.domain.model.StoreDetail
import co.kr.cobosys.domain.repo.BaroderRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetStoreListDetailUseCase @Inject constructor(
    private val storeDetail: BaroderRepository
) : GeneralPagingUseCase<Flow<StoreDetail>, GetStoreListDetailParams> {
    override fun invoke(params: GetStoreListDetailParams): Flow<StoreDetail> =
        storeDetail.getStoreDetail(params.ids)
}

@JvmInline
value class GetStoreListDetailParams(val ids: String)