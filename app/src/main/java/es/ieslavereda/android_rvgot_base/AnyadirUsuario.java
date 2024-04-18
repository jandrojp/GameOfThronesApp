package es.ieslavereda.android_rvgot_base;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import es.ieslavereda.android_rvgot_base.model.Casa;
import es.ieslavereda.android_rvgot_base.model.Personaje;
import es.ieslavereda.android_rvgot_base.model.PersonajeRepository;

public class AnyadirUsuario extends AppCompatActivity {
    private EditText nombre;
    private Spinner spinner;
    private Button buttonAdd;
    private Button buttonCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        nombre = findViewById(R.id.editTextName);
        spinner = findViewById(R.id.spinnerCasas);
        buttonAdd = findViewById(R.id.buttonAceptar);
        buttonCancel = findViewById(R.id.buttonCancelar);

        spinner.setAdapter(new CustomSpinner<>(this, R.layout.custom_spinner, Casa.values()));

    }
}
