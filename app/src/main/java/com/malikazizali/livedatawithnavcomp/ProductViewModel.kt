package com.malikazizali.livedatawithnavcomp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProductViewModel : ViewModel(){
    val listProduk = arrayListOf(
        Product(R.drawable.laptop_acer, "Laptop Acer", "Rp.12.000.000", "3", "Laptop Acer Aspire 5 yang dilengkapi dengan processor Ryzen 3 5300U dan 8 GB (2*4GB) DDR4 Dual Channel memory, 1 Slot Replaceable") ,
        Product(R.drawable.mouse_rexus, "Mouse Rexus", "Rp.150.000", "25", "Mouse Gaming merk Rexus yang cocok untuk Gamer dalam memaikan game Favoritnya") ,
        Product(R.drawable.keyboard_mech, "Mechanical Keyboard RGB", "Rp.1.200.000", "5", "Keyboard mekanik lebih taktil, tahan lama, dan lebih cepat dibandingkan keyboar biasa sehingga sangat cocok untuk para Gamers") ,
        Product(R.drawable.samsung, "Handphone Samsung Flip", "Rp.5.000.000", "23", "Handphone Samsung keluaran terbaru dengan fitur flippable screen dan yang pastinya degan fitur lainnya yang tidak kalah keren") ,
        Product(R.drawable.tws_xiaomi, "TWS Xiaomi", "Rp.450.000", "80", "TWS merk Xiaomi Ori yang nyaman digunakan untuk sehari hari dan memiliki kualitas yang bagus tidak hanya disuara namun juga di microphone nya") ,
        Product(R.drawable.headphone_l, "Headphone Logitech", "Rp.500.000", "32", "Headphone yang dibuat khusus untuk gamers sehingga dapat merasakan sensasi bermain game yang lebih mantap dan menantang")
    )

    val product : MutableLiveData<List<Product>> = MutableLiveData()

    fun getProductData(){
        product.value = listProduk
    }
}