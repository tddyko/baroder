package co.kr.cobosys.domain.repos.store

import co.kr.cobosys.domain.models.ProductList
import kotlinx.coroutines.flow.Flow

interface ProductListRepo {
    fun getPrpdictList(): Flow<ProductList>
}