package pe.apirestoracle.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.apirestoracle.dao.VentaDao;
import pe.apirestoracle.entity.Producto;
import pe.apirestoracle.entity.Venta;
import pe.apirestoracle.service.VentaService;
import pe.apirestoracle.sql.SqlVenta;

import java.util.List;


@Service
public class VentaServiceImp implements VentaService {
    @Autowired
    VentaDao ventaDao;

    @Override
    public void createVenta(SqlVenta venta) {
        ventaDao.createVenta(venta);
    }

    @Override
    public void updateVenta(SqlVenta venta) {
        ventaDao.updateVenta(venta);
    }

    @Override
    public Venta getVenta(int id) {
        return ventaDao.getVenta(id);
    }

    @Override
    public List<Venta> getVentas() {
        return ventaDao.getVentas();
    }

    @Override
    public List<Producto> getProducto(String nomproc) {
        return ventaDao.getProducto(nomproc);
    }

    @Override
    public List<Producto> getProductos() {
        return ventaDao.getProductos();
    }
}
