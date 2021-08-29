/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author user
 */
public class Estudiante {
    private String ident;
    private String nombre;
    private String carrera;
    private int cantCreditos;
    private float vlrCredito;
    private int estrato;

    public Estudiante() {
    }

    public Estudiante(String ident, String nombre, String carrera, int cantCreditos, float vlrCredito, int estrato) {
        this.ident = ident;
        this.nombre = nombre;
        this.carrera = carrera;
        this.cantCreditos = cantCreditos;
        this.vlrCredito = vlrCredito;
        this.estrato = estrato;
    }

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getCantCreditos() {
        return cantCreditos;
    }

    public void setCantCreditos(int cantCreditos) {
        this.cantCreditos = cantCreditos;
    }

    public float getVlrCredito() {
        return vlrCredito;
    }

    public void setVlrCredito(float vlrCredito) {
        this.vlrCredito = vlrCredito;
    }

    public int getEstrato() {
        return estrato;
    }

    public void setEstrato(int estrato) {
        this.estrato = estrato;
    }
    
    public int verificarEstrato(){
        if(estrato==1 | estrato==2){
            return 50;
        }else if(estrato==3){
            return 20;
        }else{
            return 0;
        }
    }
    
    public float calcularMatriculaPagar(){
        float vlrCredito, vlrMatricula, totalCreditos;
        switch(carrera){
            case "Sistemas":vlrCredito=345000;
                            break;
            case "Contabilidad":vlrCredito=287900;
                            break;
            case "Administracion":vlrCredito=178900;
                            break;
            case "Medicina":vlrCredito=450000;
                            break;
            default: vlrCredito=0;
        }
        totalCreditos = (vlrCredito*cantCreditos);
        vlrMatricula = totalCreditos - (vlrCredito*(verificarEstrato()/100));
        return vlrMatricula;
    }
    
    public String listaDatosMatricula(){
        return "Identificación: "+ident+
                "\nNombre: "+nombre+
                "\nCarrera: "+carrera+
                "\nValor Pagar Matricula: "+calcularMatriculaPagar();
    }
    
}
