package es.ieslavereda.android_rvgot_base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import es.ieslavereda.android_rvgot_base.model.Personaje;
import es.ieslavereda.android_rvgot_base.model.PersonajeRepository;

public class CustomRecyclerView extends RecyclerView.Adapter<CustomRecyclerView.ViewHolder> {

    private List<Personaje> personajes;
    private LayoutInflater inflater;

    public CustomRecyclerView(Context context) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.personajes = PersonajeRepository.getInstance().getAll();
    }

    @NonNull
    @Override
    public CustomRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.simple_element, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomRecyclerView.ViewHolder holder, int position) {
        Personaje personaje = personajes.get(position);

        holder.casa.setText(personaje.getCasa().getNombre().toUpperCase());
        holder.nombrePersonaje.setText(personaje.getNombre());

    }

    @Override
    public int getItemCount() {
        return personajes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imagen;
        private TextView casa;
        private TextView nombrePersonaje;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imagen = itemView.findViewById(R.id.imageView);
            casa = itemView.findViewById(R.id.casa);
            nombrePersonaje = itemView.findViewById(R.id.nombrePersonaje);
        }
    }
}
