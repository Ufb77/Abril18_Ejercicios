package com.softtek.servicio;

import com.softtek.modelo.Producto;
import com.softtek.repo.IProductoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ProductoServicio implements IProductoServicio {

    @Autowired
    private IProductoRepo repo;


    @Override
    public List<Producto> obtenerTodos() throws SQLException, ClassNotFoundException {
        return repo.obtenerTodos();
    }

    @Override
    public Producto crear(Producto producto) throws SQLException, ClassNotFoundException {

        return repo.crear(producto);
    }

    @Override
    public void delete(int id) throws SQLException, ClassNotFoundException {

        repo.delete(id);
    }

    @Override
    public void update(Producto nuevoProducto) throws SQLException, ClassNotFoundException {

        repo.update( nuevoProducto);
    }

    @Override
    public Producto obtenerUnoPorId(int id) throws SQLException, ClassNotFoundException {

        return repo.obtenerUnoPorId(id);
    }
}
