package co.kr.cobosys.domain.base.usecase

interface GeneralPagingUseCase<Type, in Params> {

    operator fun invoke(params: Params): Type

}