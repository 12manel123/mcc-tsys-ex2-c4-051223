package com.ex02.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ex02.dao.IMensajeDAO;
import com.ex02.dto.Mensaje;

@Service
public class MensajeService implements IMensajeService {
    private final IMensajeDAO mensajeDAO;

    public MensajeService(IMensajeDAO mensajeDAO) {
        this.mensajeDAO = mensajeDAO;
    }

    public void crearMensaje(Mensaje mensaje) {
        mensajeDAO.save(mensaje);
    }

    public void eliminarMensaje(Long idMensaje) {
        mensajeDAO.deleteById(idMensaje);
    }

    public List<Mensaje> verTodosLosMensajes(String nombreSala) {
        return mensajeDAO.findAll();
    }
    public void editarMensaje(Long idMensaje, Mensaje mensajeActualizado) {
        Mensaje mensajeExistente = mensajeDAO.findById(idMensaje).orElse(null);
        if (mensajeExistente != null) {
            mensajeExistente.setContenido(mensajeActualizado.getContenido());
            mensajeExistente.setNombreUsuarioCreador(mensajeActualizado.getNombreUsuarioCreador());
                        mensajeDAO.save(mensajeExistente);
        }
    }

}