package com.example.rickandmortyapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: RickRecycler
    private lateinit var dataset: List<RickMorty>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        dataset = ArrayList<RickMorty>()
        adapter = RickRecycler(this, dataset)
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        //recyclerView.adapter =RickRecycler(this, dataset)
        RetrofitInstance.api.getDetails().enqueue(object : retrofit2.Callback<RickMorty>{
            override fun onResponse(call: Call<RickMorty>, response: Response<RickMorty>) {
                if (response.body()!=null){
                    adapter.setData(response.body()!!.results)
                }
                else{
                    return
                }
            }

            override fun onFailure(call: Call<RickMorty>, t: Throwable) {
                Log.d("TAG",t.message.toString())
            }


        })

        }
}