package co.kr.cobosys.domain.base.usecases

interface GeneralNotTypeUseCase<Type> {

    suspend operator fun invoke()

}