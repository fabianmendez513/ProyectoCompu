package module;

import java.time.LocalDateTime;

public class Vehiculo {
    private String placa; // placa del vehículo
    private LocalDateTime horaEntrada; // hora de entrada
    private LocalDateTime horaSalida; // hora de salida

    public Vehiculo(String placa) {
        this.placa = placa;
        this.horaEntrada = LocalDateTime.now(); // asignar hora actual
    }

    public String getPlaca() { return placa; }

    public LocalDateTime getHoraEntrada() { return horaEntrada; }

    public LocalDateTime getHoraSalida() { return horaSalida; }

    public void registrarSalida() {
        this.horaSalida = LocalDateTime.now(); // asignar hora de salida
    }
}
