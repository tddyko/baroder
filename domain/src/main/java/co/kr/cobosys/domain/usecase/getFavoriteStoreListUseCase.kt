package co.kr.cobosys.domain.usecase

import androidx.paging.PagingData
import co.kr.cobosys.domain.base.usecase.GeneralUseCase
import co.kr.cobosys.domain.model.FavoriteStore
import co.kr.cobosys.domain.repo.BaroderLIstRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class getFavoriteStoreListUseCase @Inject constructor(
    private val baroderLIstRepository: BaroderLIstRepository
) : GeneralUseCase<Flow<PagingData<FavoriteStore>>, getFavoriteStoreListParams> {
    override fun invoke(params: getFavoriteStoreListParams): Flow<PagingData<FavoriteStore>> =
        baroderLIstRepository.getFavoriteStoreList(params.ids)
}

@JvmInline
value class getFavoriteStoreListParams(val ids: String)