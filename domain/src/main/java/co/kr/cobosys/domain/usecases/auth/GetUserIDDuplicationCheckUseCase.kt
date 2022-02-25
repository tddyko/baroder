package co.kr.cobosys.domain.usecases.auth

import co.kr.cobosys.domain.base.usecases.GeneralUseCase
import co.kr.cobosys.domain.models.UserIDDuplicationCheckModel
import co.kr.cobosys.domain.repos.auth.UserIDDuplicationCheckRepo
import javax.inject.Inject

class GetUserIDDuplicationCheckUseCase @Inject constructor(
    private val storeRepository: UserIDDuplicationCheckRepo
) : GeneralUseCase<UserIDDuplicationCheckModel> {
    override suspend fun invoke(): UserIDDuplicationCheckModel =
        storeRepository.getUserIDDuplicationCheck()
}