package com.hiyupin.njoin.model

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class BaseURL {

    // java use static ... medthod name
    // but kotlin use companion object { fun ... }
    companion object {
        fun getBaseURL(): Apis {
            var gson = GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create()
            var retrofit = Retrofit.Builder()
                .baseUrl("http://fishyutt.xyz/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
            return retrofit.create(Apis::class.java)
        }
    }


}