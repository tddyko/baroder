package co.kr.cobosys.domain.repos.auth

import co.kr.cobosys.domain.models.FoundMemberIdModel

interface FoundMemberIdRepo {
    fun getFoundMemberId(): FoundMemberIdModel
}