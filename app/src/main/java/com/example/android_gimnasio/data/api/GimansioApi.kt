package com.example.android_gimnasio.data.api

import retrofit2.http.*

interface GimansioApi {

    @GET("brands")
    suspend fun getBrands(): List<BrandResponse>

    @POST("brands")
    suspend fun createBrand(
        @Body brandRequest: BrandRequest
    )

    @PUT
    suspend fun updateBrand()

    @DELETE
    suspend fun deleteBrand()


}