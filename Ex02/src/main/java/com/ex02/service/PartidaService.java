package com.ex02.service;

import com.ex02.dao.IPartidaDAO;
import com.ex02.dto.Mensaje;
import com.ex02.dto.Partida;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PartidaService implements IPartidaService {

    private final IPartidaDAO partidaDAO;

    public PartidaService(IPartidaDAO partidaDAO) {
        this.partidaDAO = partidaDAO;
    }

    @Override
    public void crearPartida(Partida partida) {
        partidaDAO.save(partida);
    }
    
    public List<Partida> buscarPartidasPorVideojuego(String videojuego) {
        return partidaDAO.findByVideojuego(videojuego);
    }

    @Override
    public void unirseAPartida(String nombrePartida) {
        Partida partida = partidaDAO.findById(nombrePartida).orElse(null);
        if (partida != null) {
            partida.setJugadores(partida.getJugadores()+1);
            partidaDAO.save(partida);
        }
    }

    @Override
    public void salirDePartida(String nombrePartida) {
        Partida partida = partidaDAO.findById(nombrePartida).orElse(null);
            partida.setJugadores(partida.getJugadores()-1);
            partidaDAO.save(partida);
        
    }
   
}