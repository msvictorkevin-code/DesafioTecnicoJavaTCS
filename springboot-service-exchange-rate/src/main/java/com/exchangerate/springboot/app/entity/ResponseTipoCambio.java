package com.exchangerate.springboot.app.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Data
public class ResponseTipoCambio  extends ResponseData{
    private Double monto;
    private Double montoCalculado;
    private String monedaOrigen;
    private String monedaDestino;
    private Double tipoCambio;
}