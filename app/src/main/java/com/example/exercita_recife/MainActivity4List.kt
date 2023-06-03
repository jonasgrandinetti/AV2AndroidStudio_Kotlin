package com.example.exercita_recife

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class MainActivity4List : AppCompatActivity() {

    private lateinit var alunoRecyclerView: RecyclerView
    private lateinit var alunoList: ArrayList<CadastroAluno>
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_activity4_list)

        alunoRecyclerView = findViewById( R.id.edList)
        alunoRecyclerView.layoutManager = LinearLayoutManager(this)
        alunoRecyclerView.setHasFixedSize(true)
        alunoList = arrayListOf<CadastroAluno>()
        gatAlunoDate()
    }

    private fun gatAlunoDate(){
        alunoRecyclerView.visibility = View.GONE
        dbRef = FirebaseDatabase.getInstance().getReference("Aluno")
        dbRef.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                alunoList.clear()
                if (snapshot.exists()){
                    for (alunoSnap in snapshot.children){
                        val alunoData = alunoSnap.getValue(CadastroAluno:: class.java)
                        alunoList.add (alunoData!!)
                    }
                    val mAdapite = AlunosAdapte(alunoList)
                    alunoRecyclerView.adapter = mAdapite
                    alunoRecyclerView.visibility = View.VISIBLE

                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}