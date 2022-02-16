package co.kr.cobosys.domain.usecase

import androidx.paging.PagingData
import co.kr.cobosys.domain.base.usecase.GeneralUseCase
import co.kr.cobosys.domain.model.StoreList
import co.kr.cobosys.domain.repo.BaroderRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetStoreListUserCase @Inject constructor(
    private val storeRepository: BaroderRepository
) : GeneralUseCase<Flow<PagingData<StoreList>>, GetStoreListParams> {
    override fun invoke(params: GetStoreListParams): Flow<PagingData<StoreList>> =
        storeRepository.getStoreList(params.ids)
}

@JvmInline
value class GetStoreListParams(val ids: String)