package es.ieslavereda.android_rvgot_base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import es.ieslavereda.android_rvgot_base.model.Personaje;
import es.ieslavereda.android_rvgot_base.model.PersonajeRepository;

public class CustomRecyclerView extends RecyclerView.Adapter<CustomRecyclerView.ViewHolder> {

    private List<Personaje> personajes;
    private LayoutInflater inflater;

    public CustomRecyclerView(Context context) {
        inflater = co
        this.personajes = PersonajeRepository.getInstance().getAll();
    }

    @NonNull
    @Override
    public CustomRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomRecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return personajes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private int imagen;
        private String nombre;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imagen = itemView.findViewById(R.id.imageView);
            nombre = itemView.findViewById(R.id.descripcion);
        }
    }
}
