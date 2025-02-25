package com.pokeapi.pedrointerview.di


import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonDeserializer
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.pokeapi.pedrointerview.data.ApiChuck
import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import javax.inject.Named
import javax.inject.Singleton


@Module
object NetworkModule {

    /**
     * Provides the Post service implementation.
     * @param retrofit the Retrofit object used to instantiate the service
     * @return the Post service implementation.
     */
    @Provides
    @Singleton
    @Named("ApiChuck")
    internal fun providePostApi(retrofit: Retrofit): ApiChuck {
        return retrofit.create(ApiChuck::class.java)
    }

    /**
     * Provides the Retrofit object.
     * @return the Retrofit object
     */
    @Provides
    @Reusable
    @JvmStatic
    internal fun provideRetrofitInterface(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.chucknorris.io/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(okHttpClient)
            .build()
    }

    @Provides
    fun getGson(): Gson {
        val gson = GsonBuilder()
            .setLenient()
            .registerTypeAdapter(
                Date::class.java,
                JsonDeserializer { json, _, _ -> Date(json.asJsonPrimitive.asLong) })
            .create()
        return gson
    }


    @Provides
    fun getOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        val client = OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor)
        client.addInterceptor(httpLoggingInterceptor)
        return client.build()
    }

    @Provides
    fun getInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }
}