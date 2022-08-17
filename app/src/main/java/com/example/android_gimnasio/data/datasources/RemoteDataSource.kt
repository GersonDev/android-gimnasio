package com.example.android_gimnasio.data.datasources

import com.example.android_gimnasio.R
import com.example.android_gimnasio.data.api.ApiClient
import com.example.android_gimnasio.domain.models.gym.Brand

class RemoteDataSource {

    suspend fun getUsersFromRemote(): List<Brand> {
        val brandResponse = ApiClient.getClient().getBrands()
        val brands = brandResponse.map {
            Brand(
                title = it.name,
                image = R.drawable.brand_megaforce
            )
        }
        return brands
    }

}