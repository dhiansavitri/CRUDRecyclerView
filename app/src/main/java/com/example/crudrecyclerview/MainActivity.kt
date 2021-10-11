package com.example.crudrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var inputNIS : EditText
    private lateinit var inputNama:EditText
    private lateinit var jkLakiLaki:RadioButton
    private lateinit var jkPerempuan:RadioButton
    private lateinit var recyclerView: RecyclerView
    private lateinit var btnTambah: Button
    private lateinit var recyclerAdapter: RecyclerView.Adapter<*>
    private lateinit var ViewManager:RecyclerView.LayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inputNIS=findViewById(R.id.txtInputNIS)
        inputNama=findViewById(R.id.txtInputNama)
        jkLakiLaki=findViewById(R.id.rbLakiLaki)
        jkPerempuan=findViewById(R.id.rbPerempuan)
        btnTambah=findViewById(R.id.btnTambah)
        recyclerView=findViewById(R.id.listData)
        //membuat variabel kosong tipe array MutableList untuk simpan data array
        //data array disimpan di data class SiswaData
        val data = mutableListOf<SiswaData>()
        ViewManager=LinearLayoutManager(this)
        recyclerAdapter=SiswaAdapter(data)
        recyclerView.adapter=recyclerAdapter
        recyclerView.layoutManager=ViewManager
        //setOnClickListener untuk tombol tambah data
        btnTambah.setOnClickListener{
            //1.Membuat variabel penyimpan data
            val nis =inputNIS.text.toString()
            val nama=inputNama.text.toString()
            var jk=""
            if (jkLakiLaki.isChecked){
                jk="Laki-Laki"
            }else{
                jk="Perempuan"
            }
            //Simpan data ke array MutableList
            val dataSiswa = SiswaData(nis,nama,jk)
            data.add(dataSiswa)
            recyclerAdapter.notifyDataSetChanged()
        }
    }
}