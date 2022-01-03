package co.kr.cobosys.domain.usecase

import androidx.paging.PagingData
import co.kr.cobosys.domain.base.usecase.GeneralUseCase
import co.kr.cobosys.domain.model.Store
import co.kr.cobosys.domain.repo.BaroderLIstRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetStoreListUserCase @Inject constructor(
    private val baroderLIstRepository: BaroderLIstRepository
) : GeneralUseCase<Flow<PagingData<Store>>, GetStoreListParams> {
    override fun invoke(params: GetStoreListParams): Flow<PagingData<Store>> =
        baroderLIstRepository.getStoreList(params.ids)
}

@JvmInline
value class GetStoreListParams(val ids: String)