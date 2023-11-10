package com.example.floatersbiz.homefragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.floatersbiz.R
import com.example.floatersbiz.databinding.FragmentMoreBinding
import com.example.floatersbiz.screens.AdminLogin
import com.example.floatersbiz.screens.Login


class MoreFragment : Fragment() {
    private lateinit var binding : FragmentMoreBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.login.setOnClickListener {
            val intent = Intent(requireActivity(), Login::class.java)
            startActivity(intent)
        }
        binding.adminLogin.setOnClickListener {
            val intent = Intent(requireActivity(), AdminLogin::class.java)
            startActivity(intent)
        }


    }

}