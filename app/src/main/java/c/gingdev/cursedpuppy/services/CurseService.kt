package c.gingdev.cursedpuppy.services

import c.gingdev.cursedpuppy.models.puppyModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path


interface CurseService {
    @GET("/{version}/list")
    fun getPuppyList(@Path("version") version: String): Single<Array<puppyModel>>
}