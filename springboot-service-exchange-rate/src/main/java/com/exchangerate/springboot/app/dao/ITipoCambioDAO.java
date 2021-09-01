package com.exchangerate.springboot.app.dao;

import com.exchangerate.springboot.app.entity.model.TipoCambioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITipoCambioDAO extends JpaRepository<TipoCambioEntity, Long> {

    TipoCambioEntity findTopByMonedaOrigenAndMonedaDestino(String monedaOrigen, String MonedaDestino);
}
