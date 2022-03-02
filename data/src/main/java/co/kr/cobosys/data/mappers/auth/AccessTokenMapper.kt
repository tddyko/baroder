package co.kr.cobosys.data.mappers.auth

import co.kr.cobosys.data.api.AccessTokenResponseModel
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.AccessTokenData
import co.kr.cobosys.domain.models.AccessTokenModel
import kotlinx.coroutines.flow.Flow

class AccessTokenMapper: Mapper<Flow<AccessTokenResponseModel>, Flow<AccessTokenModel>> {

    override fun mapLeftToRight(obj: Flow<AccessTokenResponseModel>): Flow<AccessTokenModel> = with(obj) {

    }
}