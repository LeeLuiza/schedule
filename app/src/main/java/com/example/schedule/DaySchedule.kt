package com.example.schedule

data class DaySchedule(
    val dayOfWeek: String,
    val lessons: List<Schedule>
)