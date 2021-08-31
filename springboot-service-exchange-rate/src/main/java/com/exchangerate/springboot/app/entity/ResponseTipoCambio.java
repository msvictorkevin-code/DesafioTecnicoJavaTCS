package com.exchangerate.springboot.app.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseTipoCambio  extends ResponseData{
    private Double monto;
    private Double montoCalculado;
    private String monedaOrigen;
    private String monedaDestino;
    private Double tipoCambio;
}