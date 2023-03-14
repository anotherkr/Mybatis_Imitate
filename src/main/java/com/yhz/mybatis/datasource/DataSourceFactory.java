package com.yhz.mybatis.datasource;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author yanhuanzhan
 * @date 2023/3/8 - 16:07
 */
public interface DataSourceFactory {
    void setProperties(Properties props);

    DataSource getDataSource();
}
