package model;

import Main.Taller;

public class Cita {
    private int id;
    private int id_vehiculo;
    private int id_servicio;
    private String fecha;
    private String hora;
    private boolean compleated;

    //Getters
    public int getId() { return this.id; }
    public int getId_vehiculo() { return this.id_vehiculo; }
    public int getId_servicio() { return this.id_servicio; }
    public String getFecha() { return this.fecha; }
    public String getHora() { return this.hora; }
    public boolean isCompleated() { return this.compleated; }
    //Setters
    public void setId(int id) { this.id = id; }
    public void setId_vehiculo(int id_vehiculo) { this.id_vehiculo = id_vehiculo; }
    public void setId_servicio(int id_servicio) { this.id_servicio = id_servicio; }
    public void setFecha(String fecha) { this.fecha = fecha; }
    public void setHora(String hora) { this.hora = hora; }
    public void setCompleated(boolean compleated) { this.compleated = compleated; }
    //Constructor
    public Cita(int id_vehiculo, int id_servicio, String fecha, String hora) {
        this.id_vehiculo = id_vehiculo;
        this.id_servicio = id_servicio;
        this.fecha = fecha;
        this.hora = hora;
        this.compleated = false;
    }

    public void describe(){
        System.out.println("ID: " + this.id);
        System.out.println("ID vehiculo: " + this.id_vehiculo+"     Placa vehiculo: "+(Taller.idToVehiculo(this.id_vehiculo)).getLicense_plate());
        System.out.println("ID Dueño: " + (Taller.idToVehiculo(this.id_vehiculo)).getId_owner()+"     Nombre Dueño: "+(Taller.idToCliente(Taller.idToVehiculo(this.id_vehiculo).getId_owner()).getName()));
        System.out.println("ID servicio: " + this.id_servicio+"     Nombre servicio: "+(Taller.idToServicio(this.id_servicio)).getName());
        System.out.println("Fecha: " + this.fecha+"     Hora: " + this.hora);
        System.out.println("Completado: " + this.compleated);
    }
    
}