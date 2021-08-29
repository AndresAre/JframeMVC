/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matriculaspoogui;

import controlador.Controlador;
import modelo.Estudiante;
import vista.FrmMatriculas;

/**
 *
 * @author user
 */
public class MatriculasPOOGUI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        FrmMatriculas fm= new FrmMatriculas();
        Estudiante estu = new Estudiante();
        
        Controlador control = new Controlador(estu, fm);
        control.iniciar();
        
        fm.setVisible(true);
    }
    
}
