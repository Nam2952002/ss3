package com.example.ss3.controller;

import com.example.ss3.dao.ProductDao;
import com.example.ss3.model.Products;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeServlet", value = "/HomeServlet")
public class HomeServlet extends HttpServlet {

    ProductDao dao = new ProductDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected List<Products> getList(){
        List<Products> list = dao.getProductByCategory(2);
        return list;
    }


    protected String updateProducts(){
        Products p = new Products();
        p.setId(3);
        p.setName("Iphone");
        p.setPrice(30000);
        return dao.updateProducts(p);
    }


    public String deleteProducts(){
        Products p = new Products();
        return dao.deleteProducts(p);
    }
}
