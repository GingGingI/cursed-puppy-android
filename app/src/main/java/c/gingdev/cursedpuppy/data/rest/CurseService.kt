package c.gingdev.cursedpuppy.data.rest

import c.gingdev.cursedpuppy.data.models.PuppyModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path


interface CurseService {
    @GET("/{version}/list")
    fun getPuppyList(@Path("version") version: String): Single<Array<PuppyModel>>
}