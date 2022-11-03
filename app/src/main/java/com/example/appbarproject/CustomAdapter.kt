package com.example.appbarproject

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.appbarproject.databinding.ItemMainBinding

class CustomAdapter(val dataList: MutableList<DataVO>) :RecyclerView.Adapter<CustomAdapter.CustomViewHolder>(){

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val binding = ItemMainBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        val customViewHolder =  CustomViewHolder(binding)

            /*아이템 항목에 이벤트 설정*/
        customViewHolder.itemView.setOnClickListener{
            /*아이템누르는 위치*/
            val position:Int =  customViewHolder.bindingAdapterPosition
            val dataVO = dataList.get(position)
            Toast.makeText(parent.context, "NAME:${dataVO.name}, AGE:${dataVO.age},",Toast.LENGTH_SHORT).show()
        }
        //아이템 롱클릭했을때 삭제
        customViewHolder.itemView.setOnLongClickListener{
            val position:Int =  customViewHolder.bindingAdapterPosition
            val dataVO = dataList.get(position)
            (parent.context as MainActivity).firstFragment.refreshRecyclerviewDrop(dataVO)
            true
        }
        return customViewHolder
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val binding = (holder as CustomViewHolder).binding
        val dataVO = dataList[position]

        binding.imageView2.setImageResource(dataVO.picture)
        binding.tvName.text = dataVO.name
        binding.tvAge.text = dataVO.age
    }

   class CustomViewHolder(val binding: ItemMainBinding):RecyclerView.ViewHolder(binding.root)
}