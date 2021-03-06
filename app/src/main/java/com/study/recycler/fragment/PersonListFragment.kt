package com.study.recycler.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.study.recycler.R
import com.study.recycler.adapter.PersonAdapter
import com.study.recycler.databinding.FragmentUserListBinding
import com.study.recycler.util.AutoClearedValue
import com.study.recycler.viewModel.PersonListViewModel
import jp.wasabeef.recyclerview.animators.ScaleInAnimator

class PersonListFragment : Fragment(R.layout.fragment_user_list) {
    private var _binding: FragmentUserListBinding? = null
    private val binding get() = _binding!!
    private var personAdapter: PersonAdapter by AutoClearedValue(this)
    private val personListViewModel: PersonListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initList()
        binding.addFab.setOnClickListener { addPerson() }
        observeViewModelState()
    }

    private fun initList() {
        personAdapter = PersonAdapter { id ->
            val action = PersonListFragmentDirections.actionPersonListFragmentToDetailsFragment(id)
            findNavController().navigate(action)
        }
        with(binding.userList) {
            adapter = personAdapter
            layoutManager = LinearLayoutManager(requireContext())
            //размер не будет изменяться со временем
            setHasFixedSize(true)
            val vDividerItemDecoration = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
            addItemDecoration(vDividerItemDecoration)
            itemAnimator = ScaleInAnimator()
        }
    }

    private fun deletePerson(position: Int) {
        personListViewModel.deletePerson(position)
    }

    private fun addPerson() {
        personListViewModel.addPerson()
        binding.userList.scrollToPosition(0)
    }

    private fun observeViewModelState() {
        personListViewModel.persons.observe(viewLifecycleOwner) { newPersons ->
            personAdapter.items = newPersons
        }
        personListViewModel.showToast
            .observe(viewLifecycleOwner) {
                Toast.makeText(requireContext(), "Person was added", Toast.LENGTH_SHORT).show()
            }
    }
}