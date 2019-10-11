package com.example.daftaranime

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var bitmap: Bitmap

    private lateinit var rv_list: RecyclerView
    private var list: ArrayList<anime> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_list= findViewById(R.id.listAnime)
        rv_list.setHasFixedSize(true)

        list.addAll(AnimeData.list_anime_data)
        showRecycleList()
    }

    private fun showRecycleList() {
        rv_list.layoutManager = LinearLayoutManager(this)
        val listAnimeAdapter = ListAnimeAdapter(list)
        rv_list.adapter = listAnimeAdapter

        listAnimeAdapter.setOnItemClickCallback(object : ListAnimeAdapter.OnItemClickCallBack {
            override fun onItemClicked(data: anime) {
                val intent = Intent(this@MainActivity, Detail::class.java)
                intent.putExtra(Detail.EXTRA_JUDUL, data.judul)
                intent.putExtra(Detail.EXTRA_DESC, data.deskripsi)
                intent.putExtra(Detail.EXTRA_PIC, data.gambar)

                startActivity(intent)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.main,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        var selectedOption = ""

        when(item?.itemId) {
            R.id.about -> selectedOption = "About"
           // R.id.bukan_about -> selectedOption = "a"

        }
        if (selectedOption == "About") {
            val intent = Intent(this@MainActivity, AboutActivity::class.java)
            startActivity(intent)
            }
//        else {
//            Toast.makeText(this,"salaaaah", Toast.LENGTH_SHORT).show()
//        }
        return super.onOptionsItemSelected(item)
    }
}
