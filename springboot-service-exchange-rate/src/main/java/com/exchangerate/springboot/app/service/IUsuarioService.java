package com.exchangerate.springboot.app.service;


import com.exchangerate.springboot.app.entity.model.UsuarioEntity;

public interface IUsuarioService {
    UsuarioEntity findByUsername(String username);
}
