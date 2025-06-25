package com.bd.jpa.controlador;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bd.jpa.modelo.TblProducto;
import com.bd.jpa.servicio.IProductoServicio;

@Controller
@RequestMapping("/vistas")
public class ProductoController {
	//inyeccion de dependencia
	@Autowired
	private IProductoServicio iproductoservicio;
	
	@GetMapping("/ListadoProductos")
	public String ListadoProductos(Model modelo) {
		
		//recuperamos los datos de la bd...
		List<TblProducto> listado=iproductoservicio.ListadoProductos();
		//enviamops hacia la vista
		modelo.addAttribute("listado",listado);
		//retornamos 
		return "/vistas/ListadoProductos";
		
		
	}//fin del metodo producto
	
	//creamos el metodo para listar
	@GetMapping("/RegistrarProducto")
	public String RegistrarProducto(Model modelo) {
		//realizamos la respectiva instancia...
		TblProducto tblprod= new TblProducto();
		//enviamos hacia la vista
		modelo.addAttribute("regproducto",tblprod);
		//retornamos el formulario
		return "/vistas/FrmRegProducto";
	
	}//fin de metodo
	

	//reali9zamos el mapeo con posmapping...
	@PostMapping("/GuardarProducto")
	public String GuardarProducto(@ModelAttribute TblProducto tblprod,Model modelo) {
		iproductoservicio.RegistrarProducto(tblprod);
		//emitimos el mensaje por consola
		System.out.println("Dato registrado en la BD!!!!");
		//retornamos el listado
		return "redirect:/vistas/ListadoProductos";
		
	}//fin de metodo
	
	
	//******EDITAR...
	//creamos el metodo editar...
	@GetMapping("/editarproducto/{id}")
	public String Editar(@PathVariable("id") Integer idproducto,Model modelo) {
		
	//creamos un objeto de tipo tblproducto
		TblProducto clproducto=iproductoservicio.BuscarporId(idproducto);
		//enviamos hacia la vista...
		modelo.addAttribute("regproducto",clproducto);
		//enviamos al frmregproducto...
		return "/vistas/FrmRegProducto";
		
		
	
	}//fin del metodo editar
	
	//********eliminar
	//creamos el metodo eliminar...
	@GetMapping("/eliminarproducto/{id}")
	public String eliminar(@PathVariable ("id") Integer idproducto,Model modelo) {
		
		TblProducto tblpro=new TblProducto();
		tblpro.setIdproducto(idproducto);
		
		//aplicamos la inyeccion de dependencia
		iproductoservicio.EliminarProducto(tblpro);
		
		//actualizamos el listado
		List<TblProducto> listado=iproductoservicio.ListadoProductos();
		
		//enviamos hacia la vista
		modelo.addAttribute("listado",listado);
		
		//redireccionamos
		return "redirect:/vistas/ListadoProductos";
		
		
		
	}//fin de metodo eliminar...
	
	
	
	
}//fin de la clase
