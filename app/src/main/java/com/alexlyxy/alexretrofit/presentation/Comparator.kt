package com.alexlyxy.alexretrofit.presentation

import androidx.recyclerview.widget.DiffUtil
import com.alexlyxy.alexretrofit.presentation.TroikaModel

class Comparator : DiffUtil.ItemCallback<TroikaModel>() {
    override fun areItemsTheSame(oldItem: TroikaModel, newItem: TroikaModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: TroikaModel, newItem: TroikaModel): Boolean {
        return oldItem == newItem
    }
}
