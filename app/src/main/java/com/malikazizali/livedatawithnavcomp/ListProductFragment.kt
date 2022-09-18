package com.malikazizali.livedatawithnavcomp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.malikazizali.livedatawithnavcomp.databinding.FragmentListProductBinding

class ListProductFragment : Fragment() {
    lateinit var vmProduct : ProductViewModel
    lateinit var adapterProduct: ProductAdapter
    lateinit var binding : FragmentListProductBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListProductBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vmProduct = ViewModelProvider(this).get(ProductViewModel::class.java)
        adapterProduct = ProductAdapter(ArrayList())
        vmProduct.getProductData()

        vmProduct.product.observe(viewLifecycleOwner, Observer {
            adapterProduct.setDataProduct(it as ArrayList<Product>)
        })


        binding.rvProduct.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvProduct.adapter = adapterProduct
    }

}