package es.ieslavereda.android_rvgot_base.model;

import java.util.Comparator;

public class Personaje {

    public static final Comparator<Personaje> SORT_BY_NAME = Comparator.comparing(Personaje::getNombre);
    public static final Comparator<Personaje> SORT_BY_CASA = (personaje1, personaje2) ->
     personaje1.getCasa().getNombre().compareToIgnoreCase(personaje2.getCasa().getNombre());

    private String nombre;
    private Casa casa;

    public Personaje(String nombre, Casa casa) {
        this.nombre = nombre;
        this.casa = casa;
    }

    public String getNombre() {
        return nombre;
    }

    public Casa getCasa() {
        return casa;
    }

}
