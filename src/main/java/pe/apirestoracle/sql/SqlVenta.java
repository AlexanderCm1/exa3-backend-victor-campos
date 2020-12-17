package pe.apirestoracle.sql;

import pe.apirestoracle.entity.Venta;

import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class SqlVenta extends Venta implements SQLData {

    @Override
    public String getSQLTypeName() throws SQLException {
        return "PK_VENTAS.VENTA_TYPE";
    }


    @Override
    public void readSQL(SQLInput sqlInput, String typeName) throws SQLException {
        setIdventa(sqlInput.readInt());
        setFecha(sqlInput.readString());
        setTipodoc(sqlInput.readString());
        setNumdoc(sqlInput.readString());
        setIdpersona(sqlInput.readInt());
        setIdusuario(sqlInput.readInt());
    }

    @Override
    public void writeSQL(SQLOutput sqlOutput) throws SQLException {
        sqlOutput.writeInt(getIdventa());
        sqlOutput.writeString(getFecha());
        sqlOutput.writeString(getTipodoc());
        sqlOutput.writeString(getNumdoc());
        sqlOutput.writeInt(getIdpersona());
        sqlOutput.writeInt(getIdusuario());
    }
}
