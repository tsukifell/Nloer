package com.cepotdev.nloer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvAngkringan : RecyclerView
    private val list = ArrayList<Angkringan>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvAngkringan = findViewById(R.id.rv_angkringList)
        rvAngkringan.setHasFixedSize(true)

        list.addAll(getListAngkringan())
        showRecyclerList()

    }
    private fun getListAngkringan(): ArrayList<Angkringan>{
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_addressOpHour)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listAngkringan = ArrayList<Angkringan>()
        for (i in dataName.indices){
            val angkringan = Angkringan(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listAngkringan.add(angkringan)
        }
        return listAngkringan
    }

    private fun showRecyclerList(){
        rvAngkringan.layoutManager = LinearLayoutManager(this)
        val listAngkringanAdapter = ListAngkringanAdapter(list)
        rvAngkringan.adapter = listAngkringanAdapter
    }
}