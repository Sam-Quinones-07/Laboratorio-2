/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author samue
 */
public class MedicamentosDAO {

    private List<Medicamentos> listaMedicamentos = new ArrayList<>();

    public void agregarElemento(Medicamentos medicamento) {
        listaMedicamentos.add(medicamento);
    }

    public List<Medicamentos> obtenerTodos() {
        return listaMedicamentos;
    }

    public void actualizarElemento(int indice, Medicamentos medicamentoActualizado) {
        if (indice >= 0 && indice < listaMedicamentos.size()) {
            listaMedicamentos.set(indice, medicamentoActualizado);
        }
    }
}
