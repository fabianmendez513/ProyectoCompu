package component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TablaVehiculos extends JTable {
    private DefaultTableModel modelo; // modelo de la tabla

    public TablaVehiculos() {
        modelo = new DefaultTableModel(new Object[]{"Placa", "Hora Entrada"}, 0); // columnas
        this.setModel(modelo); // asignar modelo a la tabla
    }

    public void agregarVehiculo(String placa, String horaEntrada) {
        modelo.addRow(new Object[]{placa, horaEntrada}); // agrega fila
    }

    public void removerVehiculo(String placa) {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            if (modelo.getValueAt(i, 0).equals(placa)) { // buscar placa
                modelo.removeRow(i); // eliminar fila
                break;
            }
        }
    }
}
