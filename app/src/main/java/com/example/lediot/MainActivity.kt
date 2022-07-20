package com.example.lediot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.content.ContextCompat
import com.example.lediot.databinding.ActivityMainBinding
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val onButton :Button= binding.button
        val offButton :Button=binding.button2
        val flag=0
        val ll = binding.constrain
        ll.setBackgroundColor(ContextCompat.getColor(this, R.color.purple_200))
        var url = ""


        onButton.setOnClickListener {
            url = BuildConfig.API_KEY_ON
            launchUrl(url)



        }
        offButton.setOnClickListener {
            url = BuildConfig.API_KEY_OFF
            launchUrl(url)
        }




    }

    private fun launchUrl(url: String) {
        val client = AsyncHttpClient()

        client[url, object : AsyncHttpResponseHandler() {
            override fun onStart() {
                // called before request is started
            }

            override fun onSuccess(
                statusCode: Int,
                headers: Array<out cz.msebera.android.httpclient.Header>?,
                response: ByteArray?
            ) {
                // called when response HTTP status is "200 OK"
            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<out cz.msebera.android.httpclient.Header>?,
                errorResponse: ByteArray?,
                e: Throwable?
            ) {
                // called when response HTTP status is "4XX" (eg. 401, 403, 404)
            }

            override fun onRetry(retryNo: Int) {
                // called when request is retried
            }
        }]
    }
}

