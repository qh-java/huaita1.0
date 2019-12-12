package com.huaita.springcloudssoserver.ds.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.core.support.AbstractLobStreamingResultSetExtractor;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Repository
public class DBUtil
        implements IDao {

    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    final LobHandler lobHandler = new DefaultLobHandler();

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int add(String sql, Object[] params) {
        return this.jdbcTemplate.update(sql, params);
    }

    public int update(String sql, Object[] params) {
        return this.jdbcTemplate.update(sql, params);
    }

    public int update(String sql) {
        return this.jdbcTemplate.update(sql);
    }

    public int delete(String sql, String id) {
        return this.jdbcTemplate.update(sql, new Object[]{id});
    }

    public SqlRowSet find(String sql, Object[] params) {
        return this.jdbcTemplate.queryForRowSet(sql, params);
    }

    public SqlRowSet find(String sql) {
        return this.jdbcTemplate.queryForRowSet(sql);
    }

    public int findForInt(String sql, Object[] params) {
        return ((Integer) this.jdbcTemplate.queryForObject(sql, params, Integer.class)).intValue();
    }

    public int findForInt(String sql) {
        return ((Integer) this.jdbcTemplate.queryForObject(sql, Integer.class)).intValue();
    }

    public int[] batchUpdate(String sql, final List<Map<String, String>> params) {
        return this.jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int rowNum)
                    throws SQLException {
                Map userMap = (Map) params.get(rowNum);
                Iterator it = userMap.keySet().iterator();
                while (it.hasNext()) {
                    String key = (String) it.next();
                    ps.setString(Integer.parseInt(key), (String) userMap.get(key));
                }
            }

            public int getBatchSize() {
                return params.size();
            }
        });
    }

    public void batchUpdateByObject(String sql, List<Object[]> params) {
        this.jdbcTemplate.batchUpdate(sql, params);
    }

    public List<byte[]> findBlobs(String sql, Object[] params, final String blobField) {
        final List result = new ArrayList();
        this.jdbcTemplate.query(sql, params, new AbstractLobStreamingResultSetExtractor() {
            protected void streamData(ResultSet rs)
                    throws SQLException, IOException, DataAccessException {
                result.add(DBUtil.this.lobHandler.getBlobAsBytes(rs, blobField));
            }
        });
        return result;
    }

    public List<String> findClob(String sql, Object[] params, final String clobFiled) {
        final List result = new ArrayList();
        this.jdbcTemplate.query(sql, params, new AbstractLobStreamingResultSetExtractor() {
            protected void streamData(ResultSet rs)
                    throws SQLException, IOException, DataAccessException {
                result.add(DBUtil.this.lobHandler.getClobAsString(rs, clobFiled));
            }
        });
        return result;
    }

    public void updateBlob(String sql, final byte[] content, final String id) {
        this.jdbcTemplate.execute(sql, new AbstractLobCreatingPreparedStatementCallback(this.lobHandler) {
            protected void setValues(PreparedStatement pstmt, LobCreator lobCreator)
                    throws SQLException, DataAccessException {
                lobCreator.setBlobAsBytes(pstmt, 1, content);
                pstmt.setString(2, id);
            }
        });
    }

    public void updateWithBlob(String sql, final Object[] params) {
        this.jdbcTemplate.execute(sql, new AbstractLobCreatingPreparedStatementCallback(this.lobHandler) {
            protected void setValues(PreparedStatement pstmt, LobCreator lobCreator)
                    throws SQLException, DataAccessException {
                for (int i = 0; i < params.length; i++) {
                    if ((params[i] instanceof byte[])) {
                        pstmt.setBytes(i + 1, (byte[]) params[i]);
                    } else if ((params[i] instanceof Integer)) {
                        pstmt.setInt(i + 1, ((Integer) params[i]).intValue());
                    } else
                        pstmt.setString(i + 1, (String) params[i]);
                }
            }
        });
    }
}