package com.bd.jpa.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bd.jpa.modelo.TblProducto;

@Repository
public interface IProductoRepositorio extends CrudRepository<TblProducto,Integer> {

}
