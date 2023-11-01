package com.example.lat10

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lat10.databinding.ItemRestaurantBinding

typealias OnClickRestaaurant = (Restaurant) -> Unit
class RestaurantAdapter(private val listRestaurant: List<Restaurant>,
    private val onClickRestaaurant: OnClickRestaaurant) :
    RecyclerView.Adapter<RestaurantAdapter.ItemRestaurantViewHolder>() {

    inner class ItemRestaurantViewHolder (private val
            binding: ItemRestaurantBinding
    ):
    RecyclerView.ViewHolder(binding.root){
        fun bind(data : Restaurant) {
            with(binding){
                restoNameTxt.text = data.name
                restoTypeTxt.text = data.type

                itemView.setOnClickListener{
                    onClickRestaaurant(data)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemRestaurantViewHolder {
        val binding = ItemRestaurantBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemRestaurantViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listRestaurant.size
    }

    override fun onBindViewHolder(holder: ItemRestaurantViewHolder, position: Int) {
        holder.bind(listRestaurant[position])
    }

}