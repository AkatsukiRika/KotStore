package com.tangping.kotstore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.tangping.kotstore.databinding.FragmentSecondBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initData()
        initListeners()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initData() {
        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
        lifecycleScope.launch(Dispatchers.Main) {
            binding.stringPrefEditText.setText(SampleFlowStore.demoString.first())
            binding.intPrefEditText.setText(SampleFlowStore.demoInt.first().toString())
            binding.longPrefEditText.setText(SampleFlowStore.demoLong.first().toString())
            binding.floatPrefEditText.setText(SampleFlowStore.demoFloat.first().toString())
            binding.doublePrefEditText.setText(SampleFlowStore.demoDouble.first().toString())
            binding.booleanPrefSwitch.isChecked = SampleFlowStore.demoBoolean.first()
        }
    }

    private fun initListeners() {
        binding.stringPrefSaveBtn.setOnClickListener {
            lifecycleScope.launch {
                SampleFlowStore.demoString.emit(binding.stringPrefEditText.text.toString())
                Snackbar.make(requireView(), "Saved to String Flow Pref successfully", Snackbar.LENGTH_SHORT).show()
            }
        }
        binding.intPrefSaveBtn.setOnClickListener {
            lifecycleScope.launch {
                try {
                    SampleFlowStore.demoInt.emit(binding.intPrefEditText.text.toString().toInt())
                    Snackbar.make(requireView(), "Saved to Int Flow Pref successfully", Snackbar.LENGTH_SHORT).show()
                } catch (e: NumberFormatException) {
                    Snackbar.make(requireView(), "Please enter an Int value", Snackbar.LENGTH_SHORT).show()
                }
            }
        }
        binding.longPrefSaveBtn.setOnClickListener {
            lifecycleScope.launch {
                try {
                    SampleFlowStore.demoLong.emit(binding.longPrefEditText.text.toString().toLong())
                    Snackbar.make(requireView(), "Saved to Long Flow Pref successfully", Snackbar.LENGTH_SHORT).show()
                } catch (e: NumberFormatException) {
                    Snackbar.make(requireView(), "Please enter a Long value", Snackbar.LENGTH_SHORT).show()
                }
            }
        }
        binding.floatPrefSaveBtn.setOnClickListener {
            lifecycleScope.launch {
                try {
                    SampleFlowStore.demoFloat.emit(binding.floatPrefEditText.text.toString().toFloat())
                    Snackbar.make(requireView(), "Saved to Float Flow Pref successfully", Snackbar.LENGTH_SHORT).show()
                } catch (e: NumberFormatException) {
                    Snackbar.make(requireView(), "Please enter a Float value", Snackbar.LENGTH_SHORT).show()
                }
            }
        }
        binding.doublePrefSaveBtn.setOnClickListener {
            lifecycleScope.launch {
                try {
                    SampleFlowStore.demoDouble.emit(binding.doublePrefEditText.text.toString().toDouble())
                    Snackbar.make(requireView(), "Saved to Double Flow Pref successfully", Snackbar.LENGTH_SHORT).show()
                } catch (e: NumberFormatException) {
                    Snackbar.make(requireView(), "Please enter a Double value", Snackbar.LENGTH_SHORT).show()
                }
            }
        }
        binding.booleanPrefSwitch.setOnCheckedChangeListener { _, isChecked ->
            lifecycleScope.launch {
                SampleFlowStore.demoBoolean.emit(isChecked)
            }
        }
    }
}