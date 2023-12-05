package com.ex02.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ex02.dto.Mensaje;
import com.ex02.dto.Partida;
import com.ex02.service.MensajeService;
import com.ex02.service.PartidaService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("ex2/mensaje")
public class MensajeController {
    private final MensajeService mensajeService;

    public MensajeController(MensajeService mensajeService) {
        this.mensajeService = mensajeService;
    }

    @PostMapping("/crear")
    public ResponseEntity<String> crearMensaje(@RequestBody Mensaje mensaje) {
        mensajeService.crearMensaje(mensaje);
        return new ResponseEntity<>("Mensaje creado exitosamente", HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{idMensaje}")
    public ResponseEntity<String> eliminarMensaje(@PathVariable Long idMensaje) {
        mensajeService.eliminarMensaje(idMensaje);
        return ResponseEntity.ok("Mensaje eliminado exitosamente");
    }
    
    @GetMapping("/verTodosEnSala/{nombreSala}")
    public ResponseEntity<List<Mensaje>> verTodosLosMensajesEnSala(@PathVariable String nombreSala) {
        List<Mensaje> mensajes = mensajeService.verTodosLosMensajes(nombreSala);
        List<Mensaje> mensajesEnSala = new ArrayList<>();

        for (Mensaje mensaje : mensajes) {
            Partida partida = mensaje.getPartida();
        	System.out.println(partida);
            if (partida != null && partida.getNombre().equals(nombreSala)) {
                mensajesEnSala.add(mensaje);
            }
        }

        return ResponseEntity.ok(mensajesEnSala);
    }

    
    @PutMapping("/editar/{idMensaje}")
    public ResponseEntity<String> editarMensaje(@PathVariable Long idMensaje, @RequestBody Mensaje mensajeActualizado) {
        mensajeService.editarMensaje(idMensaje, mensajeActualizado);
        return ResponseEntity.ok("Mensaje editado exitosamente");
    }
    
    
    
}
