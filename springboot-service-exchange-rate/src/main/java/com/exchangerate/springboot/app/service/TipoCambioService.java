package com.exchangerate.springboot.app.service;

import com.exchangerate.springboot.app.entity.RequestTipoCambio;
import com.exchangerate.springboot.app.entity.ResponseTipoCambio;

public interface TipoCambioService {
    ResponseTipoCambio procesarCambio(RequestTipoCambio requestTipoCambio);

}
