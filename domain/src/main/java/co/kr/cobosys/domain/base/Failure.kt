package co.kr.cobosys.domain.base

sealed class Failure<out T> {

    class Waiting<out T>: Failure<T>()
    class Loading<out T>: Failure<T>()
    class Success<out T>: Failure<Nothing>()
    class Error<out T>: Failure<Nothing>()
}