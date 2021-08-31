package com.exchangerate.springboot.app.entity.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "maestra_tipo_cambio")
public class TipoCambioEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String monedaOrigen;
    private String monedaDestino;
    private Double tipoCambio;
    @Column(name = "fecha_cambio")
    @Temporal(TemporalType.DATE)
    private Date fecha_cambio;

    public static TipoCambioEntityBuilder builder() {
        return new TipoCambioEntityBuilder();
    }
}
