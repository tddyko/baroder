package co.kr.cobosys.domain.base.usecases

interface GeneralUseCase<Type> {

    operator fun invoke(): Type

}