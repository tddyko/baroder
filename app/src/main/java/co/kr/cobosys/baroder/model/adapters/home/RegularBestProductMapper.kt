package co.kr.cobosys.baroder.model.adapters.home

import co.kr.cobosys.baroder.model.RegularStoreBestProductUI
import co.kr.cobosys.domain.base.map.Mapper
import co.kr.cobosys.domain.model.RegularStoreBestProduct

class RegularBestProductMapper: Mapper<RegularStoreBestProduct, RegularStoreBestProductUI> {
    override fun mapLeftToRight(obj: RegularStoreBestProduct): RegularStoreBestProductUI = with(obj) {
        RegularStoreBestProductUI(
            productName = productName,
            productFileName = productFileName,
            amt = amt
        )
    }
}