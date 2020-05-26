package com.example.jetpackdemo

import android.content.Context
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.ConnectException
import java.net.UnknownHostException


class RetrofitResponseHandler<T> : Callback<T> {
    private var successAPICallback: SuccessAPICallback<T>? = null
    private var failureAPICallback: FailureAPICallback? = null
    private var context: Context
    private val mCall: Call<T>? = null

    constructor(context: Context) {
        this.context = context
    }

    constructor(
        context: Context,
        successAPICallback: SuccessAPICallback<T>?,
        failureAPICallback: FailureAPICallback?
    ) {
        this.context = context
        this.failureAPICallback = failureAPICallback
        this.successAPICallback = successAPICallback
    }

    override fun onResponse(
        call: Call<T>,
        response: Response<T>
    ) {
        if (response.isSuccessful) {
            response.body()?.let { successAPICallback?.onResponse(it) }
        } else {
            if (failureAPICallback != null) {
                failureAPICallback?.onFailure(response.body(), response.body())
            }
        }
    }

    override fun onFailure(
        call: Call<T>,
        throwable: Throwable
    ) {
        val errorMessage = throwable.toString()
        if (throwable is UnknownHostException || throwable is ConnectException) {
//            showNetworkDialog();
        }
    }
}
