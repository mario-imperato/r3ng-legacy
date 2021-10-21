package org.r3.db.system.transaction;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.TransactionIsolationLevel;
import org.apache.ibatis.transaction.jdbc.JdbcTransaction;

public class JDBCMySQLTransaction extends JdbcTransaction
{

	public JDBCMySQLTransaction(Connection connection)
	{
		super(connection);
	}

	public JDBCMySQLTransaction(DataSource ds, TransactionIsolationLevel desiredLevel, boolean desiredAutoCommit)
	{
		super(ds, desiredLevel, desiredAutoCommit);
	}

	public void close() throws SQLException
	{
		if (connection != null)
		{
			// System.out.println("Doing the close with rollback!");
			connection.rollback();
		}
		super.close();
	}
}
