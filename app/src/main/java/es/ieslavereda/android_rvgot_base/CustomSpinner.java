package es.ieslavereda.android_rvgot_base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;


public class CustomSpinner<T extends Listable> extends ArrayAdapter<T> {

    private int resource;

    public CustomSpinner(@NonNull Context context, int resource, @NonNull T[] objects) {
        super(context, resource, new ArrayList<>(List.of(objects)));
        this.resource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View customView = convertView;
        if(customView==null)
            customView = LayoutInflater.from(getContext()).inflate(resource, parent,false);

        T item = getItem(position);
        TextView escudo = customView.findViewById(R.id.textViewEscudo);
        ImageView logo = customView.findViewById(R.id.imageViewEscudo);

        escudo.setText(item.getDescription());
        logo.setImageResource(item.getDrawableSymbol());

        return customView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View customView = convertView;
        if(customView==null)
            customView = LayoutInflater.from(getContext()).inflate(resource, parent,false);

        T item = getItem(position);
        TextView escudo = customView.findViewById(R.id.textViewEscudo);
        ImageView logo = customView.findViewById(R.id.imageViewEscudo);

        escudo.setText(item.getDescription());
        logo.setImageResource(item.getDrawableSymbol());

        return customView;
    }

}
