package com.example.leaderboard

import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

const val Post_Base_Url = "https://docs.google.com/fors/d/e/"

interface LeaderBoardApi {

    @GET("hours")
    suspend fun getHours(): Response<List<HoursItem>>

    @GET("skilliq")
    suspend fun getSkillIq(): Response<List<SkillItem>>


    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    @FormUrlEncoded
    fun ProjectSubmit(
        @Field("entry.1877115667") firstName: String,
        @Field("entry.2006916086") lastName: String,
        @Field("entry.1824927963") email: String,
        @Field("entry.284483984") linkToGithub: String
//        @Field("entry.642603327") track: String
    ): Call<Void>

//    fun ProjectSubmit(firstName: String, lastName: String, email: String, linkToGithub: String, track: String)

    companion object{
        operator fun invoke() : LeaderBoardApi{
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://gadsapi.herokuapp.com/api/")
                .build()
                .create(LeaderBoardApi::class.java)
        }

//        val baseUrl = Retrofit.Builder()
//            .addConverterFactory(GsonConverterFactory.create())
//            .baseUrl("https://docs.google.com/fors/d/e/")
//            .build()
//            .create(LeaderBoardApi::class.java)
    }
}