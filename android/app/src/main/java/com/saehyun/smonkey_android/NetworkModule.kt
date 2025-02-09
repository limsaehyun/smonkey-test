package com.saehyun.smonkey_android

import com.saehyun.data.network.feed.FeedAPI
import com.saehyun.data.network.friend.FriendAPI
import com.saehyun.data.network.journal.JournalAPI
import com.saehyun.data.network.like.LikeAPI
import com.saehyun.data.network.smoking.SmokingAPI
import com.saehyun.data.network.smonkey.SMonkeyAPI
import com.saehyun.data.network.user.UserAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BASE_URL = BuildConfig.BASE_URL

    @Provides
    @Singleton
    fun provideLogger(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(level = HttpLoggingInterceptor.Level.BODY)

//    @Provides
//    @Singleton
//    fun provideTokenInterceptor(
//        userRepository: UserRepository,
//    ): TokenInterceptor =
//        TokenInterceptor(userRepository)

    @Provides
    @Singleton
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor
//        tokenInterceptor: TokenInterceptor,
    ): OkHttpClient =
        synchronized(this) {
            OkHttpClient.Builder()
//                .addInterceptor(tokenInterceptor)
                .addInterceptor(httpLoggingInterceptor)
                .build()
        }

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit =
        synchronized(this) {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

    @Provides
    @Singleton
    fun provideUserAPI(retrofit: Retrofit): UserAPI = synchronized(this) {
        retrofit.create(UserAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideSmonkeyAPI(retrofit: Retrofit): SMonkeyAPI = synchronized(this) {
        retrofit.create(SMonkeyAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideFeedAPI(retrofit: Retrofit): FeedAPI = synchronized(this) {
        retrofit.create(FeedAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideFriendAPI(retrofit: Retrofit): FriendAPI = synchronized(this) {
        retrofit.create(FriendAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideJournalAPI(retrofit: Retrofit): JournalAPI = synchronized(this) {
        retrofit.create(JournalAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideLikeAPI(retrofit: Retrofit): LikeAPI = synchronized(this) {
        retrofit.create(LikeAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideSmokingAPI(retrofit: Retrofit): SmokingAPI = synchronized(this) {
        retrofit.create(SmokingAPI::class.java)
    }
}
