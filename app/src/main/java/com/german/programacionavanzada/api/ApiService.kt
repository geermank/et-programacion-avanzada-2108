package com.german.programacionavanzada.api

import com.german.programacionavanzada.models.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("users")
    fun getUsers(): Call<List<User>>

    @GET("users/{id}")
    fun getUserById(@Path("id") identificador: Int): Call<User>

    @GET("users")
    fun getUser(@Query("id") id: Int): Call<User?>
}