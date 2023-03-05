package com.cepotdev.nloer

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class DetailActivity : AppCompatActivity() {
    private lateinit var tvDetailNama: TextView
    private lateinit var ivDetailFoto: ImageView
    private lateinit var tvDetailDeskripsi: TextView
    private lateinit var tvDetailListMenu: TextView
    private lateinit var btnShareDesc: Button


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
        tvDetailListMenu = findViewById(R.id.tv_detail_listMenu)
        btnShareDesc = findViewById(R.id.action_share)

        tvDetailNama.text = dataAngkringan.name
        ivDetailFoto.setImageResource(dataAngkringan.photo)
        tvDetailDeskripsi.text = dataAngkringan.description
        tvDetailListMenu.text = dataAngkringan.menu

        btnShareDesc.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, dataAngkringan.description)
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }


    }
}