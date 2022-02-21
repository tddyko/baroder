package co.kr.cobosys.baroder.models.mappers.auth

import co.kr.cobosys.baroder.models.TermsUI
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.Terms

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