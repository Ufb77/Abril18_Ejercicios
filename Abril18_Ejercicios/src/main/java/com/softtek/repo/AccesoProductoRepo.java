package com.softtek.repo;

import com.softtek.modelo.Producto;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AccesoProductoRepo extends Conexion implements IProductoRepo {

    public List<Producto> obtenerTodos() throws SQLException, ClassNotFoundException {
        Statement sentencia;
        ResultSet resultado;
        String sql = "Select product_id, product_name, unit_price, units_in_stock, category_id from products;";
        List<Producto> productos = new ArrayList<>();
        abrirConexion();
        sentencia = miConexion.createStatement();
        resultado = sentencia.executeQuery(sql);
        while(resultado.next()){
            productos.add(new Producto(resultado.getInt("product_id"),
                    resultado.getString("product_name"),
                    resultado.getDouble("unit_price"),
                    resultado.getInt("units_in_stock"),
                    resultado.getInt("category_id")));
        }

        miConexion.close();
        return productos;
    }


    //insertamos un producto
    public Producto crear(Producto p1) throws SQLException, ClassNotFoundException {
        abrirConexion();
        Statement sentencia;

        String sql = "INSERT INTO products(product_id, product_name, unit_price, units_in_stock, discontinued) VALUES (" + p1.getIdProducto() + ", '" + p1.getNombreProducto() + "',"
        +p1.getPrecioUnitario() + "," + p1.getUnidadesStock() + ",0)";
        sentencia = miConexion.createStatement();
        sentencia.executeUpdate(sql);
        miConexion.close();

        return p1;
    }

    //eliminar por id
    public void delete(int id) throws SQLException, ClassNotFoundException {
        abrirConexion();
        Statement sentencia;

        String sql = "DELETE FROM products WHERE product_id = " + id;
        sentencia = miConexion.createStatement();
        sentencia.executeUpdate(sql);
        miConexion.close();
    }


    public void update( Producto nuevoProducto) throws SQLException, ClassNotFoundException {
        abrirConexion();
        Statement sentencia;
        String sql = "UPDATE products SET product_name = '" + nuevoProducto.getNombreProducto() +"'," +
                "unit_price = " + nuevoProducto.getPrecioUnitario() + "," +
                "units_in_stock = " + nuevoProducto.getUnidadesStock() +" WHERE product_id =" + nuevoProducto.getIdProducto();
        sentencia = miConexion.createStatement();
        sentencia.executeUpdate(sql);
        miConexion.close();

    }

    public Producto obtenerUnoPorId(int id) throws SQLException, ClassNotFoundException {
        Statement sentencia;
        Producto producto = null;
        String sql = "SELECT product_id, product_name, unit_price, units_in_stock, category_id FROM products WHERE product_id =" + id;
        ResultSet resultado;
        abrirConexion();
        sentencia = miConexion.createStatement();
        resultado = sentencia.executeQuery(sql);
        if(resultado.next()){
            producto = new Producto(resultado.getInt("product_id"),
                    resultado.getString("product_name"),
                    resultado.getDouble("unit_price"),
                    resultado.getInt("units_in_stock"),
                    resultado.getInt("category_id"));


        }

        miConexion.close();
        return producto;
    }




}
