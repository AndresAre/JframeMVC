/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Estudiante;
import vista.FrmMatriculas;

/**
 *
 * @author user
 */
public class Controlador implements ActionListener{

    Estudiante estu;
    FrmMatriculas frm;

    public Controlador(Estudiante estu, FrmMatriculas frm) {
        this.estu = estu;
        this.frm = frm;
        //Se ponen de dicha forma para dejarlos en modo escucha
        this.frm.jBtConsultarDatos.addActionListener(this);
        this.frm.jBtGenerarPago.addActionListener(this);
        this.frm.jBtSalir.addActionListener(this);
    }
    
    public void iniciar(){
        this.frm.setTitle("Sistema de Matriculas V. 2.0");
        this.frm.setLocationRelativeTo(null);
        
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
       // Se quito para manejar el modelo MVC, quitando los metodos de la interfaz y poniendolos aqui mismo
       // se quita todo el codigo del boton y se pega aqui dentro de cada comparacion hecha, muchos de los botones no los reconocera, por lo que toca incluirles el example "frm.jTxNombreEstudiante"
       // throw new UnsupportedOperationException("Not supported yet."); To change body of generated methods, choose Tools | Templates.
       if(ae.getSource() == frm.jBtConsultarDatos){
        boolean validar = false;
        String ident="", nombre="";
        int vlrCredt=0;
        String carrera = frm.jCbCarrera.getSelectedItem().toString();
        if(frm.jTxidentificacion.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Debe ingresar idenficacion");
            validar = true;
        }else{
            ident = frm.jTxidentificacion.getText();
        }
        if(frm.jTxNombreEstudiante.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Debe ingresar nombre del estudiante");
            validar = true;
        }else{
            nombre = frm.jTxNombreEstudiante.getText();
        }
        int estrato =(int) frm.jSpEstrato.getValue();
        int cantCredt=(int) frm.jSpCreditos.getValue();
        if(frm.jTxVlrCredito.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Seleccione carrera pra cargar valor creditos");
        }else{
            
        vlrCredt= Integer.parseInt(frm.jTxVlrCredito.getText());
        }
        if(estrato==0){
            JOptionPane.showMessageDialog(null, "Debe ingresar un estrato");
            validar = true;
        }
        if(!validar){
            Estudiante est = new Estudiante(ident, nombre, carrera, cantCredt, vlrCredt,estrato);
            frm.jTxADatosEstudiante.setText(est.listaDatosMatricula()   ); 
        }else{
            JOptionPane.showMessageDialog(null, "Debe ingresar TODOS LOS DATOS  ");
        }
       }
       if(ae.getSource() == frm.jBtGenerarPago){
           
        boolean validar = false;
        String ident="", nombre="";
        int vlrCredt=0;
        String carrera = frm.jCbCarrera.getSelectedItem().toString();
        if(frm.jTxidentificacion.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Debe ingresar idenficacion");
            validar = true;
        }else{
            ident = frm.jTxidentificacion.getText();
        }
        if(frm.jTxNombreEstudiante.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Debe ingresar nombre del estudiante");
            validar = true;
        }else{
            nombre = frm.jTxNombreEstudiante.getText();
        }
        int estrato =(int) frm.jSpEstrato.getValue();
        int cantCredt=(int) frm.jSpCreditos.getValue();
        if(frm.jTxVlrCredito.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Seleccione carrera pra cargar valor creditos");
        }else{
            
        vlrCredt= Integer.parseInt(frm.jTxVlrCredito.getText());
        }
        if(estrato==0){
            JOptionPane.showMessageDialog(null, "Debe ingresar un estrato");
            validar = true;
        }
        if(!validar){
            Estudiante est = new Estudiante(ident, nombre, carrera, cantCredt, vlrCredt,estrato);
            frm.jTxTotalPagar.setText(String.valueOf(est.calcularMatriculaPagar()));
        }else{
            JOptionPane.showMessageDialog(null, "Debe ingresar TODOS LOS DATOS  ");
        }
       }
       if(ae.getSource() == frm.jBtSalir){
            int respuesta = JOptionPane.showConfirmDialog(frm, "¿Esta seguro que desea salir?");
            if(respuesta == JOptionPane.YES_OPTION){
                System.exit(0);
        }
       }
    
    }
    
}
