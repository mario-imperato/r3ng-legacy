/*
 *    Copyright 2009-2012 The MyBatis Team
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.r3.db.system.transaction;

import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Stack;

import org.apache.ibatis.executor.BatchResult;
import org.apache.ibatis.reflection.ExceptionUtil;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionException;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.TransactionIsolationLevel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SqlManagedSessionManager implements SqlSessionFactory, SqlSession
{
	private static Logger logger = LoggerFactory.getLogger(SqlManagedSessionManager.class);
	
	private final SqlSessionFactory sqlSessionFactory;
	private final SqlSession sqlSessionProxy;

	private static ThreadLocal<Stack<SqlSession>> localSqlSession = new ThreadLocal<Stack<SqlSession>>();

	public static SqlManagedSessionManager newInstance(Reader reader)
	{
		return new SqlManagedSessionManager(new SqlSessionFactoryBuilder().build(reader, null, null));
	}

	public static SqlManagedSessionManager newInstance(Reader reader, String environment)
	{
		return new SqlManagedSessionManager(new SqlSessionFactoryBuilder().build(reader, environment, null));
	}

	public static SqlManagedSessionManager newInstance(Reader reader, Properties properties)
	{
		return new SqlManagedSessionManager(new SqlSessionFactoryBuilder().build(reader, null, properties));
	}

	public static SqlManagedSessionManager newInstance(InputStream inputStream)
	{
		return new SqlManagedSessionManager(new SqlSessionFactoryBuilder().build(inputStream, null, null));
	}

	public static SqlManagedSessionManager newInstance(InputStream inputStream, String environment)
	{
		return new SqlManagedSessionManager(new SqlSessionFactoryBuilder().build(inputStream, environment, null));
	}

	public static SqlManagedSessionManager newInstance(InputStream inputStream, Properties properties)
	{
		return new SqlManagedSessionManager(new SqlSessionFactoryBuilder().build(inputStream, null, properties));
	}

	public static SqlManagedSessionManager newInstance(SqlSessionFactory sqlSessionFactory)
	{
		return new SqlManagedSessionManager(sqlSessionFactory);
	}

	private SqlManagedSessionManager(SqlSessionFactory sqlSessionFactory)
	{
		this.sqlSessionFactory = sqlSessionFactory;
		this.sqlSessionProxy = (SqlSession) Proxy.newProxyInstance(SqlSessionFactory.class.getClassLoader(),
						new Class[] { SqlSession.class }, new SqlSessionInterceptor());
	}

	public void bindManagedSession(SqlSession aSession) throws IllegalStateException
	{
		logger.trace("Binding Managed Session" + aSession);
		Stack<SqlSession> map = localSqlSession.get();
		// set ThreadLocal Map if none found
		if (map == null)
		{
			map = new Stack<SqlSession>();
			localSqlSession.set(map);
		}
		map.push(aSession);
	}

	private SqlSession unbindManagedSession()
	{		
		SqlSession value = null;
		Stack<SqlSession> map = localSqlSession.get();
		if (map != null)
		{
		    value = map.pop();	
		}
		
		logger.trace("UN-Binding Managed Session: " + value);
		
		// Remove entire ThreadLocal if empty...
		if (map != null && map.isEmpty())
		{
			logger.trace("UN-Binding Managed Session: remove threadLocal");
			localSqlSession.remove();
		}
		
		return value;
	}

	public SqlSession currentManagedSession() throws IllegalStateException
	{	
		SqlSession value = null;
		Stack<SqlSession> map = localSqlSession.get();
		// set ThreadLocal Map if none found
		if (map != null)
		{
            value = map.peek();
		}
		
		logger.trace("Fetching Managed Session" + value);
		return value;
	}

	public void startManagedSession()
	{
		this.bindManagedSession(openSession());
	}

	public void startManagedSession(boolean autoCommit)
	{
		this.bindManagedSession(openSession(autoCommit));
	}

	public void startManagedSession(Connection connection)
	{
		this.bindManagedSession(openSession(connection));
	}

	public void startManagedSession(TransactionIsolationLevel level)
	{
		this.bindManagedSession(openSession(level));
	}

	public void startManagedSession(ExecutorType execType)
	{
		this.bindManagedSession(openSession(execType));
	}

	public void startManagedSession(ExecutorType execType, boolean autoCommit)
	{
		this.bindManagedSession(openSession(execType, autoCommit));
	}

	public void startManagedSession(ExecutorType execType, TransactionIsolationLevel level)
	{
		this.bindManagedSession(openSession(execType, level));
	}

	public void startManagedSession(ExecutorType execType, Connection connection)
	{
		this.bindManagedSession(openSession(execType, connection));
	}

	public boolean isManagedSessionStarted()
	{
		boolean rc = localSqlSession.get() != null;
		logger.trace("Checking For Managed Session: " + rc);
		return rc;
	}

	public SqlSession openSession()
	{
		return sqlSessionFactory.openSession();
	}

	public SqlSession openSession(boolean autoCommit)
	{
		return sqlSessionFactory.openSession(autoCommit);
	}

	public SqlSession openSession(Connection connection)
	{
		return sqlSessionFactory.openSession(connection);
	}

	public SqlSession openSession(TransactionIsolationLevel level)
	{
		return sqlSessionFactory.openSession(level);
	}

	public SqlSession openSession(ExecutorType execType)
	{
		return sqlSessionFactory.openSession(execType);
	}

	public SqlSession openSession(ExecutorType execType, boolean autoCommit)
	{
		return sqlSessionFactory.openSession(execType, autoCommit);
	}

	public SqlSession openSession(ExecutorType execType, TransactionIsolationLevel level)
	{
		return sqlSessionFactory.openSession(execType, level);
	}

	public SqlSession openSession(ExecutorType execType, Connection connection)
	{
		return sqlSessionFactory.openSession(execType, connection);
	}

	public Configuration getConfiguration()
	{
		return sqlSessionFactory.getConfiguration();
	}

	public <T> T selectOne(String statement)
	{
		return sqlSessionProxy.<T> selectOne(statement);
	}

	public <T> T selectOne(String statement, Object parameter)
	{
		return sqlSessionProxy.<T> selectOne(statement, parameter);
	}

	public <K, V> Map<K, V> selectMap(String statement, String mapKey)
	{
		return sqlSessionProxy.<K, V> selectMap(statement, mapKey);
	}

	public <K, V> Map<K, V> selectMap(String statement, Object parameter, String mapKey)
	{
		return sqlSessionProxy.<K, V> selectMap(statement, parameter, mapKey);
	}

	public <K, V> Map<K, V> selectMap(String statement, Object parameter, String mapKey, RowBounds rowBounds)
	{
		return sqlSessionProxy.<K, V> selectMap(statement, parameter, mapKey, rowBounds);
	}

	public <E> List<E> selectList(String statement)
	{
		return sqlSessionProxy.<E> selectList(statement);
	}

	public <E> List<E> selectList(String statement, Object parameter)
	{
		return sqlSessionProxy.<E> selectList(statement, parameter);
	}

	public <E> List<E> selectList(String statement, Object parameter, RowBounds rowBounds)
	{
		return sqlSessionProxy.<E> selectList(statement, parameter, rowBounds);
	}

	public void select(String statement, ResultHandler handler)
	{
		sqlSessionProxy.select(statement, handler);
	}

	public void select(String statement, Object parameter, ResultHandler handler)
	{
		sqlSessionProxy.select(statement, parameter, handler);
	}

	public void select(String statement, Object parameter, RowBounds rowBounds, ResultHandler handler)
	{
		sqlSessionProxy.select(statement, parameter, rowBounds, handler);
	}

	public int insert(String statement)
	{
		return sqlSessionProxy.insert(statement);
	}

	public int insert(String statement, Object parameter)
	{
		return sqlSessionProxy.insert(statement, parameter);
	}

	public int update(String statement)
	{
		return sqlSessionProxy.update(statement);
	}

	public int update(String statement, Object parameter)
	{
		return sqlSessionProxy.update(statement, parameter);
	}

	public int delete(String statement)
	{
		return sqlSessionProxy.delete(statement);
	}

	public int delete(String statement, Object parameter)
	{
		return sqlSessionProxy.delete(statement, parameter);
	}

	public <T> T getMapper(Class<T> type)
	{
		return getConfiguration().getMapper(type, this);
	}

	public Connection getConnection()
	{
		final SqlSession sqlSession = currentManagedSession();
		if (sqlSession == null)
			throw new SqlSessionException("Error:  Cannot get connection.  No managed session is started.");
		return sqlSession.getConnection();
	}

	public void clearCache()
	{
		final SqlSession sqlSession = currentManagedSession();
		if (sqlSession == null)
			throw new SqlSessionException("Error:  Cannot clear the cache.  No managed session is started.");
		sqlSession.clearCache();
	}

	public void commit()
	{
		final SqlSession sqlSession = currentManagedSession();
		if (sqlSession == null)
			throw new SqlSessionException("Error:  Cannot commit.  No managed session is started.");
		sqlSession.commit();
	}

	public void commit(boolean force)
	{
		final SqlSession sqlSession = currentManagedSession();
		if (sqlSession == null)
			throw new SqlSessionException("Error:  Cannot commit.  No managed session is started.");
		sqlSession.commit(force);
	}

	public void rollback()
	{
		final SqlSession sqlSession = currentManagedSession();
		if (sqlSession == null)
			throw new SqlSessionException("Error:  Cannot rollback.  No managed session is started.");
		sqlSession.rollback();
	}

	public void rollback(boolean force)
	{
		final SqlSession sqlSession = currentManagedSession();
		if (sqlSession == null)
			throw new SqlSessionException("Error:  Cannot rollback.  No managed session is started.");
		sqlSession.rollback(force);
	}

	public List<BatchResult> flushStatements()
	{
		final SqlSession sqlSession = currentManagedSession();
		if (sqlSession == null)
			throw new SqlSessionException("Error:  Cannot rollback.  No managed session is started.");
		return sqlSession.flushStatements();
	}

	public void close()
	{
		final SqlSession sqlSession = currentManagedSession();
		if (sqlSession == null)
			throw new SqlSessionException("Error:  Cannot close.  No managed session is started.");
		try
		{
			sqlSession.close();
		}
		finally
		{
			unbindManagedSession();
		}
	}

	private class SqlSessionInterceptor implements InvocationHandler
	{
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
		{
			final SqlSession sqlSession = SqlManagedSessionManager.this.currentManagedSession();
			logger.trace("Proxyng Managed Session" + sqlSession);
			
			if (sqlSession != null)
			{
				try
				{
					return method.invoke(sqlSession, args);
				}
				catch (Throwable t)
				{
					throw ExceptionUtil.unwrapThrowable(t);
				}
			}
			else
			{
				final SqlSession autoSqlSession = openSession();
				try
				{
					final Object result = method.invoke(autoSqlSession, args);
					autoSqlSession.commit();
					return result;
				}
				catch (Throwable t)
				{
					autoSqlSession.rollback();
					throw ExceptionUtil.unwrapThrowable(t);
				}
				finally
				{
					autoSqlSession.close();
				}
			}
		}
	}

}
