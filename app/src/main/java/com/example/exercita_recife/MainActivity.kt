package com.example.exercita_recife

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.exercita_recife.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate( layoutInflater )
        setContentView( binding.root )

        val edPassword = binding.edPassword
        val edName = binding.edName
        val edButtonLogin = binding.edButtonLogin

        edButtonLogin.setOnClickListener {
            if ( edName.text.isEmpty() || edPassword.text.isEmpty() ){
                Toast.makeText( this, "Prenecher todos os campos", Toast.LENGTH_SHORT).show()
            }
            else {
                val intent = Intent( this, MainActivity2:: class.java)
                startActivity(intent)
            }
        }

    }

}