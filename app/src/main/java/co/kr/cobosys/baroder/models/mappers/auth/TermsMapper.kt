package co.kr.cobosys.baroder.models.mappers.auth

import co.kr.cobosys.baroder.models.TermsDataUI
import co.kr.cobosys.baroder.models.TermsModelUI
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.TermsModel

class TermsMapper : Mapper<TermsModel, TermsModelUI> {
    override fun mapLeftToRight(obj: TermsModel): TermsModelUI = with(obj) {
        TermsModelUI(
            code = code,
            message = message,
            data = data.map { data ->
                TermsDataUI(
                    data.useTerms,
                    data.overYouth,
                    data.personalInfo,
                    data.locationInfo
                )
            }
        )
    }
}