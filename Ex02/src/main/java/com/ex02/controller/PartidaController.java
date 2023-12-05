package com.ex02.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ex02.dto.Mensaje;
import com.ex02.dto.Partida;
import com.ex02.service.PartidaService;

@RestController
@RequestMapping("ex2/partida")
public class PartidaController {
	private final PartidaService partidaService;

    public PartidaController(PartidaService partidaService) {
        this.partidaService = partidaService;
    }
//TODO comprobar existente
    @PostMapping
    public ResponseEntity<String> crearPartida(@RequestBody Partida nuevaPartida) {
        partidaService.crearPartida(nuevaPartida);
        return new ResponseEntity<>("Partida creada  exitosamente", HttpStatus.CREATED);
    }
    
    @GetMapping("/{videojuego}")
    public ResponseEntity<List<Partida>> buscarPartidasPorVideojuego(@PathVariable String videojuego) {
        List<Partida> partidas = partidaService.buscarPartidasPorVideojuego(videojuego);
        return ResponseEntity.ok(partidas);
    }
    
    @PostMapping("/{nombrePartida}/unirse")
    public ResponseEntity<String> unirseAPartida(@PathVariable String nombrePartida) {
        partidaService.unirseAPartida(nombrePartida);
        return ResponseEntity.ok("Usuario unido a la partida");
    }
//TODO Mirar si hay un max de jugadores
    @PostMapping("/{nombrePartida}/salir")
    public ResponseEntity<String> salirDePartida(@PathVariable String nombrePartida) {
        partidaService.salirDePartida(nombrePartida);
        return ResponseEntity.ok("Usuario salió de la partida");
    }
    
}
