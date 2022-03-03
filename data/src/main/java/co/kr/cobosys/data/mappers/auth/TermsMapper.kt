package co.kr.cobosys.data.mappers.auth

import co.kr.cobosys.data.api.TermsResponseData
import co.kr.cobosys.data.api.TermsResponseModel
import co.kr.cobosys.domain.models.TermsData
import co.kr.cobosys.domain.models.TermsModel

fun TermsResponseModel.toTermsModel(): TermsModel = TermsModel(
    code, message, data = data.map { data ->
        TermsData(
            data.useTerms,
            data.overYouth,
            data.personalInfo,
            data.locationInfo
        )
    }
)

fun TermsModel.toTermsResponseModel(): TermsResponseModel = TermsResponseModel(
    code, message, data = data.map { data ->
        TermsResponseData(
            data.useTerms,
            data.overYouth,
            data.personalInfo,
            data.locationInfo
        )
    }
)