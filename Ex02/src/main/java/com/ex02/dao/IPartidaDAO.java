package com.ex02.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ex02.dto.Partida;

public interface IPartidaDAO extends JpaRepository<Partida, String> {
    List<Partida> findByVideojuego(String videojuego);
}


