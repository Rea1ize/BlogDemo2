package com.example.tonjies.okhttpdemo.module.AsyncHttp


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.tonjies.okhttpdemo.R
import okhttp3.*
import java.io.IOException
import kotlinx.android.synthetic.main.activity_asnc.*
class AsncActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_asnc)
        sendAsyncRequest3("http://www.wanandroid.com/tools/mockapi/2872/student")
    }
}
/**
 * 异步请求
 */
fun sendAsyncRequest3(url: String) {
    val okHttpClient = OkHttpClient()
    val request: Request = Request.Builder().url(url).build()
    okHttpClient.newCall(request).enqueue(object : Callback {
        override fun onFailure(call: Call?, e: IOException?) {

        }

        override fun onResponse(call: Call?, response: Response?) {
            if (response!!.isSuccessful) {
                println(""+response.body()!!.string())
            }
        }
    })
}
