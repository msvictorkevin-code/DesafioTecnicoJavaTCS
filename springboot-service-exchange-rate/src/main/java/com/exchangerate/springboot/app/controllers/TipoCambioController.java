package com.exchangerate.springboot.app.controllers;

import com.exchangerate.springboot.app.entity.RequestTipoCambio;
import com.exchangerate.springboot.app.entity.ResponseTipoCambio;
import com.exchangerate.springboot.app.entity.model.TipoCambioEntity;
import com.exchangerate.springboot.app.service.TipoCambioService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Slf4j
@RestController
@RequestMapping("api")
public class TipoCambioController {
    private final Logger logger = LoggerFactory.getLogger(TipoCambioController.class);

    @Autowired
    private TipoCambioService service;

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @PostMapping("/tipocambio")
    public ResponseEntity<ResponseTipoCambio> obtenerTipoCambio(@RequestBody RequestTipoCambio requestTipoCambio) {
        ResponseTipoCambio responseTipoCambio = new ResponseTipoCambio();
        try {
            responseTipoCambio = service.procesarCambio(requestTipoCambio);
            responseTipoCambio.setMessage("OK");
            responseTipoCambio.setSuccess(Boolean.TRUE);
            log.info("Respuesta: " + responseTipoCambio.toString());
            return new ResponseEntity<>(responseTipoCambio, HttpStatus.OK);
        } catch (Exception ex) {
            log.error("Excepcion: " + ex.getMessage());
            responseTipoCambio.setMessage("ERROR");
            responseTipoCambio.setSuccess(Boolean.FALSE);
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @Secured({"ROLE_ADMIN"})
    @PutMapping("/tipocambioext/{id}")
    public ResponseEntity<TipoCambioEntity> actualizarTipoCambio(@PathVariable Long id, @RequestBody TipoCambioEntity tipoCambioEntity) {
        try {
            TipoCambioEntity entity = TipoCambioEntity.builder()
                    .id(id)
                    .tipoCambio(tipoCambioEntity.getTipoCambio())
                    .monedaDestino(tipoCambioEntity.getMonedaDestino())
                    .monedaOrigen(tipoCambioEntity.getMonedaOrigen())
                    .fecha_cambio(new Date()).build();
            log.info("Data Enviada: " + entity.toString());
            return new ResponseEntity<>(service.actualizarTipoCambio(entity), HttpStatus.OK);
        } catch (Exception ex) {
            log.error("Excepcion: " + ex.getMessage());
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }
}
