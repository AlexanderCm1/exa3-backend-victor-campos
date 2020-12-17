package pe.apirestoracle;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import pe.apirestoracle.dao.AccesosDao;
import pe.apirestoracle.dao.RolDao;
import pe.apirestoracle.dao.UsuarioDao;
import pe.apirestoracle.dao.VentaDao;
import pe.apirestoracle.service.RolService;
import pe.apirestoracle.sql.SqlVenta;

@SpringBootTest
class ApiRestOracleApplicationTests {
@Autowired
AccesosDao pdao;
@Autowired
UsuarioDao pdao2;
@Autowired
PasswordEncoder passwordEncoder;
@Autowired
RolDao rolDao;
	@Autowired
	VentaDao ventaDao;

@Test
void contextLoads() {
	System.out.println(passwordEncoder.encode("123"));
	//System.out.println(pdao2.validarUsuario("dreyna"));

	//rolService.delete(14);
	//rolDao.read(13);
/*
	SqlVenta venta = new SqlVenta();
	venta.setFecha("17/12/2021");
	venta.setTipodoc("NI IDEA");
	venta.setNumdoc("222222");
	venta.setIdpersona(7);
	venta.setIdusuario(7);
	venta.setIdventa(2);
	ventaDao.updateVenta(venta);*/


	//System.out.println(ventaDao.getVentas());
	//System.out.println(ventaDao.getProducto("platano"));
	//System.out.println(ventaDao.getProductos());

}
}
