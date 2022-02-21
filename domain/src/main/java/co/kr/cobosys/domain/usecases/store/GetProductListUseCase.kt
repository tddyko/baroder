package co.kr.cobosys.domain.usecases.store

import co.kr.cobosys.domain.base.usecases.GeneralUseCase
import co.kr.cobosys.domain.models.ProductList
import co.kr.cobosys.domain.repos.point.PointHistoryRepo
import co.kr.cobosys.domain.repos.store.ProductListRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetProductListUseCase @Inject constructor(
    private val productList: ProductListRepo
) : GeneralUseCase<Flow<ProductList>> {
    override suspend fun invoke(): Flow<ProductList> =
        productList.getPrpdictList()
}