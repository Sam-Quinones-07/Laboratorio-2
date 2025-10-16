/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Control;

/**
 * Interfaz que define el sistema tarifario común para todos los tipos de transporte.
 * Cualquier clase que implemente esta interfaz debe calcular la tarifa y mostrar la ruta.
 * @author samue
 */
public interface SistemaTarifario {
    public double calcularTarifa(double distancia);
    
    
    public void mostrarRuta();
}
