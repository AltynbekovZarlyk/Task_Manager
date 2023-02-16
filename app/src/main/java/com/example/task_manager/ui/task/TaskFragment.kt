package com.example.task_manager.ui.task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.task_manager.databinding.FragmentTaskBinding
import com.example.task_manager.model.Task
import com.example.task_manager.ui.home.HomeFragment

class TaskFragment : Fragment() {

    private lateinit var binding: FragmentTaskBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSave.setOnClickListener {
            val task = Task(binding.etTitle.text.toString(), binding.etDesc.text.toString())
            setFragmentResult(
                HomeFragment.RESULT_REQUEST_KEY,
                bundleOf(HomeFragment.TASK_KEY to task)
            )
            findNavController().navigateUp()
        }
    }
}