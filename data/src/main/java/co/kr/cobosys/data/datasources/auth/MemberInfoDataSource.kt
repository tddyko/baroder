package co.kr.cobosys.data.datasources.auth

import co.kr.cobosys.data.api.MemberInfoResponseModel
import co.kr.cobosys.data.api.Request
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface MemberInfoDataSource {
    fun token(token: String): Flow<MemberInfoResponseModel>
}

class MemberInfoDataSourceImpl @Inject constructor(
    private val reqApi: Request
): MemberInfoDataSource {

    override fun token(token: String): Flow<MemberInfoResponseModel> = reqApi.memberDetailInfo(token)
}