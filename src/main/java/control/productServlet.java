package control;

import DAO.IProductDAO;
import DAO.ProductDAO;
import model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "productServlet", value = "/product")
public class productServlet extends HttpServlet {
    IProductDAO productDAO = new ProductDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showFormInsert(request, response);
                break;
            case "edit":
                showFormEdit(request, response);
                break;
            case "delete":
                delProduct(request, response);
                break;
            default:
                showAllProduct(request, response);
                break;
        }
    }

    private void showFormInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("create.jsp").forward(request, response);
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productDAO.findByIdProduct(id);
        request.setAttribute("product", product);
        request.getRequestDispatcher("edit.jsp").forward(request, response);

    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameProduct = request.getParameter("search");
        List<Product> productList2 = productDAO.findByNameProduct(nameProduct);
        request.setAttribute("productList2", productList2);
        request.getRequestDispatcher("search.jsp").forward(request, response);
    }

    private void showAllProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productDAO.selectAllProduct();
        request.setAttribute("productList", productList);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "search":
                searchByName(request, response);
                break;
            case "edit":
                updateProduct(request, response);
                break;
            case "create":
                insertProduct(request, response);
                break;
        }

    }

    private void delProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        productDAO.deleteProduct(id);
        response.sendRedirect("/product");
    }

    private void insertProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name_product2");
        int price = Integer.parseInt(request.getParameter("price_product2"));
        int amount = Integer.parseInt(request.getParameter("amount_product2"));
        String color = request.getParameter("color_product2");
        String des = request.getParameter("des_product2");
        int category_id = Integer.parseInt(request.getParameter("category_id2"));
        Product product = new Product(name, price, amount, color, des, category_id);
        productDAO.insertProduct(product);
        response.sendRedirect("/product");
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name_product");
        int price = Integer.parseInt(request.getParameter("price_product"));
        int amount = Integer.parseInt(request.getParameter("amount_product"));
        String color = request.getParameter("color_product");
        String des = request.getParameter("des_product");
        int category_id = Integer.parseInt(request.getParameter("category_id"));
        Product product = new Product(id, name, price, amount, color, des, category_id);
        productDAO.updateProduct(product);
        response.sendRedirect("/product");
    }
}