package hello;

import java.util.List;
import java.sql.SQLException;

public interface ObjDao {

    public void addProduct(PojoRow product) throws SQLException;   //добавить 
    public void updateProduct(PojoRow product) throws SQLException;//обновить
    public void deleteProduct(PojoRow product) throws SQLException;//удалить 
    public List getAllProduct() throws SQLException;                   //получить 

}