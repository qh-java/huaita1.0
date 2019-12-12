package com.huaita.springcloudssoserver.ds.service;

import com.huaita.springcloudssoserver.ds.dao.IDao;
import com.huaita.springcloudssoserver.ds.sql.SqlCacheHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service("baseService")
public class BaseService
{

  @Autowired
  protected IDao dao;
  private String sqlFile;

  @Autowired
  private SqlCacheHelper sqlCacheHelper;

  protected BaseService()
  {
  }

  protected BaseService(String sqlFile)
  {
    this.sqlFile = sqlFile;
  }

  protected int queryTableRecordCount(String tableName)
  {
    return this.dao.findForInt("select count(0) from " + tableName);
  }

  protected int deleteRecord(String tableName, String field, String value)
  {
    return this.dao.delete("delete from " + tableName + " where " + field + "=?", value);
  }

  protected String getSql(String sqlId)
  {
    return sqlCacheHelper.getSql(this.sqlFile, BaseService.class, sqlId);
  }

  public String getSql(String sqlId, Map<String, String> replaceMap)
  {
    return sqlCacheHelper.getSql(this.sqlFile, BaseService.class, sqlId, replaceMap);
  }

  protected String getPageSql(String sqlId, int pageNumber, int pageSize)
  {
    return sqlCacheHelper.getPageSql(this.sqlFile, BaseService.class, sqlId, pageNumber, pageSize);
  }

  public String getPageSqlForSql(String sql, int pageNumber, int pageSize)
  {
    return sqlCacheHelper.getPageSqlForSql(sql, pageNumber, pageSize);
  }
}