package com.exchangerate.springboot.app.service;

import com.exchangerate.springboot.app.entity.RequestTipoCambio;
import com.exchangerate.springboot.app.entity.ResponseTipoCambio;
import com.exchangerate.springboot.app.entity.model.TipoCambioEntity;

public interface TipoCambioService {
    ResponseTipoCambio procesarCambio(RequestTipoCambio requestTipoCambio);
    TipoCambioEntity actualizarTipoCambio(TipoCambioEntity tipoCambioEntity);
}
