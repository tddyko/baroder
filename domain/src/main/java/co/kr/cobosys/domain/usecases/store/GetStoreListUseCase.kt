package co.kr.cobosys.domain.usecases.store

import androidx.paging.PagingData
import co.kr.cobosys.domain.base.usecases.GeneralPagingUseCase
import co.kr.cobosys.domain.models.StoreList
import co.kr.cobosys.domain.repos.store.StoreListRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetStoreListUserCase @Inject constructor(
    private val storeList: StoreListRepo
) : GeneralPagingUseCase<Flow<PagingData<StoreList>>, GetStoreListParams> {
    override fun invoke(params: GetStoreListParams): Flow<PagingData<StoreList>> =
        storeList.getStoreList(params.ids)
}

@JvmInline
value class GetStoreListParams(val ids: String)