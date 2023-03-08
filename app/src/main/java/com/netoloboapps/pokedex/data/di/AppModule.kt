package com.netoloboapps.pokedex.data.di

import com.netoloboapps.pokedex.data.PokemonRepositoryImpl
import com.netoloboapps.pokedex.data.remote.PokeApi
import com.netoloboapps.pokedex.domain.PokemonRepository
import com.netoloboapps.pokedex.util.Constants.BASE_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Singleton
    @Provides
    fun providePokemonApi(): PokeApi {

        //Moshi config
        val moshi: Moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        return Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL)
            .build()
            .create(PokeApi::class.java)
    }

    @Singleton
    @Provides
    fun providePokemonRepository(pokeApi: PokeApi) : PokemonRepository{
        return PokemonRepositoryImpl(pokeApi)
    }

}