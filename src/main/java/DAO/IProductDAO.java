package DAO;

import model.Category;
import model.Product;

import java.util.List;

public interface IProductDAO {

    List<Product> selectAllProduct();

    List<Category> getAllCategory();

    String getNameCategory(int cate_id);

    Product findByIdProduct(int id);

    void updateProduct(Product product);

    List<Product> findByNameProduct(String name);

    void insertProduct(Product product);

    void deleteProduct(int id);


}
