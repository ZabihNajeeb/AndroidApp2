package com.trios2024evmg.listmaker

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.EditText
import com.trios2024evmg.listmaker.ui.main.MainFragment
import com.trios2024evmg.listmaker.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState

                binding = ActivityMainBinding.inflate(layoutInflater)
                val view = binding.root

        setContentView(view)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }

        binding.fabButton.setOnclikListener{
            showCreateListDialog()
        }
    }

    private fun showCreateListDialog() {

        val dialogTitle = getString(R.string.name_of_list)
        val positiveButtonTitle = getString(R.string.create_list)


        val builder = AlertDialog.Builder(this)
        val listTitleEditText = EditText(this)
        listTitleEditText.inputType = InputType.TYPE_CLASS_TEXT

        builder.setTitle(dialogTitle)
        builder.setView(listTitleEditText)

        builder.setPositiveButton(positiveButtonTitle) {
                dialog, _ -> dialog.dismiss()
        }

        builder.create().show()
    }

}