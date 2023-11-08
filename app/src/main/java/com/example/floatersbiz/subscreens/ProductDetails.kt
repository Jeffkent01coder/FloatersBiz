package com.example.floatersbiz.subscreens

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.floatersbiz.databinding.ActivityProductDetailsBinding

class ProductDetails : AppCompatActivity() {
    private lateinit var binding: ActivityProductDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
            intent

            productImage.setImageResource(intent.getStringExtra("image")!!.toInt())
            productTitle.text = intent.getStringExtra("name")
            productQuantity.text = intent.getStringExtra("quantity")
            productPrice.text = intent.getStringExtra("price")

            var quantity = 0
            productAmount.text = quantity.toString()

            binding.btnAdd.setOnClickListener {
                quantity += 1
                productAmount.text = quantity.toString()
            }

            binding.btnSubtract.setOnClickListener {
                if (quantity < 1) {
                    quantity = 0
                } else {
                    quantity -= 1

                }
                productAmount.text = quantity.toString()

            }

        }


        binding.ivBack.setOnClickListener {
            onBackPressed()
        }
    }
}