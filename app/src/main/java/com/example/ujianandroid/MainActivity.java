package com.example.ujianandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edNamaDepan = (EditText) findViewById(R.id.edNamaDepan);
        EditText edNamaBelakang = (EditText) findViewById(R.id.edNamaBelakang);
        EditText edUmur = (EditText) findViewById(R.id.edUmur);
        Button btnSimpan = (Button) findViewById(R.id.btnSimpan);

        ArrayList<String> daftar_nama = new ArrayList<>();

        Intent intent_list = new Intent(MainActivity.this, ListActivity.class);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String isian_nama_depan = edNamaDepan.getText().toString();
                String isian_nama_belakang = edNamaBelakang.getText().toString();
                int isian_umur = Integer.parseInt(edUmur.getText().toString());


                if(isian_nama_depan.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Isian masih kosong", Toast.LENGTH_SHORT).show();
                }else{
                    ArrayList<String> daftar_nama = new ArrayList<>();
                    for(int i  = 0;i <= isian_umur;i++){
                        String nama_lengkap = i + ". " + isian_nama_depan + " " + isian_nama_belakang;
                        daftar_nama.add(nama_lengkap);
                    }
                    edNamaDepan.setText("");
                    edNamaBelakang.setText("");
                    edUmur.setText("");
                    intent_list.putStringArrayListExtra("daftar_nama", daftar_nama);
                    startActivity(intent_list);
                }
            }
        });
    }
}