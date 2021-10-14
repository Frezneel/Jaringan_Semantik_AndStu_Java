package com.example.jaringan_semantik;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Pesan Saya";
    Button bt_search, bt_bantuan;
    EditText et_search;
    String main, js1, js2, js3, js4, jh1, jh2, jh3, jh4, desk;
    ImageView hasilgambar;
    DatabaseReference JSKDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_search = findViewById(R.id.bt_search);
        et_search = findViewById(R.id.tvsearch);
        bt_bantuan = findViewById(R.id.bantuan);
        hasilgambar = findViewById(R.id.gambar);
        JSKDatabase = FirebaseDatabase.getInstance().getReference("jaringansemantik");


        bt_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hasilsearch = et_search.getText().toString().toLowerCase();
                readData(hasilsearch);

            }
        });

        bt_bantuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hasilsearch = "bantuan";
                Bundle data = new Bundle();
                data.putString(search_fragment.KEY_ACTIVITY, hasilsearch);
                search_fragment srch_fragment = new search_fragment();
                srch_fragment.setArguments(data);
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragmentlayout, srch_fragment)
                        .commit();
            }
        });

    }
        private void readData(String hasilsearch){
            JSKDatabase = FirebaseDatabase.getInstance().getReference("jaringansemantik");
            JSKDatabase.child(hasilsearch).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DataSnapshot> task) {
                    if(task.isSuccessful()){
                        if(task.getResult().exists()){
                            Toast.makeText(MainActivity.this ,"Data Terdaftar", Toast.LENGTH_SHORT).show();
                            DataSnapshot dataSnapshot = task.getResult();
                            String dt_main = String.valueOf(dataSnapshot.child("main").getValue());
                            String dt_js1 = String.valueOf(dataSnapshot.child("js_1").getValue());
                            String dt_js2 = String.valueOf(dataSnapshot.child("js_2").getValue());
                            String dt_js3 = String.valueOf(dataSnapshot.child("js_3").getValue());
                            String dt_js4 = String.valueOf(dataSnapshot.child("js_4").getValue());
                            String dt_jh1 = String.valueOf(dataSnapshot.child("js_h1").getValue());
                            String dt_jh2 = String.valueOf(dataSnapshot.child("js_h2").getValue());
                            String dt_jh3 = String.valueOf(dataSnapshot.child("js_h3").getValue());
                            String dt_jh4 = String.valueOf(dataSnapshot.child("js_h4").getValue());
                            String dt_desk = String.valueOf(dataSnapshot.child("desk").getValue());
                            main = dt_main;
                            js1 = dt_js1;
                            js2 = dt_js2;
                            js3 = dt_js3;
                            js4 = dt_js4;
                            jh1 = dt_jh1;
                            jh2 = dt_jh2;
                            jh3 = dt_jh3;
                            jh4 = dt_jh4;
                            desk = dt_desk;
                            StartFrg(hasilsearch);

                        }else {
                            Toast.makeText(MainActivity.this, "Kata Kunci Tidak Terdaftar", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(MainActivity.this, "Gagal Membaca", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }

        private void StartFrg(String hasilsearch){
        Bundle data = new Bundle();
        data.putString(search_fragment.KEY_ACTIVITY, hasilsearch);
        data.putString("main", main);
        data.putString("js1", js1);
        data.putString("js2", js2);
        data.putString("js3", js3);
        data.putString("js4", js4);
        data.putString("jh1", jh1);
        data.putString("jh2", jh2);
        data.putString("jh3", jh3);
        data.putString("jh4", jh4);
        data.putString("desk", desk);
        search_fragment srch_fragment = new search_fragment();
        srch_fragment.setArguments(data);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentlayout, srch_fragment)
                .commit();
        }

}