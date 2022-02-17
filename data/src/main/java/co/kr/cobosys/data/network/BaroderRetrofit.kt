package co.kr.cobosys.data.network

import co.kr.cobosys.baroder.data.BuildConfig
import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BaroderRetrofit @Inject constructor(
    okHttpClient: OkHttpClient,
    gson: Gson
) {
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(okHttpClient)
        .build()
}