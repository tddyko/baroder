package co.kr.cobosys.domain.repos.auth

import co.kr.cobosys.domain.models.AccessTokenModel

interface AccessTokenRepo {

    suspend fun getAccessToken(id: String, pwd: String): AccessTokenModel

}