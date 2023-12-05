package com.ex02.service;

import java.util.List;

import com.ex02.dto.Mensaje;
import com.ex02.dto.Partida;

public interface IPartidaService {
    void crearPartida(Partida partida);
    List<Partida> buscarPartidasPorVideojuego(String videojuego);
    void unirseAPartida(String nombrePartida);
    void salirDePartida(String nombrePartida);

}
