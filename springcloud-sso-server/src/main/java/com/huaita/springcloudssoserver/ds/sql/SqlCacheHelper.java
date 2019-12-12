package com.huaita.springcloudssoserver.ds.sql;

import com.huaita.springcloudssoserver.ds.cache.CacheUtil;
import com.huaita.springcloudssoserver.ds.util.Read;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class SqlCacheHelper
{

  @Autowired
  private  CacheUtil cacheUtil;

  public  String getSql(String sqlFile, Class<?> clazz, String sqlId)
  {
    Object map = cacheUtil.get(sqlFile);
    Map sqls = null;
    if ((map != null) && ((map instanceof Map)))
    {
      sqls = (Map)map;
    }
    else
    {
      SqlXml sqlXml = new SqlXml(sqlFile, clazz);
      sqls = sqlXml.getAllSqls();
      cacheUtil.set(sqlFile,sqls);
    }
    return (String)sqls.get(sqlId);
  }
  public  String getSql(String sqlFile, Class<?> clazz, String sqlId, Map<String, String> map)
  {
    String sql = getSql(sqlFile, clazz, sqlId);
    Set set = map.keySet();
    Iterator it = set.iterator();
    String key = null;
    while (it.hasNext())
    {
      key = (String)it.next();
      sql = sql.replaceAll(key, (String)map.get(key));
    }
    return sql;
  }

  public  String getPageSql(String sqlFile, Class<?> clazz, String sqlId, int pageNumber, int pageSize)
  {
    String sql = getSql(sqlFile, clazz, sqlId);
    String sqlType = Read.getMsg("system.database.type");
    if ("mysql".equals(sqlType))
    {
      sql = sql + " limit " + (pageNumber - 1) * pageSize + "," + pageSize;
    } else if (!"sqlserver".equals(sqlType))
    {
      if ("oracle".equals(sqlType))
      {
        sql = "SELECT * FROM (SELECT A.*, ROWNUM RN FROM (" + sql + ") A WHERE ROWNUM <= " + pageNumber * pageSize + ") WHERE RN >= " + (
          (pageNumber - 1) * pageSize + 1);
      }
    }
    return sql;
  }

  public  String getPageSqlForSql(String sql, int pageNumber, int pageSize)
  {
    String sqlType = Read.getMsg("system.database.type");
    if ("mysql".equals(sqlType))
    {
      sql = sql + " limit " + (pageNumber - 1) * pageSize + "," + pageSize;
    } else if (!"sqlserver".equals(sqlType))
    {
      if ("oracle".equals(sqlType))
      {
        sql = "SELECT * FROM (SELECT A.*, ROWNUM RN FROM (" + sql + ") A WHERE ROWNUM <= " + pageNumber * pageSize + ") WHERE RN >= " + (
          (pageNumber - 1) * pageSize + 1);
      }
    }
    return sql;
  }
}