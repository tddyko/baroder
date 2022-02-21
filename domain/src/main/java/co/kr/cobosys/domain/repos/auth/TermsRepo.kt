package co.kr.cobosys.domain.repos.auth

import co.kr.cobosys.domain.models.Terms
import kotlinx.coroutines.flow.Flow

interface TermsRepo {
    fun getTerms(): Flow<Terms>
}