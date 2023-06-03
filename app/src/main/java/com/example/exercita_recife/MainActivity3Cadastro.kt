package com.example.exercita_recife

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.exercita_recife.databinding.ActivityMainActivity3CadastroBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity3Cadastro : AppCompatActivity() {
    private lateinit var binding: ActivityMainActivity3CadastroBinding
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainActivity3CadastroBinding.inflate( layoutInflater )
        setContentView( binding.root )

        var edNomeAluno = binding.edNomeAluno
        var edBairroAluno = binding.edBairroAluno
        var edEmail = binding.edEmailAluno
        var edButtonCadastro = binding.edButtonCadastro

        dbRef = FirebaseDatabase.getInstance().getReference("Aluno")

        edButtonCadastro.setOnClickListener {
            val nomeAluno = edNomeAluno.text.toString()
            val bairroAluno = edBairroAluno.text.toString()
            val emailAluno = edEmail.text.toString()
         if ( nomeAluno.isEmpty() || bairroAluno.isEmpty() || emailAluno.isEmpty() ){
             Toast.makeText( this, "Prenecher todos os campos", Toast.LENGTH_SHORT).show()

         }else{
             val alunoId = dbRef.push().key!!
             val aluno = CadastroAluno(alunoId, nomeAluno, bairroAluno, emailAluno)
             dbRef.child( alunoId).setValue(aluno)
                 .addOnCompleteListener{
                     Toast.makeText(this, "Cadastro realizado com sucesso", Toast.LENGTH_SHORT).show()
                     edNomeAluno.text?.clear()
                     edBairroAluno.text?.clear()
                     edEmail.text?.clear()

                     val int = Intent(this, MainActivity4List:: class.java)
                     startActivity(int)

                 } .addOnFailureListener{
                     Toast.makeText(this, "Falha no cadastro! Refaça novamente.", Toast.LENGTH_SHORT).show()
                 }
         }
        }
    }
}