package com.example.mimowsapp
import com.example.mimowsapp.service.ApiManager
import com.example.mimowsapp.controller.PostAdapter
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.sqlite.SQLiteConnection
import androidx.sqlite.SQLiteDriver
import com.example.mimowsapp.database.MyDatabaseHelper

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
//Instanciar conexão com o banco

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val helper = MyDatabaseHelper(this,"./database/users.db",1)
        // Obter os posts da API
        ApiManager.getPosts { posts, error ->
            if (error != null) {
                Toast.makeText(this, "Erro ao obter os posts: $error", Toast.LENGTH_SHORT).show()
            } else {
                posts?.let {
                    val adapter = PostAdapter(it)
                    recyclerView.adapter = adapter
                }
            }
        }
    }
}
