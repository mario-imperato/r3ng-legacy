package org.r3.db.system.transaction;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.TransactionIsolationLevel;
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class JDBCMySQLTransactionFactory extends JdbcTransactionFactory
{

	public JDBCMySQLTransactionFactory()
	{
	}

	public Transaction newTransaction(Connection conn)
	{
		return new JDBCMySQLTransaction(conn);
	}

	public Transaction newTransaction(DataSource ds, TransactionIsolationLevel level, boolean autoCommit)
	{				
		return new JDBCMySQLTransaction(ds, level, autoCommit);
	}
}
