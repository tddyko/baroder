package co.kr.cobosys.domain.base.usecases

interface GeneralParamsUseCase<Type, in Params> {

    suspend operator fun invoke(params: Params): Type

}