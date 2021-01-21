package com.example.mvvmproject.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.example.mvvmproject.BR

abstract class BaseFragment<VB: ViewDataBinding, VM : BaseViewModel> : Fragment() {
    protected lateinit var binding : VB
    protected abstract val viewModel : VM

    protected abstract val resource : Int

    protected abstract fun init()
    protected abstract fun observerViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, resource, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        performDataBinding()
        observerViewModel()
        init()
    }

    private fun performDataBinding(){
        binding.setVariable(BR.viewModel, viewModel)
        binding.lifecycleOwner = this
        binding.executePendingBindings()
    }
}