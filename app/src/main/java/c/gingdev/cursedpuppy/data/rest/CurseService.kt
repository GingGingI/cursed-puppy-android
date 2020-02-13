package c.gingdev.cursedpuppy.data.rest

import c.gingdev.cursedpuppy.data.models.CursedRequestModel
import c.gingdev.cursedpuppy.data.models.CursedResponseModel
import c.gingdev.cursedpuppy.data.models.PuppyModel
import io.reactivex.Single
import retrofit2.http.*

interface CurseService {
    @GET("/{version}/list")
    fun getPuppyList(@Path("version") version: String): Single<Array<PuppyModel>>

    @POST("/{version}/cursed")
    fun getCursedText(@Path("version") version: String, @Body body: CursedRequestModel): Single<CursedResponseModel>
}