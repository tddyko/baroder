package co.kr.cobosys.domain.usecases.store

import co.kr.cobosys.domain.base.usecases.GeneralPagingUseCase
import co.kr.cobosys.domain.models.StoreModel
import co.kr.cobosys.domain.repos.store.StoreRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetStoreListUserCase @Inject constructor(
    private val storeList: StoreRepo
) : GeneralPagingUseCase<Flow<StoreModel>, GetStoreListParams> {
    override fun invoke(params: GetStoreListParams): Flow<StoreModel> =
        storeList.getStore(params.ids)
}

@JvmInline
value class GetStoreListParams(val ids: String)