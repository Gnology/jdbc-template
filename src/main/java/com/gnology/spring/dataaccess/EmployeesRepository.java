package com.gnology.spring.dataaccess;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeesRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(MysqlDataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public List<Employee> getAllEmployees(){
        String sql = "SELECT * FROM employees";
        return jdbcTemplate.query(sql, new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
                Employee employee = new Employee();
                employee.setFirstName(resultSet.getString("firstName"));
                employee.setLastName(resultSet.getString("lastName"));
                return employee;
            }
        });
    }


}
