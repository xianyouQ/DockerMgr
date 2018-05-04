package com.youxianqin.dockermgr.mybatis.plugin;

import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import com.youxianqin.dockermgr.util.ReflectHelper;

import java.sql.Connection;
import java.util.Properties;


@Intercepts( {
        @Signature(method = "prepare", type = StatementHandler.class, args = {Connection.class,Integer.class}) })
public class BaseOperationFilter implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        RoutingStatementHandler handler = (RoutingStatementHandler) invocation.getTarget();
        StatementHandler delegate = (StatementHandler)ReflectHelper.getValueByFieldName(handler, "delegate");
        MappedStatement mappedStatement = (MappedStatement) ReflectHelper.getValueByFieldName(delegate, "mappedStatement");

        BoundSql boundSql = delegate.getBoundSql();
        System.out.println(boundSql.getSql());
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target,this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
