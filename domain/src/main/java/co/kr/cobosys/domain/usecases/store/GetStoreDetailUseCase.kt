package co.kr.cobosys.domain.usecases.store

import co.kr.cobosys.domain.base.usecases.GeneralPagingUseCase
import co.kr.cobosys.domain.models.StoreDetail
import co.kr.cobosys.domain.repos.store.StoreDetailRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetStoreDetailUseCase @Inject constructor(
    private val storeDetail: StoreDetailRepo
) : GeneralPagingUseCase<Flow<StoreDetail>, GetStoreDetailParams> {
    override fun invoke(params: GetStoreDetailParams): Flow<StoreDetail> =
        storeDetail.getStoreDetail(params.ids)
}

@JvmInline
value class GetStoreDetailParams(val ids: String)