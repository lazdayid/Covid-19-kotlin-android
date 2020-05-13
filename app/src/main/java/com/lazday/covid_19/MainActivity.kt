package com.lazday.covid_19

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.lazday.covid_19.retrofit.ApiService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val TAG: String = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        getData()
    }

    private fun getData(){
        showLoading(true)
        ApiService.endpoint.getData()
            .enqueue(object : Callback<List<MainModel>> {
                override fun onFailure(call: Call<List<MainModel>>, t: Throwable) {
                    showLoading(false)
                    Log.d("MainActivity", "error: $t")
                }

                override fun onResponse(call: Call<List<MainModel>>, response: Response<List<MainModel>>) {
                    showLoading(false)
                    Log.d("MainActivity", "response: $response")
                    if (response.isSuccessful) {
                        val mainModel: List<MainModel> = response.body()!!
                        Log.d("MainActivity", "mainModel: $mainModel")
                        setResponse( mainModel )
                    }

                }

            } )
    }

    private fun setResponse(mainModel: List<MainModel>){
        val result = mainModel[0]
        textViewResult.setText(
            "Positif: ${result.positif} \nSembuh: ${result.sembuh} \nMeninggal: ${result.meninggal}"
        )
    }

    private fun showLoading(loading: Boolean){
        when (loading) {
            true -> progressBar.visibility = View.GONE
            true -> progressBar.visibility = View.GONE
        }
    }

}
