package com.example.floatersbiz.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.floatersbiz.databinding.PromotionItemBinding
import com.example.floatersbiz.datamodel.ProductData

class PromotionAdapter(
    private val list: ArrayList<ProductData>,
    val clickListener: OnPromoClickListener
) :
    RecyclerView.Adapter<PromotionAdapter.PromoViewHolder>() {
    inner class PromoViewHolder(val promotionItemBinding: PromotionItemBinding) :
        RecyclerView.ViewHolder(promotionItemBinding.root){
        fun setData(product: ProductData, action: OnPromoClickListener) {
            promotionItemBinding.apply {
                productTitle.text = product.productTitle
                promoTitle.text = product.promotionTitle
                product.productImage?.let { productImage.setImageResource(it) }
            }
            promotionItemBinding.root.setOnClickListener {
                action.onPromoClick(product, adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PromoViewHolder {
        return PromoViewHolder(
            PromotionItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PromoViewHolder, position: Int) {
        val product = list[position]
        holder.setData(product, clickListener)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface OnPromoClickListener {
        fun onPromoClick(product: ProductData, position: Int)
    }


}