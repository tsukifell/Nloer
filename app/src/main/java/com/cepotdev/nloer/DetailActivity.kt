package com.cepotdev.nloer

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class DetailActivity : AppCompatActivity() {
    private lateinit var tvDetailNama: TextView
    private lateinit var ivDetailFoto: ImageView
    private lateinit var tvDetailDeskripsi: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val dataAngkringan = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Angkringan>("key_angkringan") as Angkringan
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Angkringan>("key_angkringan") as Angkringan
        }

        tvDetailNama = findViewById(R.id.tv_detail_nama)
        ivDetailFoto = findViewById(R.id.iv_detail_foto)
        tvDetailDeskripsi = findViewById(R.id.tv_detail_deskripsi)

        tvDetailNama.text = dataAngkringan.name
        ivDetailFoto.setImageResource(dataAngkringan.photo)
        tvDetailDeskripsi.text = dataAngkringan.description
    }
}