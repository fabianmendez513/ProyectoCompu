package control;

import database.BaseDatos;
import module.Parqueo;
import module.Vehiculo;

public class ParqueoController {
    private Parqueo parqueo; // lista de vehículos

    public ParqueoController() {
        parqueo = new Parqueo(); // inicializar parqueo
    }

    public void registrarEntrada(String placa) {
        Vehiculo v = new Vehiculo(placa); // crear vehículo
        parqueo.registrarEntrada(placa); // registrar en parqueo
        BaseDatos.guardarRegistro("Entrada: " + placa); // guardar historial
        System.out.println("Entrada registrada: " + placa);
    }

    public void registrarSalida(String placa) {
        parqueo.registrarSalida(placa); // eliminar del parqueo
        BaseDatos.guardarRegistro("Salida: " + placa); // guardar historial
        System.out.println("Salida registrada: " + placa);
    }

    public Parqueo getParqueo() {
        return parqueo; // obtener parqueo
    }
}
