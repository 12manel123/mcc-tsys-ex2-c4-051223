package com.ex02.dto;


import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Partida {
    @Id
    private String nombre;
    private String descripcion;
    private int jugadores;
    private String plataforma;
    private Date fechaInicio;
    private String videojuego;
    
    @OneToMany(mappedBy = "partida", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Mensaje> mensajes;
    
    public Partida() {
    }
    
    

    public List<Mensaje> getMensajes() {
		return mensajes;
	}



	public void setMensajes(List<Mensaje> mensajes) {
		this.mensajes = mensajes;
	}



	public Partida(String nombre, String descripcion, int jugadores, String plataforma, Date fechaInicio, String videojuego) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.jugadores = jugadores;
        this.plataforma = plataforma;
        this.fechaInicio = fechaInicio;
        this.videojuego = videojuego;
    }
    public String getVideojuego() {
        return videojuego;
    }

    public void setVideojuego(String videojuego) {
        this.videojuego = videojuego;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getJugadores() {
        return jugadores;
    }

    public void setJugadores(int jugadores) {
        this.jugadores = jugadores;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
}
