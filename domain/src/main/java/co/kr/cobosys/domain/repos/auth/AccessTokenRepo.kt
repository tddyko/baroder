package co.kr.cobosys.domain.repos.auth

import co.kr.cobosys.domain.models.AccessTokenModel
import kotlinx.coroutines.flow.Flow

interface AccessTokenRepo {

    fun getAccessToken(id: String, pwd: String): Flow<AccessTokenModel>

}