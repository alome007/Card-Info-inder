package com.mint.daniel.utils

import com.mint.daniel.Model.Card
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CardService {
    @GET("{number}")
    fun getCard(@Path("number")number: Int) : Call<Card>
}