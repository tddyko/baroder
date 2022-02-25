package co.kr.cobosys.domain.usecases.store

import co.kr.cobosys.domain.base.usecases.GeneralParamsUseCase
import co.kr.cobosys.domain.models.StoreDetailModel
import co.kr.cobosys.domain.repos.store.StoreDetailRepo
import javax.inject.Inject

class GetStoreDetailUseCase @Inject constructor(
    private val storeDetail: StoreDetailRepo
) : GeneralParamsUseCase<StoreDetailModel, GetStoreDetailParams> {

    override suspend fun invoke(params: GetStoreDetailParams): StoreDetailModel =
        storeDetail.getStoreDetail(params.ids)
}

@JvmInline
value class GetStoreDetailParams(val ids: String)