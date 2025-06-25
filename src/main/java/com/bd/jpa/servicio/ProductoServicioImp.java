package com.bd.jpa.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.jpa.modelo.TblProducto;
import com.bd.jpa.repositorio.IProductoRepositorio;

import jakarta.transaction.Transactional;

@Service
public class ProductoServicioImp implements IProductoServicio {
	//aplicamos la inyeccion de dependencia...
	@Autowired
	private IProductoRepositorio iproductorepositorio;
	

	@Override
	@Transactional
	public void RegistrarProducto(TblProducto tblprod) {
		// invocamos el metodo registrar...
		iproductorepositorio.save(tblprod);
		
	}//fin del metodo

	@Override
	@Transactional
	public void EliminarProducto(TblProducto tblprod) {
		// invocamos el metodo eliminar...
		iproductorepositorio.deleteById(tblprod.getIdproducto());
		
	}//fin del metodo

	@Override
	@Transactional
	public List<TblProducto> ListadoProductos() {
		//invocamos el metodo mlistado
		
		return (List<TblProducto>) iproductorepositorio.findAll();
		
	}//fin del metodo

	@Override
	@Transactional
	public TblProducto BuscarporId(Integer id) {
		//invocamos el metodo buscar...
		
		return   iproductorepositorio.findById(id).orElse(null);
		
	}//fin del metodo
	 

}// fin e la clase
