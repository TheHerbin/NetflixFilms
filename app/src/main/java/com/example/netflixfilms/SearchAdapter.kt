package com.example.netflixfilms

import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.netflixfilms.modeles.Search
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.netflixfilms.api.RetrofitInstance
import kotlinx.coroutines.*
import java.util.*
import com.example.netflixfilms.modeles.SearchResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class SearchAdapter(var countryDisplay : TextView,var Search: List<Search>): RecyclerView.Adapter<SearchViewHolder>() {
    private val countryList : String = ""



    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        TODO("Not yet implemented")
    }

    fun onCreate() {
        Log.d("onCreate : ",this.Search[0].getClistToString())
        this.countryDisplay.text = this.Search[0].getClistToString()
    }


}

class SearchViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){


    fun bind(uneRecherche: Search) {

    }

}
