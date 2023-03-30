package com.teste.personal_tool_app.common

sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null,
    val isLoading: Boolean = false
) {
    class Success<T>(data: T?) : Resource<T>(data = data)
    class Error<T>(message: String?, data: T? = null) : Resource<T>(data = data, message = message)
    class Loading<T>(isLoading: Boolean = false, data: T? = null) :
        Resource<T>(isLoading = isLoading, data = data)
}

fun <T> Resource<T>.onSucess(action: (Resource.Success<T>) -> Unit) {
    if (this is Resource.Success)
        action(this)
}

fun <T> Resource<T>.onError(action: (Resource.Error<T>) -> Unit) {

    if (this is Resource.Error)

        action(this)
}

fun <T> Resource<T>.onLoading(action: (Resource.Loading<T>) -> Unit) {
    if (this is Resource.Loading)
        action(this)
}

