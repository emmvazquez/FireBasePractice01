package com.practica.firebasepractice01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
EditText txtNombre;
EditText txtApellidos;
Spinner spinSexo;
Spinner spinCarrera;
Button btnGuardar;

private DatabaseReference dbAlumno;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    dbAlumno = FirebaseDatabase.getInstance().getReference("Estudiante");

    txtNombre = (EditText)findViewById(R.id.txtNombre);
    txtApellidos = (EditText)findViewById(R.id.txtApellidos);
    spinSexo = (Spinner)findViewById(R.id.spinSexo);
    spinCarrera = (Spinner)findViewById(R.id.spinCarrera);
    btnGuardar = (Button)findViewById(R.id.btnGuardar);


    String [] sexo = {"Hombre", "Mujer"};
    String [] carreras = {"ING. GESTIÓN EMPRESARIAL", "INGENIERÍA MECATRÓNICA", "INGENIERÍA INFORMÁTICA"};

    ArrayAdapter<String> arrayAdapterSexo = new ArrayAdapter<String >(this, android.R.layout.simple_spinner_item, sexo);
    ArrayAdapter<String> arrayAdapterCarreras = new ArrayAdapter<String >(this, android.R.layout.simple_spinner_item, carreras);

    spinSexo.setAdapter(arrayAdapterSexo);
    spinCarrera.setAdapter(arrayAdapterCarreras);

    btnGuardar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            registrarEstudiante();
        }
    });


    }

    public void registrarEstudiante(){

        String Nombre = txtNombre.getText().toString();
        String Apellidos = txtApellidos.getText().toString();
       String Sexo = spinSexo.getSelectedItem().toString();
       String Carrera = spinCarrera.getSelectedItem().toString();

       if(!TextUtils.isEmpty(Nombre)){
            String id =  dbAlumno.push().getKey();
            Estudiante estudiante = new Estudiante(id, Nombre, Apellidos, Sexo, Carrera);
            dbAlumno.child("Estudiante").child(id).setValue(estudiante);

           Toast.makeText(this, "Estudiante registrado", Toast.LENGTH_LONG).show();
       }
       else{
           Toast.makeText(this, "El nombre no puede ser vacío ", Toast.LENGTH_LONG).show();
       }

    }
}
