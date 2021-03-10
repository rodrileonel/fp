package com.appstuddio.cleanmvvm.core.extensions

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network

val Context.networkInfo: Network? get() =
    (this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).activeNetwork