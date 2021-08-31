package com.exchangerate.springboot.app.controllers;

import com.exchangerate.springboot.app.entity.RequestTipoCambio;
import com.exchangerate.springboot.app.entity.ResponseTipoCambio;
import com.exchangerate.springboot.app.service.TipoCambioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            return new ResponseEntity<>(responseTipoCambio, HttpStatus.NO_CONTENT);
        }
    }
}
