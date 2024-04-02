package com.tangping.kotstore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.tangping.kotstore.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
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
        binding.stringPrefEditText.setText(SampleStore.demoString)
        binding.intPrefEditText.setText(SampleStore.demoInt.toString())
        binding.longPrefEditText.setText(SampleStore.demoLong.toString())
        binding.floatPrefEditText.setText(SampleStore.demoFloat.toString())
        binding.doublePrefEditText.setText(SampleStore.demoDouble.toString())
        binding.booleanPrefSwitch.isChecked = SampleStore.demoBoolean
    }

    private fun initListeners() {
        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
        binding.stringPrefSaveBtn.setOnClickListener {
            SampleStore.demoString = binding.stringPrefEditText.text.toString()
            Snackbar.make(requireView(), "Saved to String Pref successfully", Snackbar.LENGTH_SHORT).show()
        }
        binding.intPrefSaveBtn.setOnClickListener {
            try {
                SampleStore.demoInt = binding.intPrefEditText.text.toString().toInt()
                Snackbar.make(requireView(), "Saved to Int Pref successfully", Snackbar.LENGTH_SHORT).show()
            } catch (e: NumberFormatException) {
                Snackbar.make(requireView(), "Please enter an Int value", Snackbar.LENGTH_SHORT).show()
            }
        }
        binding.longPrefSaveBtn.setOnClickListener {
            try {
                SampleStore.demoLong = binding.longPrefEditText.text.toString().toLong()
                Snackbar.make(requireView(), "Saved to Long Pref successfully", Snackbar.LENGTH_SHORT).show()
            } catch (e: NumberFormatException) {
                Snackbar.make(requireView(), "Please enter a Long value", Snackbar.LENGTH_SHORT).show()
            }
        }
        binding.floatPrefSaveBtn.setOnClickListener {
            try {
                SampleStore.demoFloat = binding.floatPrefEditText.text.toString().toFloat()
                Snackbar.make(requireView(), "Saved to Float Pref successfully", Snackbar.LENGTH_SHORT).show()
            } catch (e: NumberFormatException) {
                Snackbar.make(requireView(), "Please enter a Float value", Snackbar.LENGTH_SHORT).show()
            }
        }
        binding.doublePrefSaveBtn.setOnClickListener {
            try {
                SampleStore.demoDouble = binding.doublePrefEditText.text.toString().toDouble()
                Snackbar.make(requireView(), "Saved to Double Pref successfully", Snackbar.LENGTH_SHORT).show()
            } catch (e: NumberFormatException) {
                Snackbar.make(requireView(), "Please enter a Double value", Snackbar.LENGTH_SHORT).show()
            }
        }
        binding.booleanPrefSwitch.setOnCheckedChangeListener { _, isChecked ->
            SampleStore.demoBoolean = isChecked
            Snackbar.make(binding.root, "Saved to Boolean Pref successfully", Snackbar.LENGTH_SHORT).show()
        }
    }
}