package pe.apirestoracle.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Producto {
	private int idproducto;
	private String nomprod;
	private double precio;
	private int stock;
}
