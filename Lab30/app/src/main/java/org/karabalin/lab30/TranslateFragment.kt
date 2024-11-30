package org.karabalin.lab30

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class TranslateFragment : Fragment() {
    private lateinit var translatedTextView: TextView
    private var catName: String? = null

    companion object {
        private const val ARG_CAT_NAME = "cat_name"

        fun newInstance(catName: String) = TranslateFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_CAT_NAME, catName)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            catName = it.getString(ARG_CAT_NAME)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_translate, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        translatedTextView = view.findViewById(R.id.text_view_translated)
        translatedTextView.text = translateCatName(catName)
    }

    private fun translateCatName(name: String?): String {
        return when(name) {
            "Siamese" -> "Сиамская"
            "Persian" -> "Персидская"
            "Maine Coon" -> "Мейн-кун"
            "Bengal" -> "Бенгальская"
            "Sphynx" -> "Сфинкс"
            else -> "Неизвестная порода"
        }
    }
}
