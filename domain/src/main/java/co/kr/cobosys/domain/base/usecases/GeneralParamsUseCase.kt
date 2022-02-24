package co.kr.cobosys.domain.base.usecases

import co.kr.cobosys.domain.models.AccessTokenModel
import kotlinx.coroutines.flow.Flow

interface GeneralParamsUseCase<Type, in Params> {

    suspend operator fun invoke(params: Params): AccessTokenModel

}