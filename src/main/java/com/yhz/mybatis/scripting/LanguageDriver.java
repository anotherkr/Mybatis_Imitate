package com.yhz.mybatis.scripting;

import com.yhz.mybatis.mapping.SqlSource;
import com.yhz.mybatis.session.Configuration;
import org.dom4j.Element;

/**
 * 脚本语言驱动
 * @author yanhuanzhan
 * @date 2023/3/15 - 17:49
 */
public interface LanguageDriver {
    SqlSource createSqlSource(Configuration configuration, Element script, Class<?> parameterType);

}
