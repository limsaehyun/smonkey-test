package com.saehyun.smonkey_android

import com.saehyun.data.repository.UserRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class TokenInterceptor(
    private val userRepository: UserRepository
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest: Request = chain.request()
        val token = runBlocking {
            userRepository.getToken().first()
        } // TokenRepository에서 토큰을 가져옵니다.

        val requestBuilder: Request.Builder = originalRequest.newBuilder()
            .header("Authorization", "Bearer $token")
            .method(originalRequest.method, originalRequest.body)

        val request: Request = requestBuilder.build()
        return chain.proceed(request)
    }
}
