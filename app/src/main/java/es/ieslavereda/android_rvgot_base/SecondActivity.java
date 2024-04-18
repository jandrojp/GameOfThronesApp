package es.ieslavereda.android_rvgot_base;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private ImageView imagen;
    private TextView casa;
    private TextView nombrePersonaje;
    private ImageButton buttonReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        imagen = findViewById(R.id.escudo);
        casa = findViewById(R.id.descripcionEscudo);
        nombrePersonaje = findViewById(R.id.nombre);
        buttonReturn = findViewById(R.id.buttonReturn);

        Bundle extras = getIntent().getExtras();

        imagen.setImageResource(extras.getInt("escudo"));
        casa.setText(extras.getString("casa"));
        nombrePersonaje.setText(extras.getString("nombrePersonaje"));

        buttonReturn.setOnClickListener(v -> {
            Intent i = new Intent();
            finish();
        });

    }
}
