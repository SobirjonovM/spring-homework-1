package uz.najottalim.demospringjdbc.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CustomerDAO {
    private Logger logger = LoggerFactory.getLogger(CustomerDAO.class);
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Customer> findAllCustomer(){
        String sql = "SELECT * from customer";
        List<Customer> customers = jdbcTemplate.query(sql, new Customer.CustomerRowMapper());
        return customers;
    }
}
