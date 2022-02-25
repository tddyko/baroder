package co.kr.cobosys.data.mappers.auth

import co.kr.cobosys.data.api.TermsResponseModel
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.TermsData
import co.kr.cobosys.domain.models.TermsModel

class TermsMapper : Mapper<TermsResponseModel, TermsModel> {
    override fun mapLeftToRight(obj: TermsResponseModel): TermsModel = with(obj) {
        TermsModel(
            code = code,
            message = message,
            data = data.map { data ->
                TermsData(
                    data.useTerms,
                    data.overYouth,
                    data.personalInfo,
                    data.locationInfo
                )
            }
        )
    }
}