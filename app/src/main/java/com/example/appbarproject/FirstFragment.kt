package com.example.appbarproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appbarproject.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    lateinit var binding: FragmentFirstBinding
    var dataList = mutableListOf<DataVO>()
    lateinit var  customAdapter: CustomAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)

        /*리싸이클러뷰에 데이터리스트를 제작한다.*/
        for (i in 1..29) {
            if (i % 2 == 0) {
                dataList.add(DataVO("씨리얼${i}", "29", R.drawable.person00))
            } else {
                dataList.add(DataVO("엄마손${i}", "29", R.drawable.person01))
            }
        }
        /*리싸이클러뷰에 보여줄 레이아웃 결정*/
        val linearLayoutManager = LinearLayoutManager(container?.context)
        //리싸이클러뷰에 제공할 어뎁터
        val customAdapter = CustomAdapter(dataList)

        this.customAdapter = customAdapter

        //리싸이클러뷰에 연결
        binding.recyclerView.layoutManager = linearLayoutManager
        binding.recyclerView.adapter = customAdapter
        //데코레이션 여기서 연걸
        binding.recyclerView.addItemDecoration(Decoration(requireContext()))
        //플로팅탭을 누르면 사용자 다이얼로그 보여줘서 입력한 데이터를 datalist에 추가
//        binding.btnFloating.setOnClickListener {
//            CustomDialog(binding.root.context, binding).showDialog()
//        }
        return binding.root
    }

    fun refreshRecyclerViewAdd(dataVO:DataVO){
        Toast.makeText(binding.root.context,"${dataVO}", Toast.LENGTH_SHORT).show()
        dataList.add(dataVO)
        customAdapter.notifyDataSetChanged()
    }

    fun refreshRecyclerviewDrop(dataVO: DataVO) {
        Toast.makeText(binding.root.context,"${dataVO}", Toast.LENGTH_SHORT).show()
        dataList.remove(dataVO)
        customAdapter.notifyDataSetChanged()
    }
}