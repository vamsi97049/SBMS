package i.vk.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

@SuppressWarnings("serial")
public class OrderIdGenerator implements IdentifierGenerator {

    @Override
    public Object generate(SharedSessionContractImplementor session, Object object) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        Object generatedId = null;

        try {
            conn = session.getJdbcConnectionAccess().obtainConnection();
            stmt = conn.createStatement();
            String sql = "SELECT ORD_ID.NEXTVAL FROM DUAL";
            rs = stmt.executeQuery(sql);
            
            if (rs.next()) {
                generatedId = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return "ORD"+generatedId;
    }
}
