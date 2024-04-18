package es.ieslavereda.android_rvgot_base;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import es.ieslavereda.android_rvgot_base.model.Personaje;
import es.ieslavereda.android_rvgot_base.model.PersonajeRepository;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    private Switch switchSort;
    private Button buttonAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        switchSort = findViewById(R.id.switchSort);
        buttonAdd = findViewById(R.id.buttonAdd);

        CustomRecyclerView customRecyclerView = new CustomRecyclerView(this);
        recyclerView.setAdapter(customRecyclerView);
        customRecyclerView.setOnClickListener(this);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        switchSort.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                PersonajeRepository.getInstance().sort(Personaje.SORT_BY_NAME);
                switchSort.setText("Nombre");
            } else {
                PersonajeRepository.getInstance().sort(Personaje.SORT_BY_CASA);
                switchSort.setText("Casa");
            }

            customRecyclerView.notifyDataSetChanged();
        });



        buttonAdd.setOnClickListener( v -> {
            Intent intent = new Intent(this, AnyadirUsuario.class);
            startActivity(intent);
        });

     }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, SecondActivity.class);
        Personaje personaje = PersonajeRepository.getInstance().get(recyclerView.getChildAdapterPosition(v));

        intent.putExtra("escudo", personaje.getCasa().getEscudo());
        intent.putExtra("casa", personaje.getCasa().getNombre().toUpperCase());
        intent.putExtra("nombrePersonaje", personaje.getNombre().toUpperCase());
        startActivity(intent);
    }
}