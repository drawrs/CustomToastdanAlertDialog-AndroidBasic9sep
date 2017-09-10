package com.khilman.basicharikedua;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    // deklarasi
    Button btnLogin;
    EditText edtEmail, edtPwd;
    TextView linkDaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // inisialisasi
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtPwd = (EditText) findViewById(R.id.edtPwd);

        btnLogin = (Button) findViewById(R.id.btnLogin);

        linkDaftar = (TextView) findViewById(R.id.linkDaftar);

        /// kasih event ketika tombol login di tekan/klik
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // aksi yang di lakukan
                // ambil nilai dari edit text
                String nilaiemail = edtEmail.getText().toString(); // tampung dalam variable
                String nilaipassword = edtPwd.getText().toString(); // tampung dalam variable
                // buat kondisional
                if (nilaiemail.isEmpty() || nilaipassword.isEmpty()){
                    // aksi jika kondisional terpenuhi

                    // buat inflater
                    LayoutInflater inflater = getLayoutInflater();
                    view = inflater.inflate(R.layout.tampilan_toast, null); // jadikan/ tampung dalam view

                    //  inisialisasi text view dari layout tampilan toast
                    TextView isi_pesan = (TextView) view.findViewById(R.id.isiPesan);
                    // set teks untuk textview isiPesan
                    isi_pesan.setText("Email dan password tidak boleh kosong!");

                    // buat object toast
                    Toast toast = new Toast(MainActivity.this);
                    toast.setView(view); // mengganti tampialn toast dengan layout yang kita buat
                    toast.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL,0,0); // mengatur posisi toast muncul
                    toast.setDuration(Toast.LENGTH_SHORT); // mengatur durasi toast muncul
                    toast.show(); // menampilkan toast
                }



            }
        });

        // event linkDaftar
        linkDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Buat inflater
                LayoutInflater inflater = getLayoutInflater();
                view = inflater.inflate(R.layout.tampilan_alert, null);

                // buat alert dialog
                // getAplicationContext -> untuk mendapatkan konteks, sama dngan memanggil nama activity (MainActivity.this)
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("Persetujuan"); // set judul
                alert.setView(view); // set tampilan

                alert.setPositiveButton("Setuju", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // pindah activity / halaman
                        // Cara pertama
                        Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                        startActivity(intent); // memulai activiy baru

                        // CARA kedua
                        //startActivity(new Intent(MainActivity.this, RegisterActivity.class));
                    }
                });

                alert.setNegativeButton("Tidak Setuju", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                alert.show(); // tampilkan

            }
        });

    }
}
