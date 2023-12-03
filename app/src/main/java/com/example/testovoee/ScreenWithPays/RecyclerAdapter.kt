package com.example.testovoee.ScreenWithPays

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.testovoee.databinding.PaymentItemBinding
import com.example.testovoee.entities.Payments.ResponseX

class RecyclerAdapter(private val data : List<ResponseX>): Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding= PaymentItemBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            binding.id.text = data[position].id.toString()
            binding.amount.text = data[position].amount.toString()
            binding.created.text = data[position].created.toString()
            binding.title.text= data[position].title.toString()
        }
    }
}

class ViewHolder(val binding: PaymentItemBinding): RecyclerView.ViewHolder(binding.root){

}