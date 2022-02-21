package co.kr.cobosys.domain.usecases.auth

import co.kr.cobosys.domain.base.usecases.GeneralUseCase
import co.kr.cobosys.domain.models.Terms
import co.kr.cobosys.domain.repos.auth.TermsRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTermsUseCase @Inject constructor(
    private val terms: TermsRepo
) : GeneralUseCase<Flow<Terms>> {
    override suspend fun invoke(): Flow<Terms> =
        terms.getTerms()
}