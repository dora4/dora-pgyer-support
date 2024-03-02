package dora.pgyer

import dora.http.retrofit.ApiService
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface PgyService : ApiService {
    @POST("app/check")
    @FormUrlEncoded
    fun checkVersion(
        @Field("_api_key") apiKey: String?,
        @Field("appKey") appKey: String?
    ): Call<PgyApiResult<VersionResponse>>
}