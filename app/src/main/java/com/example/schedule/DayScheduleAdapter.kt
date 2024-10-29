package com.example.schedule

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DayScheduleAdapter(private val daySchedules: List<DaySchedule>) : RecyclerView.Adapter<DayScheduleAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayScheduleAdapter.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_day, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return daySchedules.size
    }

    override fun onBindViewHolder(holder: DayScheduleAdapter.ViewHolder, position: Int) {
        val daySchedule = daySchedules[position]

        holder.dayOfWeek.text = daySchedule.dayOfWeek

        val lessonAdapter = LessonAdapter(daySchedule.lessons)
        holder.lessonsRecyclerView.adapter = lessonAdapter
        holder.lessonsRecyclerView.layoutManager = LinearLayoutManager(holder.itemView.context)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dayOfWeek: TextView = itemView.findViewById(R.id.day_name)
        val lessonsRecyclerView: RecyclerView = itemView.findViewById(R.id.internal_recycler_view)
    }
}