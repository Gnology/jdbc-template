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
public class OfficesRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(MysqlDataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Office getOfficeByCode(String officeCode) {
        RowMapper<Office> rowMapper = new OfficeRowMapper();
        return jdbcTemplate.queryForObject("SELECT * FROM offices WHERE officeCode = ?", rowMapper, officeCode);
    }

    public List<Office> getAllOffices(){
        String sql = "SELECT * FROM offices";
        return jdbcTemplate.query(sql, new OfficeRowMapper());
    }

    private static class OfficeRowMapper implements RowMapper<Office> {
        public Office mapRow(ResultSet resultSet, int i) throws SQLException {
            Office office = new Office();
            office.setOfficeCode(resultSet.getString("officeCode"));
            office.setCity(resultSet.getString("city"));
            office.setPhone(resultSet.getString("phone"));
            office.setAddressLine1(resultSet.getString("addressLine1"));
            office.setAddressLine2(resultSet.getString("addressLine2"));
            office.setState(resultSet.getString("state"));
            office.setCountry(resultSet.getString("country"));
            office.setPostalCode(resultSet.getString("postalCode"));
            office.setTerritory(resultSet.getString("territory"));

            return office;
        }
    }
}
