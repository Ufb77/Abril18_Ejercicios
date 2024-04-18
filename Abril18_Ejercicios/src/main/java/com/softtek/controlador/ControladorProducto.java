package com.softtek.controlador;

import com.softtek.modelo.Producto;
import com.softtek.servicio.IProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/productos")
public class ControladorProducto {

    @Autowired
    private IProductoServicio servicio;

    @GetMapping
    public List<Producto> obtenerTodos() throws SQLException, ClassNotFoundException {
        return  servicio.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Producto mostrarUno(@PathVariable int id) throws SQLException, ClassNotFoundException {

         return servicio.obtenerUnoPorId(id);
    }

    @PostMapping
    public Producto crearProducto(@RequestBody Producto p1) throws SQLException, ClassNotFoundException {
        return servicio.crear(p1);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) throws SQLException, ClassNotFoundException {
        servicio.delete(id);
    }

    @PutMapping() //No debería llevar id porque al metodo update solo se le pasa producto
    public void modificar(@RequestBody Producto producto) throws SQLException, ClassNotFoundException {
        servicio.update(producto);
    }

}
