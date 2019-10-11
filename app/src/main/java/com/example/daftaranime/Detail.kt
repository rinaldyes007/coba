package com.example.daftaranime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class Detail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvJudul : TextView = findViewById(R.id.judul)
        val tvDesc : TextView = findViewById(R.id.deskrip)
        val gbranime : ImageView = findViewById(R.id.fotoAnime)

        val jdl = intent.getStringExtra(EXTRA_JUDUL)
        val dsc = intent.getStringExtra(EXTRA_DESC)
        val pic = intent.getIntExtra(EXTRA_PIC, 0)

        tvJudul.text = jdl
        tvDesc.text = dsc
        gbranime.setImageResource(pic)
    }


    companion object {
        const val EXTRA_JUDUL = "extra_judul"
        const val EXTRA_DESC = "extra_desc"
        const val  EXTRA_PIC = "extra_pic"
    }
}
