package view;

import control.ParqueoController;
import java.awt.*;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import module.Vehiculo;

public class PanelRegistro extends JPanel {
    private JTextField txtPlaca;
    private JButton btnEntrada, btnSalida;
    private ParqueoController controller;
    private VentanaPrincipal ventana;

    public PanelRegistro(ParqueoController controller, VentanaPrincipal ventana) {
        this.controller = controller;
        this.ventana = ventana;

        setLayout(new FlowLayout());

        txtPlaca = new JTextField(10);
        btnEntrada = new JButton("Registrar Entrada");
        btnSalida = new JButton("Registrar Salida");

        add(new JLabel("Placa:"));
        add(txtPlaca);
        add(btnEntrada);
        add(btnSalida);

        // entrada
        btnEntrada.addActionListener(e -> {
            String placa = txtPlaca.getText().trim();
            if (!placa.isEmpty()) {
            // entrada PanelEstacionamiento
                boolean registrada = ventana.getPanelEstacionamiento().registrarEntrada(placa);
                if (!registrada) {
                    JOptionPane.showMessageDialog(this, "No hay espacios libres o placa ya registrada");
                    return;
                }

                // Registra controlador
                controller.registrarEntrada(placa);

                // Obtener vehículo y mostrar en tabla
                Vehiculo v = controller.getParqueo().getVehiculos()
                        .stream()
                        .filter(veh -> veh.getPlaca().equalsIgnoreCase(placa))
                        .findFirst()
                        .orElse(null);

                if (v != null) {
                    ventana.getTablaVehiculos().agregarVehiculo(
                            v.getPlaca(),
                            v.getHoraEntrada().format(DateTimeFormatter.ofPattern("HH:mm:ss"))
                    );
                }

                txtPlaca.setText("");
            }
        });

        // salida
        btnSalida.addActionListener(e -> {
            String placa = txtPlaca.getText().trim();
            if (!placa.isEmpty()) {
                // salida en el panel
                boolean salida = ventana.getPanelEstacionamiento().registrarSalida(placa);
                if (!salida) {
                    JOptionPane.showMessageDialog(this, "Placa no encontrada");
                    return;
                }

                // salida en el controlador
                controller.registrarSalida(placa);
                ventana.getTablaVehiculos().removerVehiculo(placa);

                txtPlaca.setText("");
            }
        });
    }
}
