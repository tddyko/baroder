package co.kr.cobosys.data.mappers.store

import co.kr.cobosys.data.api.ProductListResponse
import co.kr.cobosys.domain.base.map.Mapper
import co.kr.cobosys.domain.model.ProductList

class ProductListMapper: Mapper<ProductListResponse, ProductList> {
    override fun mapLeftToRight(obj: ProductListResponse): ProductList = with(obj){
        ProductList(
            productName = productName,
            productFileName = productFileName,
            amt = amt
        )
    }
}