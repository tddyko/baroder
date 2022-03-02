package co.kr.cobosys.data.datasources.auth

import co.kr.cobosys.data.api.CertifyCodeResponseModel
import co.kr.cobosys.data.api.Request
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface CertifyCodeDataSource {
    fun certifyCode(phoneNum: String, duplication: String): Flow<CertifyCodeResponseModel>
}

class CertifyCodeDataSourceImpl @Inject constructor(
    private val reqApi: Request
): CertifyCodeDataSource {

    override fun certifyCode(phoneNum: String, duplication: String): Flow<CertifyCodeResponseModel> = reqApi.requestCertifyCode(phoneNum, duplication)
}