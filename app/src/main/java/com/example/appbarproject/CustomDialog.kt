package com.example.appbarproject

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.WindowManager
import com.example.appbarproject.databinding.DialogCustomBinding
import com.example.appbarproject.databinding.FragmentFirstBinding

class CustomDialog(val context: Context, val firstFragment: FragmentFirstBinding) {
    val dialog = Dialog(context)

    fun showDialog() {
        val binding = DialogCustomBinding.inflate(LayoutInflater.from(context))
        dialog.setContentView(binding.root)
        dialog.window!!.setLayout(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
        dialog.setCanceledOnTouchOutside(true)

        dialog.setCancelable(true)
        dialog.show()

        binding.dialogBtnCancle.setOnClickListener {
            dialog.dismiss()
        }
        binding.dialogBtnOk.setOnClickListener {
            val name = binding.dialogEtvName.text.toString()
            val age = binding.dialogEtvAge.text.toString()
            val number = (Math.random() * 100).toInt()
            var dataVO: DataVO


            dataVO = if (number % 2 == 0) {
                DataVO(name, age, R.drawable.person01)
            } else {
                DataVO(name, age, R.drawable.person00)
            }
            (context as MainActivity).firstFragment.refreshRecyclerViewAdd(dataVO)
            dialog.dismiss()
        }
    }
}