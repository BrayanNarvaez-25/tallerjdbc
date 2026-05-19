package com.krakedev.tallerjdbc.entidades;

public class Vehiculo {
	
	private String placa;
	private String marca;
	private String modelo;
	private int anio;
	private double precio;
	private String color;
	private boolean disponible;
	
	public Vehiculo() {}

	public Vehiculo(String placa, String marca, String modelo, int anio, double precio, String color,
			boolean disponible) {
		super();
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.anio = anio;
		this.precio = precio;
		this.color = color;
		this.disponible = disponible;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	@Override
	public String toString() {
		return "Vehiculo [placa=" + placa + ", marca=" + marca + ", modelo=" + modelo + ", anio=" + anio + ", precio="
				+ precio + ", color=" + color + ", disponible=" + disponible + "]";
	}
	
	
	
}
