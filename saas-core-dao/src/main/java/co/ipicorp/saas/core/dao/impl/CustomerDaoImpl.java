package co.ipicorp.saas.core.dao.impl;

import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.apache.ibatis.jdbc.ScriptRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import co.ipicorp.saas.core.dao.CustomerDaoCustomMethods;
import co.ipicorp.saas.core.model.Customer;
import co.ipicorp.saas.core.model.dto.CustomerSearchCondition;
import grass.micro.apps.model.dto.SearchCondition;

/**
 * 
 * @author hienlt1
 *
 */
@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDaoCustomMethods {
	
	@Autowired
    @Qualifier("authEntityManager")
    private EntityManager entityManager;
	
	@Autowired
    @Qualifier("authDataSource")
    private DataSource dataSource;
	
	public String report() {
		return "TEST";
	}
	
	@Override
	public List<Customer> search(SearchCondition search) {
		CustomerSearchCondition customerSearch = (CustomerSearchCondition) search;
		String sql = "SELECT c FROM Customer c WHERE c.status != 9 \n";
		if (customerSearch.isEnableName()) {
            sql += "AND c.shortname LIKE :shortname \n";
        }
		if (customerSearch.isEnableCustomerType()) {
            sql += "AND c.customerType = :customerType \n";
        }
		if (customerSearch.isEnableEmail()) {
            sql += "AND c.technicalEmail LIKE :technicalEmail \n";
        }
		if (customerSearch.isEnableCreateDate()) {
            sql += "AND CAST(c.createdDate as LocalDate) BETWEEN :fromDate AND :toDate \n";
        }
		TypedQuery<Customer> query = entityManager.createQuery(sql, Customer.class);
		
		if (customerSearch.isEnableName()) {
            query.setParameter("shortname", "%" + customerSearch.getName() + "%");
        }
		
		if (customerSearch.isEnableCustomerType()) {
			query.setParameter("customerType", customerSearch.getCustomerType());
		}
		if (customerSearch.isEnableEmail()) {
			query.setParameter("technicalEmail", "%" + customerSearch.getEmail() + "%");
        }
		if (customerSearch.isEnableCreateDate()) {
			query.setParameter("fromDate", customerSearch.getFromDate());
			query.setParameter("toDate", customerSearch.getToDate());
        }
		return (List<Customer>) query.getResultList();
	}

	@Override
	public void createDatabase(String dbName, Reader dumpFile) {
		Connection conn = null;
		Statement statement = null;
		try {
			conn = dataSource.getConnection();
			statement = conn.createStatement();
			String sql = "CREATE DATABASE IF NOT EXISTS " + dbName;
			statement.execute(sql);
			String sqlUseDB = "USE " + dbName;
			statement.execute(sqlUseDB);
			
			ScriptRunner runner = new ScriptRunner(conn);
			runner.setAutoCommit(true);
			runner.setStopOnError(true);
			runner.runScript(dumpFile);
			runner.closeConnection();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
	
}
