package view;

import java.awt.*;
import java.util.HashMap;
import javax.swing.*;

public class PanelEstacionamiento extends JPanel {
    private JButton[] espacios; // espacios de estacionamiento
    private HashMap<String, Integer> registroVehiculos; // placa -> índice del espacio

    public PanelEstacionamiento() {
        setLayout(new GridBagLayout());

        espacios = new JButton[8];
        registroVehiculos = new HashMap<>();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        for (int i = 0; i < 8; i++) {
            espacios[i] = new JButton("Espacio " + (i + 1));
            espacios[i].setBackground(Color.GREEN);
            espacios[i].setOpaque(true);
            espacios[i].setBorderPainted(false);
            espacios[i].setPreferredSize(new Dimension(200, 60));

            gbc.gridx = i % 4;
            gbc.gridy = i / 4;
            add(espacios[i], gbc);
        }

        setBorder(BorderFactory.createTitledBorder("Estado de los Espacios"));
    }

    // Registrar entrada: ocupa primer espacio libre y registra la placa
    public boolean registrarEntrada(String placa) {
        if (registroVehiculos.containsKey(placa)) {
            return false; // placa ya registrada
        }

        for (int i = 0; i < espacios.length; i++) {
            if (estaLibre(i)) {
                ocuparEspacio(i);
                registroVehiculos.put(placa, i);
                return true;
            }
        }

        return false; // no hay espacios libres
    }

    // Registrar salida: libera el espacio correspondiente
    public boolean registrarSalida(String placa) {
        Integer index = registroVehiculos.get(placa);
        if (index == null) {
            return false; // placa no encontrada
        }

        liberarEspacio(index);
        registroVehiculos.remove(placa);
        return true;
    }

    private void ocuparEspacio(int index) {
        espacios[index].setBackground(Color.RED);
    }

    private void liberarEspacio(int index) {
        espacios[index].setBackground(Color.GREEN);
    }

    private boolean estaLibre(int index) {
        return espacios[index].getBackground().equals(Color.GREEN);
    }
}
