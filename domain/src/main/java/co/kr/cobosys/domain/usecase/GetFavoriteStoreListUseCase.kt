package co.kr.cobosys.domain.usecase

import androidx.paging.PagingData
import co.kr.cobosys.domain.base.usecase.GeneralUseCase
import co.kr.cobosys.domain.model.FavoriteStore
import co.kr.cobosys.domain.repo.BaroderListRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFavoriteStoreListUseCase @Inject constructor(
    private val baroderListRepository: BaroderListRepository
) : GeneralUseCase<Flow<FavoriteStore>, GetFavoriteStoreListParams> {
    override fun invoke(params: GetFavoriteStoreListParams): Flow<FavoriteStore> =
        baroderListRepository.getFavoriteStoreList(params.ids)
}

@JvmInline
value class GetFavoriteStoreListParams(val ids: String)