package co.kr.cobosys.baroder.model.mappers.auth

import co.kr.cobosys.baroder.model.TermsUI
import co.kr.cobosys.domain.base.map.Mapper
import co.kr.cobosys.domain.model.Terms

class TermsMapper: Mapper<Terms, TermsUI> {
    override fun mapLeftToRight(obj: Terms): TermsUI = with(obj) {
       TermsUI(
           useTerms = useTerms,
           overYouth = overYouth,
           personalInfo = personalInfo,
           locationInfo = locationInfo
       )
    }
}