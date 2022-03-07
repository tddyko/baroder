package co.kr.cobosys.domain.base.usecases

interface GeneralNotTypeParamsUseCase<Type, in Params> {

    suspend operator fun invoke(params: Params)

}