package com.appstuddio.cleanmvvm.core.functional

import android.content.Context
import com.appstuddio.cleanmvvm.core.extensions.networkInfo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkHandler
@Inject constructor(private val context: Context) {
    val isConnected get() = when(context.networkInfo) {
        null -> false
        else -> true
    }
}