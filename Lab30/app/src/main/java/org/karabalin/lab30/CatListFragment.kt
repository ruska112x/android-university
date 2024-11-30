package org.karabalin.lab30

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment

class CatListFragment : Fragment() {
    private var listener: OnCatSelectedListener? = null
    private val catNames = listOf("Siamese", "Persian", "Maine Coon", "Bengal", "Sphynx")

    interface OnCatSelectedListener {
        fun onCatSelected(catName: String)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnCatSelectedListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnCatSelectedListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cat_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val listView: ListView = view.findViewById(R.id.list_view_cats)
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, catNames)
        listView.adapter = adapter
        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            listener?.onCatSelected(catNames[position])
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}
