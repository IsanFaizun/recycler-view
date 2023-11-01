package com.example.lat10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lat10.databinding.ActivityMainBinding
import kotlinx.coroutines.withTimeoutOrNull

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapterRestaurant = RestaurantAdapter(generateRestaurant()){
            restaurant -> Toast.makeText(this@MainActivity, "Hey, you clicked on ${restaurant.name}", Toast.LENGTH_SHORT).show()
        }
        with(binding){
            rvRestaurant.apply {
                adapter = adapterRestaurant
//                layoutManager = LinearLayoutManager(this@MainActivity)
                layoutManager = GridLayoutManager(this@MainActivity, 2)
            }
        }
    }

    fun generateRestaurant(): List<Restaurant> {
        return listOf(
            Restaurant(name = "McDonalds", type = "Western"),
            Restaurant(name = "Borga", type = "Korean"),
            Restaurant(name = "Sushi", type = "Japan"),
            Restaurant(name = "Mas Kobis", type = "Javanese"),
            Restaurant(name = "Loko", type = "Indonesian")
        )
    }
}