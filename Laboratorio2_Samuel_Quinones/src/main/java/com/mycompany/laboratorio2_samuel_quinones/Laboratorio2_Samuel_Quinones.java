/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.laboratorio2_samuel_quinones;

import Control.BusArticulado;
import Control.Teleferico;
import Control.SistemaTarifario;

/**
 *
 * @author samue
 */
public class Laboratorio2_Samuel_Quinones {
    
    public static void procesarViaje(SistemaTarifario vehiculo, double km) {
        vehiculo.mostrarRuta();
        System.out.println("Tarifa a cobrar por el viaje es de: $" + vehiculo.calcularTarifa(km) + " COP");
    }
    

    public static void main(String[] args) {

        System.out.println("----> Sistema de Transporte <----\n");

        // Bus articulado
        BusArticulado busetica = new BusArticulado();
        procesarViaje(busetica,5);
        
        System.out.println("\n");
        
        // Teleférico
        Teleferico metrocable = new Teleferico();
        procesarViaje(metrocable, 2);
    }
}
