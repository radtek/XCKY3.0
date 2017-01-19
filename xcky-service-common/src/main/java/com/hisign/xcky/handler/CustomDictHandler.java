/**
 * 
 */
package com.hisign.xcky.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author chailiangzhi
 * @date 2016-12-22
 * 
 */
public class CustomDictHandler extends BaseTypeHandler<String> {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	/* (non-Javadoc)
	 * @see org.apache.ibatis.type.BaseTypeHandler#setNonNullParameter(java.sql.PreparedStatement, int, java.lang.Object, org.apache.ibatis.type.JdbcType)
	 */
	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType)
			throws SQLException {
		ps.setString(i, parameter);

	}

	/* (non-Javadoc)
	 * @see org.apache.ibatis.type.BaseTypeHandler#getNullableResult(java.sql.ResultSet, java.lang.String)
	 */
	@Override
	public String getNullableResult(ResultSet rs, String columnName) throws SQLException {
		logger.info("1");
		String str = rs.getString(columnName);
	    return str+"名称";
	}

	/* (non-Javadoc)
	 * @see org.apache.ibatis.type.BaseTypeHandler#getNullableResult(java.sql.ResultSet, int)
	 */
	@Override
	public String getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		logger.info("2");
		String str = rs.getString(columnIndex);
	    return str+"名称2";
	}

	/* (non-Javadoc)
	 * @see org.apache.ibatis.type.BaseTypeHandler#getNullableResult(java.sql.CallableStatement, int)
	 */
	@Override
	public String getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		logger.info("3");
		String str = cs.getString(columnIndex);
	    return str+"名称3";
	}

}
