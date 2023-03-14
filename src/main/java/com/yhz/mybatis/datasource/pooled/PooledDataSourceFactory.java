package com.yhz.mybatis.datasource.pooled;

import com.yhz.mybatis.datasource.unpooled.UnpooledDataSourceFactory;

import javax.sql.DataSource;

/**
 * @author yanhuanzhan
 * @date 2023/3/12 - 14:11
 */
public class PooledDataSourceFactory extends UnpooledDataSourceFactory {
    public PooledDataSourceFactory() {
        this.dataSource = new PooledDataSource();
    }

}
