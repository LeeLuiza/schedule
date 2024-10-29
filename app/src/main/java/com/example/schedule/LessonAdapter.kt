package com.example.schedule

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LessonAdapter(private val lessons: List<Schedule>) : RecyclerView.Adapter<LessonAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonAdapter.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_lesson, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return lessons.size
    }

    override fun onBindViewHolder(holder: LessonAdapter.ViewHolder, position: Int) {
        val schedule = lessons[position]
        holder.lessonNameTextView.text = schedule.subject
        holder.lessonTeacherView.text = schedule.teacher
        holder.lessonAuditoriumView.text = schedule.room
        holder.lessonTimeTextView.text = "${schedule.startTime} - ${schedule.endTime}"
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val lessonNameTextView: TextView = itemView.findViewById(R.id.lesson_name)
        val lessonTeacherView: TextView = itemView.findViewById(R.id.lesson_teacher)
        val lessonAuditoriumView: TextView = itemView.findViewById(R.id.lesson_auditorium)
        val lessonTimeTextView: TextView = itemView.findViewById(R.id.lesson_time)
    }
}