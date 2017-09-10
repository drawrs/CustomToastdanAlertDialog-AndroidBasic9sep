package com.khilman.basicharikedua;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    // Deklarasi
    EditText edtNama, edtEmail, edtPwd, edtPwdCheck;
    Button btnRegister;
    TextView link_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        // inisialisasi
        edtNama = (EditText) findViewById(R.id.edtNama);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtPwd = (EditText) findViewById(R.id.edtPwd);
        edtPwdCheck = (EditText) findViewById(R.id.edtPwdCheck);

        btnRegister = (Button) findViewById(R.id.btnRegister);

        link_login = (TextView) findViewById(R.id.linkLogin);

        // event btnReg di tekan/klik
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // aksi yang di lakukan
                // ambil nilai dari edit text
                String nilainama = edtNama.getText().toString(); // tampung dalam variable
                String nilaiemail = edtEmail.getText().toString(); // tampung dalam variable
                String nilaipassword = edtPwd.getText().toString(); // tampung dalam variable
                String nilaipassword_check = edtPwdCheck.getText().toString(); // tampung dalam variable

                // buat kondisional
                if (nilaiemail.isEmpty() || nilaipassword.isEmpty() || nilainama.isEmpty() || nilaipassword_check.isEmpty()){
                    // aksi jika kondisional terpenuhi

                    // buat inflater
                    LayoutInflater inflater = getLayoutInflater();
                    view = inflater.inflate(R.layout.tampilan_toast, null); // jadikan/ tampung dalam view

                    //  inisialisasi text view dari layout tampilan toast
                    TextView isi_pesan = (TextView) view.findViewById(R.id.isiPesan);
                    // set teks untuk textview isiPesan
                    isi_pesan.setText("Semua input harus di isi");

                    // buat object toast
                    Toast toast = new Toast(RegisterActivity.this);
                    toast.setView(view); // mengganti tampialn toast dengan layout yang kita buat
                    toast.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL,0,0); // mengatur posisi toast muncul
                    toast.setDuration(Toast.LENGTH_SHORT); // mengatur durasi toast muncul
                    toast.show(); // menampilkan toast

                }
                // cek apakah katasandi dan konfirmasi katasandi tidak sama
                // ! (tanda seru) = negasi -> membalikan hasil dari boolean
                if (!nilaipassword.equalsIgnoreCase(nilaipassword_check)){
                    // buat inflater
                    LayoutInflater inflater = getLayoutInflater();
                    view = inflater.inflate(R.layout.tampilan_toast, null); // jadikan/ tampung dalam view

                    //  inisialisasi text view dari layout tampilan toast
                    TextView isi_pesan = (TextView) view.findViewById(R.id.isiPesan);
                    // set teks untuk textview isiPesan
                    isi_pesan.setText("Konfirmasi password tidak sama");

                    // buat object toast
                    Toast toast = new Toast(RegisterActivity.this);
                    toast.setView(view); // mengganti tampialn toast dengan layout yang kita buat
                    toast.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL,0,0); // mengatur posisi toast muncul
                    toast.setDuration(Toast.LENGTH_SHORT); // mengatur durasi toast muncul
                    toast.show(); // menampilkan toast
                }
            }
        });


    }
}
