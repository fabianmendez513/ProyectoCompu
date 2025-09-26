package database;

import java.util.ArrayList;
import java.util.List;

public class BaseDatos {
    private static List<String> historial = new ArrayList<>(); // historial de registros

    public static void guardarRegistro(String registro) {
        historial.add(registro); // agregar registro
    }

    public static List<String> obtenerHistorial() {
        return historial; // retornar lista de registros
    }
}
