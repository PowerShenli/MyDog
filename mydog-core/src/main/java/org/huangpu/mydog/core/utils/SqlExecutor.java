package org.huangpu.mydog.core.utils;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by shenli on 2017/5/4.
 */
public class SqlExecutor {

    private static final Logger LOG = LoggerFactory.getLogger(SqlExecutor.class);

    public static int execute(String url, String user, String pass, String sql) {
        Connection conn = new ConnectUtils(url,user,pass).getConnection();
        try {
            QueryRunner run = new QueryRunner();
            int update = run.update(conn, sql);
            LOG.debug("update = " + update);
            return update;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            try {
                DbUtils.close(conn);
            } catch (SQLException e) {
            }
        }
        return 0;
    }
}
