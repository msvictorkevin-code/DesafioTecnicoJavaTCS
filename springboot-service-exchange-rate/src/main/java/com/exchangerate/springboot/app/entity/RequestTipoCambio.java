package com.exchangerate.springboot.app.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@ToString
@Data
public class RequestTipoCambio {
    private Double monto;
    private String monedaOrigen;
    private String monedaDestino;


}
