/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Medicamentos;
import modelo.MedicamentosDAO;
import vistas.Vista;
import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 *
 * @author samue
 */

public class Controlador {

    private final MedicamentosDAO modelo;
    private final Vista vista;
    
    public Controlador() {
        
        modelo = new MedicamentosDAO();
        vista = new Vista(this);
        
        JFrame frame = new JFrame("Aplicación de Gestión de Medicamentos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.add(vista);
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Controlador());
    }
    
    public void manejarAgregar() {
        JDialog dialog = new JDialog();
        dialog.setTitle("Agregar Medicamento");
        dialog.setSize(400, 300);  // Tamaño más grande para mejor diseño
        dialog.setModal(true);  // Hace el diálogo modal
        dialog.setLayout(new GridBagLayout());  // Layout más flexible
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);  // Padding entre componentes
        gbc.anchor = GridBagConstraints.WEST;
        JLabel lblNombre = new JLabel("Nombre:");
        JTextField txtNombre = new JTextField(20);
        JLabel lblMarca = new JLabel("Marca:");
        JTextField txtMarca = new JTextField(20);
        JLabel lblPrecio = new JLabel("Precio:");
        JTextField txtPrecio = new JTextField(20);
        JButton btnFinalizar = new JButton("Finalizar");
        
        // Posicionamiento con GridBagConstraints
        gbc.gridx = 0; gbc.gridy = 0;
        dialog.add(lblNombre, gbc);
        gbc.gridx = 1; gbc.gridy = 0;
        dialog.add(txtNombre, gbc);
        gbc.gridx = 0; gbc.gridy = 1;
        dialog.add(lblMarca, gbc);
        gbc.gridx = 1; gbc.gridy = 1;
        dialog.add(txtMarca, gbc);
        gbc.gridx = 0; gbc.gridy = 2;
        dialog.add(lblPrecio, gbc);
        gbc.gridx = 1; gbc.gridy = 2;
        dialog.add(txtPrecio, gbc);
        gbc.gridx = 1; gbc.gridy = 3;  // Botón centrado
        gbc.anchor = GridBagConstraints.CENTER;
        dialog.add(btnFinalizar, gbc);
        
        btnFinalizar.addActionListener(e -> {
            if (txtNombre.getText().isEmpty() || txtMarca.getText().isEmpty() || txtPrecio.getText().isEmpty()) {
                vista.mostrarMensaje("Error: Todos los campos son obligatorios.");
                return;
            }
            try {
                String nombre = txtNombre.getText();
                String marca = txtMarca.getText();
                double precio = Double.parseDouble(txtPrecio.getText());
                Medicamentos nuevoMedicamento = new Medicamentos(nombre, marca, precio);
                modelo.agregarElemento(nuevoMedicamento);
                vista.mostrarMensaje("Medicamento agregado exitosamente.");
                dialog.dispose();  // Cierra el diálogo
            } catch (NumberFormatException ex) {
                vista.mostrarMensaje("Error: Precio inválido.");
            }
        });
        
        dialog.setVisible(true);
    }
    
    public void manejarVerTodos() {
        List<Medicamentos> lista = modelo.obtenerTodos();
        vista.mostrarListaCompleta(lista);
    }
    
    public void manejarActualizar() {
        String indiceStr = JOptionPane.showInputDialog("Ingrese el índice del medicamento a actualizar:");
        try {
            int indice = Integer.parseInt(indiceStr);
            List<Medicamentos> lista = modelo.obtenerTodos();
            if (indice < 0 || indice >= lista.size()) {
                vista.mostrarMensaje("Índice inválido.");
                return;
            }
            Medicamentos original = lista.get(indice);
            JDialog dialog = new JDialog();  // Similar a manejarAgregar
            dialog.setTitle("Actualizar Medicamento");
            dialog.setSize(400, 300);
            dialog.setModal(true);
            dialog.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(5, 5, 5, 5);
            gbc.anchor = GridBagConstraints.WEST;
            
            JLabel lblNombre = new JLabel("Nombre:");
            JTextField txtNombre = new JTextField(original.getNombre(), 20);
            JLabel lblMarca = new JLabel("Marca:");
            JTextField txtMarca = new JTextField(original.getMarca(), 20);
            JLabel lblPrecio = new JLabel("Precio:");
            JTextField txtPrecio = new JTextField(String.valueOf(original.getPrecio()), 20);
            JButton btnActualizar = new JButton("Actualizar");
            // Posicionamiento similar
            gbc.gridx = 0; gbc.gridy = 0; dialog.add(lblNombre, gbc); gbc.gridx = 1; dialog.add(txtNombre, gbc);
            gbc.gridx = 0; gbc.gridy = 1; dialog.add(lblMarca, gbc); gbc.gridx = 1; dialog.add(txtMarca, gbc);
            gbc.gridx = 0; gbc.gridy = 2; dialog.add(lblPrecio, gbc); gbc.gridx = 1; dialog.add(txtPrecio, gbc);
            gbc.gridx = 1; gbc.gridy = 3; gbc.anchor = GridBagConstraints.CENTER; dialog.add(btnActualizar, gbc);
            btnActualizar.addActionListener(e -> {
                try {
                    String nombre = txtNombre.getText();
                    String marca = txtMarca.getText();
                    double precio = Double.parseDouble(txtPrecio.getText());
                    Medicamentos actualizado = new Medicamentos(nombre, marca, precio);
                    modelo.actualizarElemento(indice, actualizado);
                    vista.mostrarMensaje("Medicamento actualizado exitosamente.");
                    dialog.dispose();
                } catch (NumberFormatException ex) {
                    vista.mostrarMensaje("Error: Precio inválido.");
                }
            });
            dialog.setVisible(true);
        } catch (NumberFormatException ex) {
            vista.mostrarMensaje("Índice inválido.");
        }
    }
}
