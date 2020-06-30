package com.example.pruebauno_bolanos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity {

    private EditText altura, peso, edad;
    private RadioButton rbh, rbm;
    private RadioGroup radioGroup;
    Button btnCalcular;

    DatabaseReference mRootReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalcular = findViewById(R.id.btnCalcular);


        altura = (EditText) findViewById(R.id.et1);
        peso = (EditText) findViewById(R.id.et2);
        edad = (EditText) findViewById(R.id.et3);
        rbh = (RadioButton) findViewById(R.id.rbHombre);
        rbm = (RadioButton) findViewById(R.id.rbMujer);

        mRootReference = FirebaseDatabase.getInstance().getReference();

    }

    public void IMC(){
        int alt = Integer.parseInt(altura.getText().toString());
        double pes = Double.parseDouble(peso.getText().toString());
        int edd = Integer.parseInt(edad.getText().toString());
        int rbH = Integer.parseInt(rbh.toString());
        int rbM = Integer.parseInt(rbm.toString());
        double pgc = 0;

        double imc = pes / (alt * alt);
        if(rbH==0){
            pgc = (1.2*imc)+(0.23*edd)-10.8-5.4;
        }else if (rbM == 1){
            pgc = (1.2*imc)+(0.23*edd)-5.4;
        }

    }


}