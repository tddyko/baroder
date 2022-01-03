package co.kr.cobosys.domain.usecase

import androidx.paging.PagingData
import co.kr.cobosys.domain.base.usecase.GeneralUseCase
import co.kr.cobosys.domain.model.FavoriteStore
import co.kr.cobosys.domain.repo.BaroderLIstRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFavoriteStoreListUseCase @Inject constructor(
    private val baroderListRepository: BaroderLIstRepository
) : GeneralUseCase<Flow<PagingData<FavoriteStore>>, GetFavoriteStoreListParams> {
    override fun invoke(params: GetFavoriteStoreListParams): Flow<PagingData<FavoriteStore>> =
        baroderListRepository.getFavoriteStoreList(params.ids)
}

@JvmInline
value class GetFavoriteStoreListParams(val ids: String)