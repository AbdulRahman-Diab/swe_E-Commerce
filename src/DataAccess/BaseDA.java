package DataAccess;

import java.sql.SQLException;
import java.util.ArrayList;

public interface BaseDA <E>{
    
    ArrayList<E> FindAll() throws SQLException;
    E FindById(int id) throws SQLException;
    boolean Delete(int id) throws SQLException;
    boolean Save(E obj) throws SQLException;
    boolean Update(E obj) throws SQLException;
    
}
