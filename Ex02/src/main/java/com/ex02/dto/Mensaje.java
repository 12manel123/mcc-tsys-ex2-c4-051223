package com.ex02.dto;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Mensaje {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String contenido;
    private String nombreUsuarioCreador;
    
    @ManyToOne
	@JoinColumn(name = "partida_id")
	private Partida partida;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	public String getNombreUsuarioCreador() {
		return nombreUsuarioCreador;
	}
	public void setNombreUsuarioCreador(String nombreUsuarioCreador) {
		this.nombreUsuarioCreador = nombreUsuarioCreador;
	}
	public Mensaje(Long id, String contenido, String nombreUsuarioCreador) {
		super();
		this.id = id;
		this.contenido = contenido;
		this.nombreUsuarioCreador = nombreUsuarioCreador;
	}
	public Mensaje() {
		super();
	}
	public Partida getPartida() {
		return partida;
	}
	public void setPartida(Partida partida) {
		this.partida = partida;
	}
	
    
    
}
