package com.malikazizali.livedatawithnavcomp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.malikazizali.livedatawithnavcomp.databinding.ItemProductBinding

class ProductAdapter (var listProduct : ArrayList<Product>) : RecyclerView.Adapter<ProductAdapter.ViewHolder>(){
    class ViewHolder (val binding : ItemProductBinding) : RecyclerView.ViewHolder(binding.root) {
        fun dataBind(itemData : Product){
            binding.dataProduct = itemData
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.dataBind(listProduct[position])
        val img = listProduct[position].image
        val name = listProduct[position].name
        val price = listProduct[position].price
        val stock = listProduct[position].stock
        val desc = listProduct[position].description
        holder.binding.cvProduct.setOnClickListener {

        }
        holder.binding.cvProduct.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                val bun = Bundle()
                bun.putString("price", price)
                bun.putString("name", name)
                bun.putInt("image", img)
                bun.putString("stock", stock)
                bun.putString("desc", desc)

                Navigation.findNavController(holder.itemView).navigate(R.id.action_listProduct_to_detailProdukFragment, bun)

            }
        })
    }

    override fun getItemCount(): Int {
        return listProduct.size
    }

    fun setDataProduct(itemData : ArrayList<Product>){
        this.listProduct = itemData
    }

}