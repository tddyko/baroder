package co.kr.cobosys.data.repos.auth

import co.kr.cobosys.data.datasources.auth.MemberInfoDataSource
import co.kr.cobosys.data.mappers.auth.toMemberInfoModel
import co.kr.cobosys.domain.models.MemberInfoModel
import co.kr.cobosys.domain.repos.auth.MemberInfoRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MemberInfoRepoImpl @Inject constructor(
    private val memberInfoDataSource: MemberInfoDataSource
) : MemberInfoRepo {
    override fun getMemberInfo(token: String): Flow<MemberInfoModel> =
//        AccessTokenMapper().mapLeftToRight(accessDataSource.login(id = id, pwd = pwd))
        memberInfoDataSource.token(token = token).map { it.toMemberInfoModel() }
}