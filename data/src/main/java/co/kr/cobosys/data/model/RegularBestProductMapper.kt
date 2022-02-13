package co.kr.cobosys.data.model

import co.kr.cobosys.data.api.RegularStoreBestProductResponse
import co.kr.cobosys.domain.base.map.Mapper
import co.kr.cobosys.domain.model.RegularStoreBestProduct

class RegularBestProductMapper: Mapper<RegularStoreBestProductResponse, RegularStoreBestProduct> {
    override fun mapLeftToRight(obj: RegularStoreBestProductResponse): RegularStoreBestProduct = with(obj) {
        RegularStoreBestProduct(
            productName = productName,
            productFileName = productFileName,
            amt = amt
        )
    }
}