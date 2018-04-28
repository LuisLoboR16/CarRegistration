package com.example.luisanibal.carregister;

public class Carro {
    private int foto,marca,modelo,color,precio;
    private String placa;

    public Carro(int foto, String placa, int marca, int modelo, int color, int precio) {
        this.foto = foto;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.precio = precio;

    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }


    public int getMarca() {
        return marca;
    }

    public void setMarca(int marca) {
        this.marca = marca;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void guardar(){
        Datos.agregar(this);
    }

}
