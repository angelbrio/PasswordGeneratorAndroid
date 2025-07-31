package com.example.myapplication

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.autofill.AutofillManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import android.text.method.PasswordTransformationMethod
import android.text.method.HideReturnsTransformationMethod
import android.text.Editable
import android.text.TextWatcher

class MainActivity : AppCompatActivity() {

    private lateinit var passwordField: EditText
    private lateinit var strengthLabel: TextView
    private lateinit var toggleButton: ImageButton
    private lateinit var autofillManager: AutofillManager
    private var isPasswordVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initialize the AutofillManager to request password suggestions from the system
        autofillManager = ContextCompat.getSystemService(this, AutofillManager::class.java)!!

        //Link UI elements from the layout
        val usernameField = findViewById<EditText>(R.id.username)
        passwordField = findViewById(R.id.password)
        strengthLabel = findViewById(R.id.strengthText)
        toggleButton = findViewById(R.id.togglePasswordBtn)
        val generateButton = findViewById<Button>(R.id.generateBtn)
        val copyButton = findViewById<Button>(R.id.copyBtn)

        //Request system autofill when the password field gains focus
        passwordField.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                autofillManager.requestAutofill(passwordField)
            }
        }

        //Toggle password visibility when the eye icon is clicked
        toggleButton.setOnClickListener {
            togglePasswordVisibility()
        }

        //Generate a strong random password and insert it into the field
        generateButton.setOnClickListener {
            val password = generateSecurePassword()
            passwordField.setText(password)
            evaluateStrength(password)
        }

        //Copy the current password to the clipboard
        copyButton.setOnClickListener {
            val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("Contraseña", passwordField.text.toString())
            clipboard.setPrimaryClip(clip)
            Toast.makeText(this, "Contraseña copiada", Toast.LENGTH_SHORT).show()
        }

        //Analyze password strength as the user types
        passwordField.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                evaluateStrength(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }

    //Show or hide the password when the user taps the eye icon
    private fun togglePasswordVisibility() {
        if (isPasswordVisible) {
            //Hide the password
            passwordField.transformationMethod = PasswordTransformationMethod.getInstance()
            toggleButton.setImageResource(android.R.drawable.ic_menu_view)
        } else {
            //Show the password
            passwordField.transformationMethod = HideReturnsTransformationMethod.getInstance()
            toggleButton.setImageResource(android.R.drawable.ic_menu_close_clear_cancel)
        }
        isPasswordVisible = !isPasswordVisible
        passwordField.setSelection(passwordField.text.length) // keep cursor at the end
    }

    //Create a strong, random 12-character password using letters, numbers, and symbols
    private fun generateSecurePassword(): String {
        val chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#\$%^&*()_+-=[]{}|;:,.<>?"
        return (1..12).map { chars.random() }.joinToString("")
    }

    //Evaluate password strength and display it using color and text
    private fun evaluateStrength(password: String) {
        val strength = getPasswordStrength(password)
        strengthLabel.text = "Fortaleza: $strength"
        strengthLabel.setTextColor(
            when (strength) {
                "Débil" -> ContextCompat.getColor(this, android.R.color.holo_red_dark)
                "Media" -> ContextCompat.getColor(this, android.R.color.holo_orange_dark)
                "Fuerte" -> ContextCompat.getColor(this, android.R.color.holo_green_dark)
                else -> ContextCompat.getColor(this, android.R.color.darker_gray)
            }
        )
    }

    //Analyze the password content and return a human-readable strength level
    private fun getPasswordStrength(password: String): String {
        val length = password.length
        val hasUpper = password.any { it.isUpperCase() }
        val hasLower = password.any { it.isLowerCase() }
        val hasDigit = password.any { it.isDigit() }
        val hasSpecial = password.any { !it.isLetterOrDigit() }

        return when {
            length >= 12 && hasUpper && hasLower && hasDigit && hasSpecial -> "Fuerte"
            length >= 8 && (hasUpper || hasSpecial) && hasDigit -> "Media"
            else -> "Débil"
        }
    }
}
