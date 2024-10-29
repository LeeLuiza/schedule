package com.example.schedule

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.schedule.databinding.FragmentTodayBinding

class WeekFragment : Fragment() {

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
        adapter = DayScheduleAdapter(getSchedule())
        binding.recyclerView.adapter = adapter
    }

    private fun getSchedule(): List<DaySchedule> {
        val scheduleData = ScheduleData()
        val scheduleList = scheduleData.getLessonToday()

        return scheduleList
    }
}