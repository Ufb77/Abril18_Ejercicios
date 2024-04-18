package com.softtek.repo;

import com.softtek.modelo.Producto;

import java.sql.SQLException;
import java.util.List;

public interface IProductoRepo {

    List<Producto> obtenerTodos() throws SQLException, ClassNotFoundException;
    Producto crear(Producto producto) throws SQLException, ClassNotFoundException;
    void delete(int id) throws SQLException, ClassNotFoundException;
    void update(Producto nuevoProducto) throws SQLException, ClassNotFoundException;
    Producto obtenerUnoPorId(int id) throws SQLException, ClassNotFoundException;


}
