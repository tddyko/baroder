package co.kr.cobosys.domain.usecase

import co.kr.cobosys.domain.base.usecase.GeneralUseCase
import co.kr.cobosys.domain.model.Terms
import co.kr.cobosys.domain.repo.BaroderRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTermsUseCase @Inject constructor(
    private val terms: BaroderRepository
) : GeneralUseCase<Flow<Terms>> {
    override fun invoke(): Flow<Terms> =
        terms.getTerms()
}