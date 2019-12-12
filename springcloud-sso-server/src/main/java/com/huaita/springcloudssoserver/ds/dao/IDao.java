package com.huaita.springcloudssoserver.ds.dao;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.List;
import java.util.Map;

public abstract interface IDao {
    public abstract int add(String paramString, Object[] paramArrayOfObject);

    public abstract int delete(String paramString1, String paramString2);

    public abstract int update(String paramString, Object[] paramArrayOfObject);

    public abstract int update(String paramString);

    public abstract SqlRowSet find(String paramString, Object[] paramArrayOfObject);

    public abstract SqlRowSet find(String paramString);

    public abstract int findForInt(String paramString, Object[] paramArrayOfObject);

    public abstract int findForInt(String paramString);

    public abstract int[] batchUpdate(String paramString, List<Map<String, String>> paramList);

    public abstract void batchUpdateByObject(String paramString, List<Object[]> paramList);

    public abstract List<byte[]> findBlobs(String paramString1, Object[] paramArrayOfObject, String paramString2);

    public abstract void updateBlob(String paramString1, byte[] paramArrayOfByte, String paramString2);

    public abstract List<String> findClob(String paramString1, Object[] paramArrayOfObject, String paramString2);

    public abstract void updateWithBlob(String paramString, Object[] paramArrayOfObject);
}