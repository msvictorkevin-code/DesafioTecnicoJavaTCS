package com.exchangerate.springboot.app.controllers;

import com.exchangerate.springboot.app.entity.RequestTipoCambio;
import com.exchangerate.springboot.app.entity.ResponseTipoCambio;
import com.exchangerate.springboot.app.entity.model.TipoCambioEntity;
import com.exchangerate.springboot.app.service.TipoCambioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("api/tipocambio")
public class TipoCambioController {
    private final Logger logger = LoggerFactory.getLogger(TipoCambioController.class);

    @Autowired
    private TipoCambioService service;

    @PostMapping
    public ResponseEntity<ResponseTipoCambio> obtenerTipoCambio(@RequestBody RequestTipoCambio requestTipoCambio) {
        ResponseTipoCambio responseTipoCambio = new ResponseTipoCambio();
        try {
            responseTipoCambio = service.procesarCambio(requestTipoCambio);
            responseTipoCambio.setMessage("OK");
            responseTipoCambio.setSuccess(Boolean.TRUE);
            return new ResponseEntity<>(responseTipoCambio, HttpStatus.OK);
        } catch (Exception ex) {
            responseTipoCambio.setMessage("ERROR");
            responseTipoCambio.setSuccess(Boolean.FALSE);
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoCambioEntity> actualizarTipoCambio(@PathVariable Long id, @RequestBody TipoCambioEntity tipoCambioEntity) {

        try {
            TipoCambioEntity entity = TipoCambioEntity.builder()
                    .id(id)
                    .tipoCambio(tipoCambioEntity.getTipoCambio())
                    .monedaDestino(tipoCambioEntity.getMonedaDestino())
                    .monedaOrigen(tipoCambioEntity.getMonedaOrigen())
                    .fecha_cambio(new Date()).build();
            return new ResponseEntity<>(service.actualizarTipoCambio(entity), HttpStatus.OK);
        } catch (Exception ex) {

            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }
}
