package com.example.labs.db;

import com.example.labs.model.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/*
 * Не используется в версии для xml только для лаб3+
 * Для лаб1-2 Закоментировать аннотации Component и Autowired
 */
@Component
public class PizzaDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String createPizza(String pizzaType, String customerName) {
        String sql = "INSERT INTO pizza (pizza_type, customer_name) VALUES (?, ?)";
        jdbcTemplate.update(sql, pizzaType, customerName);
        return "Pizza created";
    }

    public String deletePizza(String pizzaType, String customerName) {
        String sql = "DELETE FROM pizza WHERE customer_name = ? and pizza_type = ?";
        jdbcTemplate.update(sql, customerName, pizzaType);
        return "Pizza deleted";
    }

    public String updatePizza(String pizzaType, String customerName, String newCustomerName) {
        String sql = "UPDATE pizza SET customer_name = ? WHERE pizza_type = ? and customer_name = ?";
        jdbcTemplate.update(sql, newCustomerName, pizzaType, customerName);
        return "Pizza updated";
    }

    public List<Pizza> getPizzas(String pizzaType, String customerName) {
        String sql = "SELECT * FROM pizza where pizza_type = ? and customer_name = ?";
        return jdbcTemplate.query(sql, new Object[]{pizzaType, customerName}, new PizzaRowMapper());
    }

    public Pizza getPizza(String pizzaType, String customerName) {
        String sql = "SELECT * FROM pizza where pizza_type = ? and customer_name = ?";
        List<Pizza> pizzas = jdbcTemplate.query(sql, new Object[]{pizzaType, customerName}, new PizzaRowMapper());
        return pizzas.isEmpty() ? null : pizzas.iterator().next();
    }

    private static class PizzaRowMapper implements RowMapper<Pizza> {
        @Override
        public Pizza mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Pizza(rs.getString("pizza_type"), rs.getString("customer_name"));
        }
    }
}
