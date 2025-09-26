package module;

import java.util.ArrayList;
import java.util.List;

public class Parqueo {
    private List<Vehiculo> vehiculos; // lista de vehículos

    public Parqueo() {
        this.vehiculos = new ArrayList<>(); // inicializar lista
    }

    public void registrarEntrada(String placa) {
        vehiculos.add(new Vehiculo(placa)); // agregar vehículo
    }

    public void registrarSalida(String placa) {
        Vehiculo v = buscarVehiculo(placa); // buscar vehículo
        if (v != null) {
            v.registrarSalida(); // registrar hora salida
            vehiculos.remove(v); // eliminar vehículo
        }
    }

    public Vehiculo buscarVehiculo(String placa) {
        for (Vehiculo v : vehiculos) {
            if (v.getPlaca().equalsIgnoreCase(placa)) return v; // encontrar vehículo
        }
        return null; // no encontrado
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos; // retornar lista
    }
}
