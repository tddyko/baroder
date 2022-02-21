package co.kr.cobosys.baroder.models.mappers.store

import co.kr.cobosys.baroder.models.ProductListUI
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.ProductList

class ProductListMapper: Mapper<ProductList, ProductListUI> {
    override fun mapLeftToRight(obj: ProductList): ProductListUI = with(obj){
        ProductListUI(
            productName = productName,
            productFileName = productFileName,
            amt = amt
        )
    }
}