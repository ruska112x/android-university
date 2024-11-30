package org.karabalin.lab32

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class MyAlertDialogFragment : DialogFragment() {
    interface AlertDialogListener {
        fun onDialogPositiveClick()
        fun onDialogNegativeClick()
        fun onDialogNeutralClick()
    }

    private lateinit var listener: AlertDialogListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            listener = context as AlertDialogListener
        } catch (e: ClassCastException) {
            throw ClassCastException("$context must implement AlertDialogListener")
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireActivity())
            .setTitle("Sample Alert Dialog")
            .setMessage("Do you want to proceed?")
            .setPositiveButton("Yes") { _, _ ->
                listener.onDialogPositiveClick()
            }
            .setNegativeButton("No") { _, _ ->
                listener.onDialogNegativeClick()
            }
            .setNeutralButton("Cancel") { _, _ ->
                listener.onDialogNeutralClick()
            }
            .create()
    }
}
