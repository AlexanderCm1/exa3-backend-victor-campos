package pe.apirestoracle.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Venta {
    private int idventa;
    private String fecha;
    private String tipodoc;
    private String numdoc;
    private int idpersona;
    private int idusuario;


}


/*
IDVENTA   NOT NULL NUMBER(38)
FECHA              VARCHAR2(250)
TIPODOC            VARCHAR2(20)
NUMDOC             VARCHAR2(20)
IDPERSONA          NUMBER(38)
IDUSUARIO          NUMBER(38)




*
 */
