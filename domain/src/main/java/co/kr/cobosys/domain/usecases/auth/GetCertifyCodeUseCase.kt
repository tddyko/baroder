package co.kr.cobosys.domain.usecases.auth

import co.kr.cobosys.domain.base.usecases.GeneralUseCase
import co.kr.cobosys.domain.models.CertifyCode
import co.kr.cobosys.domain.repos.auth.CertifyCodeRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCertifyCodeUseCase @Inject constructor(
    private val certifyCode: CertifyCodeRepo
) : GeneralUseCase<Flow<CertifyCode>> {
    override suspend fun invoke(): Flow<CertifyCode> =
        certifyCode.getCertifyCode()
}