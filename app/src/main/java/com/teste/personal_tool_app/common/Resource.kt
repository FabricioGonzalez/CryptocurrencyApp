package com.teste.personal_tool_app.common

sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T?) : Resource<T>(data)
    class Error<T>(message: String?, data: T? = null) : Resource<T>(data, message)
    class Loading<T>(data: T? = null) : Resource<T>(data)
}

fun <T> Resource<T>.onSucess(action: (Resource.Success<T>) -> Unit) {
    if (this is Resource.Success<T>)
        action(this)
}

fun <T> Resource<T>.onError(action: (Resource.Error<T>) -> Unit) {

    if (this is Resource.Error<T>)

        action(this)
}

fun <T> Resource<T>.onLoading(action: (Resource.Loading<T>) -> Unit) {
    if (this is Resource.Loading<T>)
        action(this)
}

