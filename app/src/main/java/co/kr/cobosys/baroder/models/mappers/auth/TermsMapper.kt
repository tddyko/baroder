package co.kr.cobosys.baroder.models.mappers.auth

import co.kr.cobosys.baroder.models.TermsDataUI
import co.kr.cobosys.baroder.models.TermsModelUI
import co.kr.cobosys.domain.models.TermsData
import co.kr.cobosys.domain.models.TermsModel

fun TermsModelUI.toTermsModel(): TermsModel = TermsModel(
    code, message, data = data.map { data ->
        TermsData(
            data.useTerms,
            data.overYouth,
            data.personalInfo,
            data.locationInfo
        )
    }
)

fun TermsModel.toTermsModelUI(): TermsModelUI = TermsModelUI(
    code, message, data = data.map { data ->
        TermsDataUI(
            data.useTerms,
            data.overYouth,
            data.personalInfo,
            data.locationInfo
        )
    }
)