package co.kr.cobosys.domain.base

sealed class Failure<out T> {

    class Waiting<out T>: Failure<T>()
    class Loading<out T>: Failure<T>()
    class Success<out T>(val data: T): Failure<T>()
    class Error<out T>(val code: String, val message: String): Failure<T>()
}