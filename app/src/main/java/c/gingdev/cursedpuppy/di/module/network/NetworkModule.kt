package c.gingdev.cursedpuppy.di.module.network

import android.app.Application
import c.gingdev.cursedpuppy.BuildConfig
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.net.CookieManager
import java.net.CookiePolicy
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
object NetworkModule {
    private val CONNECT_TIMEOUT: Long = 30 //Sec
    private val WRITE_TIMEOUT: Long = 30 //Sec
    private val READ_TIMEOUT: Long = 30 //Sec
    private val baseUrl: String = "http://nigga.shop:8011"
//    or mmm.forial.tk

    @Provides
    @Singleton
    fun provideCache(app: Application): Cache {
        val chacheSize = 10 * 1024 * 1024 //10MB
        return Cache(app.cacheDir, chacheSize.toLong())
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    //    OKHttp Client 생성
    @Provides
    @Singleton
    fun provideOkHttpClient(cache: Cache, interceptor: Interceptor): OkHttpClient {
        val logger: HttpLoggingInterceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            logger.level = HttpLoggingInterceptor.Level.BODY
        } else {
            logger.level = HttpLoggingInterceptor.Level.NONE
        }

        return OkHttpClient.Builder()
            .cache(cache)
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .cookieJar(JavaNetCookieJar(CookieManager(null, CookiePolicy.ACCEPT_ALL)))
            .addInterceptor(logger)
            .addInterceptor(interceptor)
            .build()
    }

    //    Retrofit Client 생성
    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson, client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .baseUrl(baseUrl)
            .build()
    }

    @Provides
    @Singleton
    fun provideInterceptor(): Interceptor {
        return Interceptor {
            val builder: Request.Builder = it.request().newBuilder()
            builder.header("User-Agent", "Android")

            it.proceed(builder.build())
        }
    }
}