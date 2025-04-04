package model;

import Main.Taller;

public class Transaccion {
    private int id;
    private Double cantidad;
    private String concepto;
    private String fecha;
    private int id_tipo;
    private int id_variable;

    //Getters
    public int getId() {
        return id;
    }
    public Double getCantidad() {
        return cantidad;
    }
    public String getConcepto() {
        return concepto;
    }
    public String getFecha() {
        return fecha;
    }
    public int getId_tipo() {
        return id_tipo;
    }
    public int getId_variable() {
        return id_variable;
    }
    //Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }
    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }
    public void setId_variable(int id_variable) {
        this.id_variable = id_variable;
    }
    //Constructores
    public Transaccion(Double cantidad, String concepto, String fecha, int id_tipo, int id_variable) {
        this.cantidad = cantidad;
        this.concepto = concepto;
        this.fecha = fecha;
        this.id_tipo = id_tipo;
        this.id_variable = id_variable;
    }
    public Transaccion(Double cantidad, String concepto, String fecha, int id_tipo) {
        this.cantidad = cantidad;
        this.concepto = concepto;
        this.fecha = fecha;
        this.id_tipo = id_tipo;
    }
    public Transaccion(int id, Double cantidad, String concepto, String fecha, int id_tipo) {
        this.id = id;
        this.cantidad = cantidad;
        this.concepto = concepto;
        this.fecha = fecha;
        this.id_tipo = id_tipo;
    }
    public Transaccion(int id, Double cantidad, String concepto, String fecha, int id_tipo, int id_variable) {
        this.id = id;
        this.cantidad = cantidad;
        this.concepto = concepto;
        this.fecha = fecha;
        this.id_tipo = id_tipo;
        this.id_variable = id_variable;
    }
    public Transaccion(Double cantidad, String concepto, int id_tipo, int id_variable) {
        this.cantidad = cantidad;
        this.concepto = concepto;
        this.id_tipo = id_tipo;
        this.id_variable = id_variable;
    }
    public Transaccion(Double cantidad, String concepto, int id_tipo) {
        this.cantidad = cantidad;
        this.concepto = concepto;
        this.id_tipo = id_tipo;
    }
    //Metodos
    public void details(){
        System.out.println("("+this.id+")    " + this.concepto);

        System.out.println("Cantidad: " + this.cantidad+"€");
        System.out.println("Fecha: " + this.fecha);

        System.out.println("(" + this.id_tipo+")    "+Taller.idToTipoTransaccion(this.id_tipo).getNombre());
        if(this.id_tipo == 3){
            System.out.println("Detalles de la operacion vinculada:");
            Cita citaVinculada = Taller.idToCita(this.id_variable);
            citaVinculada.describe();
        }
        else if(this.id_tipo == 4){
            System.out.println("Detalles de la operacion vinculada:");
            Pedido pedidoVinculado = Taller.idToPedido(this.id_variable);
            pedidoVinculado.details();

        }
    }
}