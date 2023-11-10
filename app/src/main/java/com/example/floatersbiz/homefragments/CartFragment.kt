package com.example.floatersbiz.homefragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.floatersbiz.R
import com.example.floatersbiz.adapters.CartAdapter
import com.example.floatersbiz.databinding.FragmentCartBinding
import com.example.floatersbiz.datamodel.ProductData


class CartFragment : Fragment(),  CartAdapter.OnCartClickListener {
    private var _binding: FragmentCartBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: CartAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var cartArrayList: ArrayList<ProductData>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCartBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.cartRecyclerView)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = CartAdapter(cartArrayList, this)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()

//        binding.btnCheckOut.setOnClickListener {
//            val intent = Intent(requireActivity(), Checkouts::class.java)
//            startActivity(intent)
//        }

    }

    override fun onCartClick(product: ProductData, position: Int) {
        Toast.makeText(requireActivity(), "Clicked", Toast.LENGTH_SHORT).show()
    }

    private fun dataInitialize() {
        cartArrayList = arrayListOf(
            ProductData("", R.drawable.bana, "Banana", "2 kg", "", "ksh 300"),
            ProductData("", R.drawable.bana, "Banana", "2 kg", "", "ksh 300"),
            ProductData("", R.drawable.fruit, "Banana", "2 kg", "", "ksh 300"),
            ProductData("", R.drawable.bana, "Banana", "2 kg", "", "ksh 300"),
            ProductData("", R.drawable.bana, "Banana", "2 kg", "", "ksh 300"),
            ProductData("", R.drawable.bana, "Banana", "2 kg", "", "ksh 300"),
            ProductData("", R.drawable.bana, "Banana", "2 kg", "", "ksh 300"),
            ProductData("", R.drawable.bana, "Banana", "2 kg", "", "ksh 300"),
            ProductData("", R.drawable.bana, "Banana", "2 kg", "", "ksh 300"),
            ProductData("", R.drawable.bana, "Banana", "2 kg", "", "ksh 300"),
            ProductData("", R.drawable.fruit, "Banana", "2 kg", "", "ksh 300"),
            ProductData("", R.drawable.bana, "Banana", "2 kg", "", "ksh 300"),
            ProductData("", R.drawable.bana, "Banana", "2 kg", "", "ksh 300"),
            ProductData("", R.drawable.bana, "Banana", "2 kg", "", "ksh 300"),
            ProductData("", R.drawable.bana, "Banana", "2 kg", "", "ksh 300"),
            ProductData("", R.drawable.bana, "Banana", "2 kg", "", "ksh 300"),
            ProductData("", R.drawable.bana, "Banana", "2 kg", "", "ksh 300"),

            )
    }

}