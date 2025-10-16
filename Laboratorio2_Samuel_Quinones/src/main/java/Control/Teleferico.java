/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

/**
 *
 * @author samue
 */
public class Teleferico implements SistemaTarifario {
    
    private final int COSTO_BASE = 1000;
    private final int COSTO_KILOMETRO = 500;
    
    
    @Override
    public double calcularTarifa(double distancia) {
        return COSTO_BASE + (COSTO_KILOMETRO*distancia);
    }

    @Override
    public void mostrarRuta() {
        System.out.println("Ruta de conexión veredal (tarifa variable, base $1000 COP)");
    }
}
