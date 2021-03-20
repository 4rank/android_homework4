package com.example.fedorinchik_hw4

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ColorHexCopyActivity : AppCompatActivity() {

    private var viewColor: Int? = null
    private var nameColorCopy: String? = null
    private var hexCopy: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.color_hex_copy)
        val colorView = findViewById<View>(R.id.color_copy_view)
        val copyButton = findViewById<Button>(R.id.copyHexButton)
        val colorName = findViewById<TextView>(R.id.name)

        val bundle = intent.extras
        nameColorCopy = bundle?.getString(COLOR_NAME)
        viewColor = bundle?.getInt(COLOR_VALUES)
        hexCopy = bundle?.getString(COLOR_HEX_CODE)
        nameColorCopy?.let {
            colorName.text = it
        }
        viewColor?.let {
            colorView.setBackgroundResource(it)
        }
        copyButton.setOnClickListener {
            val clipboard: ClipboardManager =
                getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("", hexCopy)
            clipboard.setPrimaryClip(clip)
            Toast.makeText(
                this, "hex код скопирован в буфер обмена",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}