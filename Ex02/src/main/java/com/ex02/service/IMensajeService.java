package com.ex02.service;

import java.util.List;

import com.ex02.dto.Mensaje;

public interface IMensajeService {
    void crearMensaje(Mensaje mensaje);
    void eliminarMensaje(Long idMensaje);
    List<Mensaje> verTodosLosMensajes(String nombrePartida);
}
