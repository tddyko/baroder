package co.kr.cobosys.data.mappers.auth

import co.kr.cobosys.data.api.TermsResponse
import co.kr.cobosys.domain.base.map.Mapper
import co.kr.cobosys.domain.model.Terms

class TermsMapper: Mapper<TermsResponse, Terms> {
    override fun mapLeftToRight(obj: TermsResponse): Terms = with(obj) {
       Terms(
           useTerms = useTerms,
           overYouth = overYouth,
           personalInfo = personalInfo,
           locationInfo = locationInfo
       )
    }
}