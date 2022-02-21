package co.kr.cobosys.domain.base.usecases

interface GeneralPagingUseCase<Type, in Params> {

    operator fun invoke(params: Params): Type

}