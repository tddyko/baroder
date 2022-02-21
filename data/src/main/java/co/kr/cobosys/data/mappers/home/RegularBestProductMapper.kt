package co.kr.cobosys.data.mappers.home

import co.kr.cobosys.data.api.RegularStoreBestProductResponse
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.RegularStoreBestProduct

class RegularBestProductMapper: Mapper<RegularStoreBestProductResponse, RegularStoreBestProduct> {
    override fun mapLeftToRight(obj: RegularStoreBestProductResponse): RegularStoreBestProduct = with(obj) {
        RegularStoreBestProduct(
            productName = productName,
            productFileName = productFileName,
            amt = amt
        )
    }
}