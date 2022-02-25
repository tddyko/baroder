package co.kr.cobosys.domain.usecases.auth

import android.os.Parcelable
import co.kr.cobosys.domain.base.usecases.GeneralParamsUseCase
import co.kr.cobosys.domain.base.usecases.GeneralUseCase
import co.kr.cobosys.domain.models.CertifyCodeModel
import co.kr.cobosys.domain.repos.auth.CertifyCodeRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.parcelize.Parcelize
import javax.inject.Inject

class GetCertifyCodeUseCase @Inject constructor(
    private val certifyCode: CertifyCodeRepo
) : GeneralParamsUseCase<CertifyCodeModel, GetCertifyCodeParams> {
    override suspend fun invoke(params: GetCertifyCodeParams): CertifyCodeModel =
        certifyCode.getCertifyCode(phoneNum = params.phoneNum, duplication = params.duplication)
}

@Parcelize
data class GetCertifyCodeParams(
    val phoneNum: String,
    val duplication: String
): Parcelable