package co.kr.cobosys.domain.usecases.auth

import co.kr.cobosys.domain.base.usecases.GeneralUseCase
import co.kr.cobosys.domain.models.TermsModel
import co.kr.cobosys.domain.repos.auth.TermsRepo
import javax.inject.Inject

class GetTermsUseCase @Inject constructor(
    private val terms: TermsRepo
) : GeneralUseCase<TermsModel> {
    override suspend fun invoke(): TermsModel =
        terms.getTerms()
}