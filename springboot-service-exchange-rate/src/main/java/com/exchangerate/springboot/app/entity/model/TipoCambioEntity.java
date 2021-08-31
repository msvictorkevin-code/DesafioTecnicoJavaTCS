package com.exchangerate.springboot.app.entity.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity()
@Table(name = "maestra_tipo_cambio")
public class TipoCambioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String monedaOrigen;
    private String monedaDestino;
    private Double tipoCambio;
    @Column(name = "fecha_cambio")
    @Temporal(TemporalType.DATE)
    private Date fecha_cambio;
}
