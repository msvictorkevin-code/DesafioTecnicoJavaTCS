package com.exchangerate.springboot.app.dao;


import com.exchangerate.springboot.app.entity.model.UsuarioEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IUsuarioDAO extends CrudRepository<UsuarioEntity, Long> {

    UsuarioEntity findByUsername(String username);

    /*@Query("select u from UsuarioEntity u where u.username = ?1")
    UsuarioEntity findByUsername2(String username);*/
}
