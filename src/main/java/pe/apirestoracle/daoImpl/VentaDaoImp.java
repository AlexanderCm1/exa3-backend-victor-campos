package pe.apirestoracle.daoImpl;


import oracle.jdbc.OracleTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.support.oracle.SqlReturnStruct;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import pe.apirestoracle.dao.VentaDao;
import pe.apirestoracle.entity.Producto;
import pe.apirestoracle.entity.Venta;
import pe.apirestoracle.sql.SqlVenta;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class VentaDaoImp implements VentaDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;



    @Override
    public void createVenta(SqlVenta venta) {
        simpleJdbcCall  = new SimpleJdbcCall(jdbcTemplate)
                        .withCatalogName("PK_VENTAS")
                        .withProcedureName("SP_CREATE_VENTA")
                        .declareParameters(
                                new SqlParameter("IN_VENTAS", OracleTypes.STRUCT,"PK_VENTAS.VENTA_TYPE")
                        );
        Map in = Collections.singletonMap("IN_VENTAS",venta);
        simpleJdbcCall.execute(in);

    }

    @Override
    public void updateVenta(SqlVenta venta) {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                            .withCatalogName("PK_VENTAS")
                            .withProcedureName("SP_UPDATE_VENTA")
                    .declareParameters(
                            new SqlParameter("IN_VENTAS", OracleTypes.STRUCT,"PK_VENTAS.VENTA_TYPE")
                    );
        Map in = Collections.singletonMap("IN_VENTAS",venta);
        simpleJdbcCall.execute(in);
    }

    @Override
    public Venta getVenta(int id) {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                            .withCatalogName("PK_VENTAS")
                            .withProcedureName("SP_GET_VENTA")
                            .declareParameters(
                                    new SqlOutParameter("OUT_VENTA", OracleTypes.STRUCT,"PK_VENTAS.VENTA_TYPE",
                                            new SqlReturnStruct(Venta.class))
                            );

        Map in = Collections.singletonMap("IN_VENTA_ID",id);

        return simpleJdbcCall.executeObject(Venta.class,in);
    }

    @Override
    public List<Venta> getVentas() {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                        .withCatalogName("PK_VENTAS")
                        .withProcedureName("SP_GET_VENTAS")
                        .returningResultSet("OUT_VENTAS",
                                BeanPropertyRowMapper.newInstance(Venta.class));
            return simpleJdbcCall.executeObject(List.class,Collections.emptyMap());

    }

    @Override
    public List<Producto> getProducto(String nomproc) {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                            .withCatalogName("PK_VENTAS")
                            .withProcedureName("SP_GET_PRODUCTOXNOMBRE")
                            .returningResultSet("OUT_PRODUCTO",
                                    BeanPropertyRowMapper.newInstance(Producto.class));
        Map in = Collections.singletonMap("NOMPROC",nomproc);
        return simpleJdbcCall.executeObject(List.class,in);
    }

    @Override
    public List<Producto> getProductos() {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                            .withCatalogName("PK_VENTAS")
                            .withProcedureName("SP_GET_PRODUCTOS")
                            .returningResultSet("OUT_PRODUCTOS",
                                    BeanPropertyRowMapper.newInstance(Producto.class));

        return simpleJdbcCall.executeObject(List.class,Collections.emptyMap());
    }
}
