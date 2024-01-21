package com.alexlyxy.alexretrofit.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.alexlyxy.alexretrofit.R
import com.alexlyxy.alexretrofit.databinding.ListItemBinding
import com.squareup.picasso.Picasso

class TroikaAdapter : ListAdapter<TroikaModel, TroikaAdapter.Holder>(Comparator()) {
    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ListItemBinding.bind(view)
        private var itemTroika: TroikaModel? = null

        fun bind(item: TroikaModel) = with(binding) {
            itemTroika = item

            //PRODUCT:
            tvPrId.text = item.id.toString()
            tvPrTitle.text = item.title
            tvPrDescr.text = item.description
            tvPrPrice.text = item.price.toString()

//            //DOGS:
//            tvDogStat.text = item.status
//
//            //DOGSALL:
//            Picasso.get().load(item.dogOne).into(ivDoggOne)
//            Picasso.get().load(item.dogTwo).into(ivDoggTwo)
//            Picasso.get().load(item.dogThree).into(ivDoggThree)
//            Picasso.get().load(item.dogFour).into(ivDoggFour)
//            Picasso.get().load(item.dogFive).into(ivDoggFive)
//
//            //COIN:
//            tvCoinName.text = item.name
//            tvCoinFullName.text = item.fullName
//
//            //WEATHER:
//            tvDateZero.text = item.dateZero
//            tvDateOne.text = item.dateOne
//            tvDateTwo.text = item.dateTwo
        }
    }

//    class Comparator : DiffUtil.ItemCallback<TroikaModel>() {
//        override fun areItemsTheSame(oldItem: TroikaModel, newItem: TroikaModel): Boolean {
//            return oldItem == newItem
//        }
//
//        override fun areContentsTheSame(oldItem: TroikaModel, newItem: TroikaModel): Boolean {
//            return oldItem == newItem
//        }
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return Holder(view)

    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }
}