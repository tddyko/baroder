package co.kr.cobosys.domain.repos.auth

import co.kr.cobosys.domain.models.AccessToken
import kotlinx.coroutines.flow.Flow

interface AccessTokenRepo {
    suspend fun getAccessToken(id: String, pwd: String): AccessToken
}