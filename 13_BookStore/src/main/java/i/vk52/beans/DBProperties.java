package i.vk52.beans;

import javax.sql.DataSource;

public class DBProperties {
    private DataSource dataSource;

    // Setter for the DataSource
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    // Getter for the DataSource
    public DataSource getDataSource() {
        return dataSource;
    }
}
