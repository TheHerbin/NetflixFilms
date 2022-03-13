package com.example.netflixfilms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.netflixfilms.api.RetrofitInstance
import kotlinx.coroutines.*
import java.util.*
import com.example.netflixfilms.modeles.SearchResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers



class MainActivity : AppCompatActivity() {



    private var TAG = "MainActivity"
    private var key = "7a7f383dacmsh607c4979e606936p19d928jsnd986a333ce55"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var confirmButton: Button =  findViewById(R.id.confirm)
        var searchBar: EditText =  findViewById(R.id.searchBar)
        var countryDisplay: TextView =  findViewById(R.id.countryDisplay)



        // set on-click listener
        confirmButton.setOnClickListener {
            if (searchBar.text.isEmpty()){
                Toast.makeText(this@MainActivity, "Please at least fill the search bar", Toast.LENGTH_LONG).show()
            }else{

                Log.d(TAG,searchBar.text.toString())

                val compositeDisposable = CompositeDisposable()
                compositeDisposable.add(
                    RetrofitInstance.buildService().getSearch(searchBar.text.toString())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe({response -> onResponse(response)}, {t -> onFailure(t) }))

            }

        }
    }

    private fun onFailure(t: Throwable) {
        Toast.makeText(this,t.message, Toast.LENGTH_SHORT).show()
    }

    private fun onResponse(response: SearchResponse) {
        SearchAdapter(findViewById<TextView>(R.id.countryDisplay),response.results).onCreate()
    }

}






