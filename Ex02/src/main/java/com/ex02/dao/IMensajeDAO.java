package com.ex02.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ex02.dto.Mensaje;

public interface IMensajeDAO extends JpaRepository<Mensaje, Long> {
}