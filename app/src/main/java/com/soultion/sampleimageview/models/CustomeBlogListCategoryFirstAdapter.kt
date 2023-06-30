package com.soultion.sampleimageview.models

import android.content.Context
import android.text.Html
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.samplesimage.R

class CustomeBlogListCategoryFirstAdapter (var listCities: ArrayList<Images>, var context: Context): RecyclerView.Adapter<CustomeBlogListCategoryFirstAdapter.AppListViewHolder>() {
    var stringStatus:String?="2"
    var statusPosition:String?="0"
    fun updateAppList(newAppList:List<Images>){
        listCities.clear()
        listCities.addAll(newAppList)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= AppListViewHolder(
       LayoutInflater.from(parent.context). inflate(R.layout.customerlist,parent,false)

    )
    override fun getItemCount()=listCities.size

    override fun onBindViewHolder(holder: AppListViewHolder, position: Int) {
//        holder._relativeCategoryClick.setOnClickListener {
//            if (listCities[position].children!!.isNotEmpty()){
//                categoryClickMethod._categoryClickMethod(listCities[position].term_id!!.toInt(),listCities[position].name.toString(),1,0)
//            }
//            else{
//                categoryClickMethod._categoryClickMethod(listCities[position].term_id!!.toInt(),listCities[position].name.toString(),2,5)
//            }
//        }
        holder.bind(listCities[position])
    }

    class AppListViewHolder(view: View): RecyclerView.ViewHolder(view){
        var _menuItemName=view.findViewById<TextView>(R.id.customerAddress)
        fun bind(portalAppModel:Images){
            for (i in portalAppModel.indices){
                Log.e("DataItem",portalAppModel[i].title)
                _menuItemName.setText(portalAppModel[i].title)
            }
//            var _name = Html.fromHtml(portalAppModel..toString()).toString()
//            _menuItemName.text=_name
        }
    }
}