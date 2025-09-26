package view;

import component.TablaVehiculos;
import control.ParqueoController;
import java.awt.*;
import javax.swing.*;

public class VentanaPrincipal extends JFrame {
    private TablaVehiculos tablaVehiculos;
    private PanelEstacionamiento panelEstacionamiento; // añadem el panel de estacionamiento

    public VentanaPrincipal() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("No se pudo aplicar Nimbus, se usará el estilo por defecto.");
        }

        setTitle("Sistema de Estacionamiento");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        ParqueoController controller = new ParqueoController(); // usa ParqueoController
        tablaVehiculos = new TablaVehiculos(); // usa TablaVehiculos

        // Panel tabla
        JScrollPane scrollTabla = new JScrollPane(tablaVehiculos);
        scrollTabla.setBorder(BorderFactory.createTitledBorder("Vehículos en el estacionamiento"));

        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.add(scrollTabla, BorderLayout.CENTER);

        // Panel estacionamiento
        panelEstacionamiento = new PanelEstacionamiento();

        // Panel registro
        PanelRegistro panelRegistro = new PanelRegistro(controller, this);
        panelRegistro.setBorder(BorderFactory.createTitledBorder("Registro de Entradas y Salidas"));

        setLayout(new BorderLayout());
        add(panelSuperior, BorderLayout.NORTH);
        add(panelEstacionamiento, BorderLayout.CENTER); // se agrega aquí
        add(panelRegistro, BorderLayout.SOUTH);
    }

    public TablaVehiculos getTablaVehiculos() {
        return tablaVehiculos;
    }

    // 👉 Getter para usar desde PanelRegistro
    public PanelEstacionamiento getPanelEstacionamiento() {
        return panelEstacionamiento;
    }
}
