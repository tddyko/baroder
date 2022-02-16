package co.kr.cobosys.baroder.model.mappers.store

import co.kr.cobosys.baroder.model.ProductListUI
import co.kr.cobosys.domain.base.map.Mapper
import co.kr.cobosys.domain.model.ProductList

class ProductListMapper: Mapper<ProductList, ProductListUI> {
    override fun mapLeftToRight(obj: ProductList): ProductListUI = with(obj){
        ProductListUI(
            productName = productName,
            productFileName = productFileName,
            amt = amt
        )
    }
}