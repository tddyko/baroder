package co.kr.cobosys.domain.usecase

import co.kr.cobosys.domain.base.usecase.GeneralUseCase
import co.kr.cobosys.domain.model.CertifyCode
import co.kr.cobosys.domain.repo.BaroderRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCertifyCodeUseCase @Inject constructor(
    private val certifyCode: BaroderRepository
) : GeneralUseCase<Flow<CertifyCode>> {
    override fun invoke(): Flow<CertifyCode> =
        certifyCode.getCertifyCode()
}