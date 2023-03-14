package com.yhz.mybatis.datasource.druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.yhz.mybatis.datasource.DataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author yanhuanzhan
 * @date 2023/3/8 - 16:06
 */
public class DruidDataSourceFactory implements DataSourceFactory {
    private Properties props;

    @Override
    public void setProperties(Properties props) {
        this.props = props;
    }

    @Override
    public DataSource getDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(props.getProperty("driver"));
        dataSource.setUrl(props.getProperty("url"));
        dataSource.setUsername(props.getProperty("username"));
        dataSource.setPassword(props.getProperty("password"));
        return dataSource;
    }
}
