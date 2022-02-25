package co.kr.cobosys.domain.repos.auth

import co.kr.cobosys.domain.models.TermsModel

interface TermsRepo {
    fun getTerms(): TermsModel
}