package com.example.myprojectone.firstAplicattion.adapties

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myprojectone.R
import com.example.myprojectone.firstAplicattion.models.FuncionarioModelo

class EmpAdapter (private val empList: ArrayList<FuncionarioModelo>) :
    RecyclerView.Adapter<EmpAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.lista_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentEmp = empList[position]
        holder.tvEmpName.text = currentEmp.empName
    }


    override fun getItemCount(): Int {
        return empList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvEmpName : TextView = itemView.findViewById((R.id.tvEmpName))
    }



}