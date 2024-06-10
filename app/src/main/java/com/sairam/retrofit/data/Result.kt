package com.sairam.retrofit.data

//reusable for other api's too
sealed class Result<T>(
    val data: T? = null,
    val message: String? = null
) {
    // if request is success then we only pass a non nullable data (data cnat be null)
    class Success<T> (data: T): Result<T>(data)
    // in case of failure, we pass some old data or so and also pass a message
    // regarding the error which is non nullable type but data could be null since error occured
    class Error<T> (data: T? = null, message: String): Result<T>(data, message)
}