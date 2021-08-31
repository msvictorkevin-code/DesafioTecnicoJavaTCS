package com.exchangerate.springboot.app.service;

import com.exchangerate.springboot.app.dao.TipoCambioDAO;
import com.exchangerate.springboot.app.entity.RequestTipoCambio;
import com.exchangerate.springboot.app.entity.ResponseTipoCambio;
import com.exchangerate.springboot.app.entity.model.TipoCambioEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TipoCambioServiceImpl implements TipoCambioService {

    private final Logger logger = LoggerFactory.getLogger(TipoCambioServiceImpl.class);

    @Autowired
    private TipoCambioDAO dao;

    @Override
    public ResponseTipoCambio procesarCambio(RequestTipoCambio requestTipoCambio) {
        ResponseTipoCambio tipoCambio = new ResponseTipoCambio();
        try {
            TipoCambioEntity tipoCambioEntity = dao.findTopByMonedaOrigenAndMonedaDestino(requestTipoCambio.getMonedaOrigen(), requestTipoCambio.getMonedaDestino());

            if (Objects.nonNull(tipoCambioEntity)) {
                tipoCambio.setMonto(requestTipoCambio.getMonto());
                tipoCambio.setMonedaOrigen(tipoCambioEntity.getMonedaOrigen());
                tipoCambio.setMonedaDestino(tipoCambioEntity.getMonedaDestino());
                tipoCambio.setTipoCambio(tipoCambioEntity.getTipoCambio());
                tipoCambio.setMontoCalculado(calcularMontoCambio(requestTipoCambio, tipoCambioEntity));
            }

        } catch (DataAccessException ex) {
            logger.error(ex.getMessage());
        }
        return tipoCambio;
    }


    public Double calcularMontoCambio(RequestTipoCambio tipoCambio, TipoCambioEntity tipoCambioDB) {

        return tipoCambio.getMonto() * tipoCambioDB.getTipoCambio();
    }
}
