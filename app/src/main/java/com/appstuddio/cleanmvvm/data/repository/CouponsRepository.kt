package com.appstuddio.cleanmvvm.data.repository

import com.appstuddio.cleanmvvm.core.functional.Either
import com.appstuddio.cleanmvvm.core.functional.Failure
import com.appstuddio.cleanmvvm.core.functional.NetworkHandler
import com.appstuddio.cleanmvvm.data.remote.CouponsService
import com.appstuddio.cleanmvvm.features.coupons.models.Coupon
import retrofit2.Call
import javax.inject.Inject

interface CouponsRepository {
    fun coupons(): Either<Failure, List<Coupon>>

    class Network
    @Inject constructor(private val networkHandler: NetworkHandler,
                        private val service: CouponsService,
    ) : CouponsRepository {

        override fun coupons(): Either<Failure, List<Coupon>> {
            return when (networkHandler.isConnected) {
                true ->{
                    try {
                        val response = service.getCoupons().execute()
                        when (response.isSuccessful) {
                            true -> {
                                response.body()?.let {
                                    Either.Right(it.map { entity ->
                                        entity.toCoupon()
                                    })
                                }?: Either.Left(Failure.DefaultError(""))
                            }
                            false -> Either.Left(Failure.ServerError)
                        }
                    } catch (e: Exception) {
                        Either.Left(Failure.DefaultError(e.message!!))
                    }
                }
                false -> Either.Left(Failure.NetworkConnection)
            }

        }

        private fun <T, R> request(call: Call<T>, transform: (T) -> R, default: T): Either<Failure, R> {
            return try {
                val response = call.execute()
                when (response.isSuccessful) {
                    true -> Either.Right(transform((response.body() ?: default)))
                    false -> Either.Left(Failure.ServerError)
                }
            } catch (exception: Throwable) {
                Either.Left(Failure.ServerError)
            }
        }
    }
}