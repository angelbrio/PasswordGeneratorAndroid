package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.autofill.AutofillManager
import android.content.Context
import android.widget.EditText
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Obtén el AutofillManager del sistema de manera segura
        val autofillManager = ContextCompat.getSystemService(this, AutofillManager::class.java)

        // Referencia al campo de contraseña
        val passwordField = findViewById<EditText>(R.id.password)

        // Configura un listener para que al obtener foco, se active el autofill
        passwordField.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus && autofillManager != null) {
                // Solicita la sugerencia de autofill cuando el campo de contraseña obtiene foco
                autofillManager.requestAutofill(passwordField)
            }
        }
    }
}


