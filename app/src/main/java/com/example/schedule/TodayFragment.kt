package com.example.schedule

import android.icu.util.Calendar
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.schedule.databinding.FragmentTodayBinding

class TodayFragment : Fragment() {
    private lateinit var binding: FragmentTodayBinding
    private lateinit var adapter: DayScheduleAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentTodayBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = DayScheduleAdapter(getTodaySchedule())
        binding.recyclerView.adapter = adapter
    }

    private fun getTodaySchedule(): List<DaySchedule> {
        val scheduleData = ScheduleData()
        val today = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
        val dayScheduleList = scheduleData.getLessonToday()

        return dayScheduleList.filter { it.dayOfWeek == getDayOfWeekName(today) }
    }

    private fun getDayOfWeekName(dayOfWeek: Int): String {
        return when (dayOfWeek) {
            Calendar.MONDAY -> "Понедельник"
            Calendar.TUESDAY -> "Вторник"
            Calendar.WEDNESDAY -> "Среда"
            Calendar.THURSDAY  -> "Четверг"
            Calendar.FRIDAY -> "Пятница"
            Calendar.SATURDAY -> "Суббота"
            Calendar.SUNDAY -> "Воскресенье"
            else -> ""
        }
    }
}