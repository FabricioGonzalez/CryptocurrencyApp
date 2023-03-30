package com.teste.personal_tool_app.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.teste.personal_tool_app.ConnectivityObserver
import com.teste.personal_tool_app.NetworkConnectivityObserver
import com.teste.personal_tool_app.common.Constants
import com.teste.personal_tool_app.data.remote.animes.AnimeApi
import com.teste.personal_tool_app.data.remote.coin.CoinPaprikaApi
import com.teste.personal_tool_app.data.remote.weather.WeatherApi
import com.teste.personal_tool_app.data.repositories.animes.AnimeAPIRepositoryImpl
import com.teste.personal_tool_app.data.repositories.coin.CoinRepositoryImpl
import com.teste.personal_tool_app.data.room_database.DatabaseSpecs
import com.teste.personal_tool_app.domain.animes.repositories.AnimeAPIRepository
import com.teste.personal_tool_app.domain.coin.repositories.CoinRepository
import com.teste.personal_tool_app.presentation.nofication.services.NotificationService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providePaprikaApi(client: OkHttpClient): CoinPaprikaApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BASIC)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(logging: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient
            .Builder()
            .addInterceptor(logging)
            .build()
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaApi): CoinRepository {
        return CoinRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideWeatherApi(client: OkHttpClient): WeatherApi {
        return Retrofit.Builder()
            .baseUrl("https://api.open-meteo.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
            .create(WeatherApi::class.java)
    }

    @Provides
    @Singleton
    fun provideAnimeApi(client: OkHttpClient): AnimeApi {
        return Retrofit.Builder()
            .baseUrl(Constants.ANIMES_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(AnimeApi::class.java)
    }

    @Provides
    @Singleton
    fun provideAnimeAPIRepository(api: AnimeApi): AnimeAPIRepository {
        return AnimeAPIRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideFusedLocationProvider(application: Application): FusedLocationProviderClient {
        return LocationServices.getFusedLocationProviderClient(application)
    }

    @Provides
    @Singleton
    fun provideNotificationService(@ApplicationContext context: Context): NotificationService {
        return NotificationService(context)
    }

    @Provides
    fun provideNetworkObserver(@ApplicationContext context: Context): ConnectivityObserver {
        return NetworkConnectivityObserver(context)
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): DatabaseSpecs {
        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL(
                    """INSERT INTO Genres
                    Values('action'),
                    ('adventure'),
                    ('cars'),
                    ('comedy'),
                    ('crime'),
                    ('dementia'),
                    ('demons'),
                    ('drama'),
                    ('dub'),
                    ('ecchi'),
                    ('family'),
                    ('fantasy'),
                    ('game'),
                    ('gourmet'),
                    ('harem'),
                    ('historical'),
                    ('horror'),
                    ('josei'),
                    ('kids'),
                    ('magic'),
                    ('martial-arts'),
                    ('mecha'),
                    ('military'),
                    ('music'),
                    ('mystery'),
                    ('parody'),
                    ('police'),
                    ('psychological'),
                    ('romance'),
                    ('samurai'),
                    ('school'),
                    ('sci-fi'),
                    ('seinen'),
                    ('shoujo'),
                    ('shoujo-ai'),
                    ('shounen'),
                    ('shoujo-ai'),
                    ('shounen-ai'),
                    ('slice-of-Life'),
                    ('space'),
                    ('sports'),
                    ('super-power'),
                    ('supernatural'),
                    ('suspense'),
                    ('thriller'),
                    ('vampire'),
                    ('yaoi'),
                    ('yuri'),
                """
                )
            }
        }
        return Room.databaseBuilder(
            context.applicationContext,
            DatabaseSpecs::class.java,
            Constants.DATABASE_NAME
        ).addMigrations(MIGRATION_1_2)
            .build()
    }

}