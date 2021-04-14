package com.dev.newsbox.UI.util

// Will help us differentiate between successful and error responses and also help us in loading state
// {https://www.youtube.com/watch?v=1FGlU6r5o1w&list=PLQkwcJG4YTCRF8XiCRESq1IFFW8COlxYJ&index=7&t=311s
// at 7:45}
sealed class Resource<T>(
        val data: T?= null,
        val message: String?= null
) {
    class Success<T>(data: T): Resource<T>(data)
    class Error<T>(message: String, data: T?=null): Resource<T>(data, message)
    class Loading<T> : Resource<T>()
}