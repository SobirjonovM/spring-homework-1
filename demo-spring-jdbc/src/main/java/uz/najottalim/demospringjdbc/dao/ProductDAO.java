package uz.najottalim.demospringjdbc.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

@Service
public class ProductDAO {
    private Logger logger = LoggerFactory.getLogger(ProductDAO.class);
    @Autowired
    JdbcTemplate jdbcTemplate;

    public Integer findAllCount() {
        String sql = "SELECT COUNT(*) FROM PRODUCT";
        Integer product = jdbcTemplate.queryForObject(sql, Integer.class);
        logger.info("Product count {}", product);
        return product;
    }

    public String  findProductNameById(Integer id) {
        String sql = "SELECT name from product where id = ?";
        String product = jdbcTemplate.queryForObject(sql, String.class, id);
        logger.info("Product count {}", product);
        return product;
    }

    public Product  findProductById(Integer id) {
        String sql = "SELECT * from product where id = ?";
        Product product = jdbcTemplate.queryForObject(sql, new Product.ProductRowMapper(), id);
        logger.info("Product count {}", product);
        return product;
    }

    public List<Product> findProductsByPrice(Double price) {
        String sql = "SELECT * from product where price > ?";
        List<Product> products = jdbcTemplate.query(sql, new Product.ProductRowMapper(), price);
        logger.info("Product count {}", products);
        return products;
    }
    public List<Product> findProductsByCategory(String categoryName){
        String sql = "SELECT * from product where category = ?";
        List<Product> products = jdbcTemplate.query(sql, new Product.ProductRowMapper(), categoryName);
        return products;
    }

    public List<Product> findAllProductsOrderedByPrice(){
        String sql = "SELECT * from product ORDER BY price";
        List<Product> products = jdbcTemplate.query(sql, new Product.ProductRowMapper());
        return products;
    }
    public List<Product> findProductsByDate(LocalDate orderDate){
        String sql = "SELECT * from product_order WHERE order_date = ?";
        List<Product> products = jdbcTemplate.query(sql, new Product.ProductRowMapper(), orderDate);
        return products;
    }

    public Integer findSumOfOrders(){
        String sql = "SELECT SUM(p.price) " +
                "FROM product p" +
                "RIGHT JOIN order_product_relationship o" +
                "ON p.product_id = o.product_id";
        Integer result = jdbcTemplate.queryForObject(sql,Integer.class);
        return result;
    }
}
