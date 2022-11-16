package com.murat.alertdialog

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController
import com.murat.alertdialog.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    lateinit var binding: FragmentFirstBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        alert()


    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater)  {
        requireActivity().menuInflater.inflate(R.menu.menu,menu)



    }
    init {

        setHasOptionsMenu(true)
    }

    @SuppressLint("ResourceAsColor")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId ){
            android.R.id.home ->{ findNavController().navigate(R.id.firstFragment)}
            R.id.search -> {findNavController().navigate(R.id.secondFragment)}
            R.id.replace -> {binding.constraint.setBackgroundColor(R.color.purple_200)}

        }




        return true
    }


    fun alert(){
        binding.button.setOnClickListener {
            val builder = AlertDialog.Builder(requireContext())
            //set title for alert dialog
            builder.setTitle(R.string.dialogTitle)
            //set message for alert dialog
            builder.setMessage(R.string.dialogMessage)
            builder.setIcon(R.drawable.ic_dialog_alert)

            //performing positive action
            builder.setPositiveButton("Yes"){dialogInterface, which ->

                // Toast.makeText(requireContext(),"clicked yes",Toast.LENGTH_LONG).show()
                findNavController().navigate(R.id.secondFragment)
            }
            //performing cancel action
            builder.setNeutralButton("Cancel"){dialogInterface, which ->
                Toast.makeText(requireContext(),"clicked cancel\\n operation cancel",Toast.LENGTH_LONG).show()
            }

            //performing negative action
            builder.setNegativeButton("No"){dialogInterface, which ->

                Toast.makeText(requireContext(),"clicked No",Toast.LENGTH_LONG).show()
            }

            // Create the AlertDialog

            val alertDialog : AlertDialog = builder.create()

            // Set other dialog properties
            alertDialog.setCancelable(false)
            alertDialog.show()

        }
    }


}