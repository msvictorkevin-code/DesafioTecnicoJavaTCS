package com.exchangerate.springboot.app.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestTipoCambio {
    private Double monto;
    private String monedaOrigen;
    private String monedaDestino;


}
