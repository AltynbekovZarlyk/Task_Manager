package com.example.task_manager.ui.onBoard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.task_manager.databinding.ItemOnBoardingBinding
import com.example.task_manager.model.OnBoard
import com.example.task_manager.utils.loadImage

class OnBoardingAdapter(private val onStartClick:()->Unit)
    : Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    val data = arrayListOf<OnBoard>(
        OnBoard(
            "Convenience",
            "Our offer is always there",
            "https://img.freepik.com/free-vector/hand-drawn-business-planning-with-task-list_23-2149164275.jpg"
        ),
        OnBoard(
            "Productivity",
            "Plan your day ahead",
            "https://toggl.com/blog/wp-content/uploads/2018/09/project-task-list.jpg"
        ),
        OnBoard(
            "We listen to consumers",
            "The program was created taking info account the users request",
            "https://d57439wlqx3vo.cloudfront.net/iblock/f5d/f5dcf76697107ea302a1981718e33c95/1f68f84b53199df9cae4b253225eae63.png"
        )
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemOnBoardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(data.get(position))
    }

    override fun getItemCount(): Int = data.size

    inner class OnBoardingViewHolder(private val binding: ItemOnBoardingBinding) :
        ViewHolder(binding.root) {
        fun bind(onBoard: OnBoard) {
            binding.btnStart.isVisible = adapterPosition == 2
            binding.btnSkip.isVisible = adapterPosition != 2

            binding.btnStart.setOnClickListener {onStartClick()}
            binding.btnSkip.setOnClickListener {onStartClick()}

            binding.tvTitle.text = onBoard.title
            binding.tvDescription.text = onBoard.desc
            binding.ivBoard.loadImage(onBoard.image.toString())
        }
    }

}