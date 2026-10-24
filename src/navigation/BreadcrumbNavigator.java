package navigation;

import java.util.ArrayList;
import java.util.List;

public class BreadcrumbNavigator {
    private List<String> ruta;
    private int pestañaActiva;

    public BreadcrumbNavigator() {
        this.ruta = new ArrayList<>();
        this.pestañaActiva = 0;
        // Ruta inicial
        ruta.add("Inicio");
        ruta.add("Catálogo");
        ruta.add("Servidor Principal");
    }

    public void cambiarPestaña(String nuevaSeccion) {
        // Actualiza la ruta dinámicamente al cambiar de pestaña
        if (ruta.size() >= 3) {
            ruta.set(2, nuevaSeccion);
        } else {
            while (ruta.size() < 3) {
                ruta.add("");
            }
            ruta.set(2, nuevaSeccion);
        }
    }

    public void agregarNivel(String subcategoria) {
        ruta.add(subcategoria);
    }

    public void navegarA(String seccion, String subseccion) {
        ruta.clear();
        ruta.add("Inicio");
        ruta.add(seccion);
        ruta.add(subseccion);
    }

    public String obtenerRutaActual() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ruta.size(); i++) {
            sb.append(ruta.get(i));
            if (i < ruta.size() - 1) {
                sb.append(" > ");
            }
        }
        return sb.toString();
    }

    public void mostrarRuta() {
        System.out.println("Ruta actual: " + obtenerRutaActual());
    }

    public List<String> getRuta() {
        return ruta;
    }
}
