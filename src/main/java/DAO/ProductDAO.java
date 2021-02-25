package DAO;

import model.Category;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO {
    SingletonConnection connection = new SingletonConnection();
    Connection conn = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    @Override
    public List<Product> selectAllProduct() {
        List<Product> products = new ArrayList<>();
        try {
            conn = connection.getConnection();
            preparedStatement = conn.prepareStatement("select * from product;");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                int amount = resultSet.getInt("amount");
                String color = resultSet.getString("color");
                String description = resultSet.getString("description");
                int cate_id = resultSet.getInt("category_id");
                products.add(new Product(id, name, price, amount, color, description, cate_id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public List<Category> getAllCategory() {
        List<Category> categories = new ArrayList<>();
        try {
            conn = connection.getConnection();
            preparedStatement = conn.prepareStatement("select * from category;");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                categories.add(new Category(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public String getNameCategory(int cate_id) {
        String nameCategory = null;
        for (int i = 0; i < getAllCategory().size(); i++) {
            if (getAllCategory().get(i).getId()==cate_id) {
                nameCategory = getAllCategory().get(i).getName();
            }
        }
        return nameCategory;
    }

    @Override
    public void updateProduct(Product product) {
        conn = connection.getConnection();
        try {
            preparedStatement = conn.prepareStatement("update product set name=?, price=?,amount=?,color=?,description=?,category_id=? where id =?");
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getPrice());
            preparedStatement.setInt(3, product.getAmount());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getDescription());
            preparedStatement.setInt(6, product.getCategory_id());
            preparedStatement.setInt(7, product.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product findByIdProduct(int id) {
        Product product = null;
        conn = connection.getConnection();
        try {
            preparedStatement = conn.prepareStatement("select * from product where id=?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name=resultSet.getString("name");
                int price=resultSet.getInt("price");
                int amount=resultSet.getInt("amount");
                String color=resultSet.getString("color");
                String description=resultSet.getString("description");
                int category_id=resultSet.getInt("category_id");
                product=new Product(id,name,price,amount,color,description,category_id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> findByNameProduct(String name) {
        List<Product> products = new ArrayList<>();
        try {
            conn = connection.getConnection();
            preparedStatement = conn.prepareStatement("select * from product where name like ?;");
            preparedStatement.setString(1, "%" + name + "%");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name1 = resultSet.getString("name");
                int price = resultSet.getInt("price");
                int amount = resultSet.getInt("amount");
                String color = resultSet.getString("color");
                String description = resultSet.getString("description");
                int cate_id = resultSet.getInt("category_id");
                products.add(new Product(id, name1, price, amount, color, description, cate_id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;

    }

    @Override
    public void insertProduct(Product product) {
        conn = connection.getConnection();
        try {
            preparedStatement = conn.prepareStatement("insert into product(name,price,amount,color,description,category_id) values (?,?,?,?,?,?)");
            preparedStatement.setString(1,product.getName());
            preparedStatement.setInt(2,product.getPrice());
            preparedStatement.setInt(3,product.getAmount());
            preparedStatement.setString(4,product.getColor());
            preparedStatement.setString(5,product.getDescription());
            preparedStatement.setInt(6,product.getCategory_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProduct(int id) {
        conn = connection.getConnection();
        try {
            preparedStatement = conn.prepareStatement("delete from product where id=?");
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
