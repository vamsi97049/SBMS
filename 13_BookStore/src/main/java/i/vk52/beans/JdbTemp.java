package i.vk52.beans;

import org.springframework.jdbc.core.JdbcTemplate;

public class JdbTemp {
    private JdbcTemplate jdbcTemplate;
    private DBProperties dbProperties;

    // Setter injection for DBProperties
    public void setDbProperties(DBProperties dbProperties) {
        this.dbProperties = dbProperties;
        // Initialize the JdbcTemplate after DBProperties is injected
        this.jdbcTemplate = new JdbcTemplate(dbProperties.getDataSource());
    }

    // Getter for JdbcTemplate
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
}
