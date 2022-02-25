package co.kr.cobosys.data.mappers.store

import co.kr.cobosys.data.api.ProductListResponse
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.ProductList

class RegularBestProductMapper: Mapper<ProductListResponse, ProductList> {
    override fun mapLeftToRight(obj: ProductListResponse): ProductList = with(obj) {
        ProductList(
            productName = productName,
            productFileName = productFileName,
            amt = amt
        )
    }
}