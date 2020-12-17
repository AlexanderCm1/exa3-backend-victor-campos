package pe.apirestoracle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.apirestoracle.entity.Producto;
import pe.apirestoracle.entity.Venta;
import pe.apirestoracle.service.VentaService;
import pe.apirestoracle.sql.SqlVenta;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")

@RestController
@RequestMapping(value = "/api/venta", produces = MediaType.APPLICATION_JSON_VALUE)
public class VentaController {
    @Autowired
    VentaService ventaService;

    @PostMapping()
    public ResponseEntity<Venta> createVenta(@RequestBody SqlVenta venta){
            ventaService.createVenta(venta);
        return new ResponseEntity<>(venta, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Venta> updateVenta(@PathVariable int id, @RequestBody SqlVenta venta){
        venta.setIdventa(id);
        ventaService.updateVenta(venta);
        return new ResponseEntity<>(venta,HttpStatus.ACCEPTED);
    }

    @GetMapping("{id}")
    public Map<String,Venta> getVenta(@PathVariable int id){
        Map<String,Venta> venta = new HashMap<>();
        venta.put("venta", ventaService.getVenta(id));
        return venta;
    }
    @GetMapping()
    public Map<String, List<Venta>> getVentas(){
        Map<String, List<Venta>> ventas = new HashMap<>();
        ventas.put("ventas", ventaService.getVentas());
        return ventas;
    }
    @GetMapping("/producto/{nomproc}")
    public Map<String,List<Producto>> getProducto(@PathVariable String nomproc){
        Map<String,List<Producto>> producto = new HashMap<>();
        producto.put("producto",ventaService.getProducto(nomproc));
        return producto;
    }
    @GetMapping("/producto")
     public Map<String,List<Producto>> getProductos(){
        Map<String,List<Producto>> productos = new HashMap<>();
        productos.put("productos",ventaService.getProductos());
        return productos;
    }
}
