package es.ieslavereda.android_rvgot_base;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import es.ieslavereda.android_rvgot_base.model.Personaje;
import es.ieslavereda.android_rvgot_base.model.PersonajeRepository;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        CustomRecyclerView customRecyclerView = new CustomRecyclerView(this);
        recyclerView.setAdapter(customRecyclerView);
        customRecyclerView.setOnClickListener(this);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

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