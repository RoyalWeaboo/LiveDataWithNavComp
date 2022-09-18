package com.malikazizali.livedatawithnavcomp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.malikazizali.livedatawithnavcomp.databinding.FragmentDetailProdukBinding

class DetailProdukFragment : Fragment() {
    lateinit var binding : FragmentDetailProdukBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailProdukBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getProductData()

        binding.btnBuy.setOnClickListener {
            val nama = arguments?.getString("name")
            val price = arguments?.getString("price")
            val msg = "Halo, saya tertarik dengan produk $nama dengan harga Rp.$price, apakah masih tersedia?"
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://api.whatsapp.com/send?phone=08882636871 Number&text=$msg"))
            startActivity(i)
        }
    }

    fun getProductData(){
        val image = arguments?.getInt("image")
        val nama = arguments?.getString("name")
        val price = arguments?.getString("price")
        val stock = arguments?.getString("stock")
        val desc = arguments?.getString("desc")

        binding.dataProduct = Product(image!!, nama!!, price!!, stock!!, desc!! )
    }

}