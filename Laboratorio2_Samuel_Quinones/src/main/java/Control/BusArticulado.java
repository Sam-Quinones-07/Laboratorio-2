/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

/**
 *
 * @author samue
 */
public class BusArticulado implements SistemaTarifario {
    
    private final double TARIFA_FIJA = 2950;

    @Override
    public double calcularTarifa(double distancia) {
        return TARIFA_FIJA;
    }

    @Override
    public void mostrarRuta() {
        System.out.println("Ruta troncal (estàndar de $2950 COP)");
    } 
}
