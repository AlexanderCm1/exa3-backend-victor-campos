package pe.apirestoracle.service;

import pe.apirestoracle.entity.Producto;
import pe.apirestoracle.entity.Venta;
import pe.apirestoracle.sql.SqlVenta;

import java.util.List;

public interface VentaService {


    void createVenta(SqlVenta venta);
    void updateVenta(SqlVenta venta);
    Venta getVenta(int id);
    List<Venta> getVentas();
    List<Producto> getProducto(String nomproc);
    List<Producto> getProductos();
}
