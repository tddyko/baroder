package co.kr.cobosys.domain.base.usecases

interface GeneralUseCase<Type> {

    suspend operator fun invoke(): Type

}