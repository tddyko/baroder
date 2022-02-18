package co.kr.cobosys.domain.base.usecase

interface GeneralUseCase<Type> {

    operator fun invoke(): Type

}