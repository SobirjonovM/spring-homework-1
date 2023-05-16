package uz.najottalim.demospringjdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.najottalim.demospringjdbc.dao.Product;
import uz.najottalim.demospringjdbc.dao.ProductDAO;

import java.time.LocalDate;
import java.util.List;

@RestController

@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductDAO productDAO;

    @GetMapping("/all-count")
    public Integer getAllProductsCount() {
        return productDAO.findAllCount();
    }

    @GetMapping("/name/{id}")
    public String getProductNameById(@PathVariable Integer id) {
        return productDAO.findProductNameById(id);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Integer id) {
        return productDAO.findProductById(id);
    }

    @GetMapping("/price/{price}")
    public List<Product> getProductById(@PathVariable Double price) {
        return productDAO.findProductsByPrice(price);
    }

    @GetMapping("/category/{categoryName}")
    public List<Product> getProductsByCategory(@PathVariable String categoryName) {
        return productDAO.findProductsByCategory(categoryName);
    }

    @GetMapping("/all")
    public List<Product> getAllProductsOrderedByPrice() {
        return productDAO.findAllProductsOrderedByPrice();
    }

    @GetMapping("/order-date/{orderDate}")
    public List<Product> getProductByDate(@PathVariable ("orderDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate orderDate){
        return productDAO.findProductsByDate(orderDate);
    }

    @GetMapping("/orders/all-sum")
    public Integer getSumOfOrders(){
        return productDAO.findSumOfOrders();
    }


}
