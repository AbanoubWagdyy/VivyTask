package com.vivy.data.network

import com.vivy.data.model.Token
import io.reactivex.Observable
import retrofit2.http.*

interface ServiceApi {

    @FormUrlEncoded
    @Headers(
        "Authorization: Basic aXBob25lOmlwaG9uZXdpbGxub3RiZXRoZXJlYW55bW9yZQ=="
    )
    @POST
    fun login(
        @Url url: String,
        @Field("username") username: String,
        @Field("password") password: String
    ): Observable<Token>
}