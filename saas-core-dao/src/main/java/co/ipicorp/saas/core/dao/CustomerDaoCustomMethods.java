package co.ipicorp.saas.core.dao;

import java.io.Reader;
import java.util.List;

import co.ipicorp.saas.core.model.Customer;
import grass.micro.apps.model.dto.SearchCondition;

public interface CustomerDaoCustomMethods {

	List<Customer> search(SearchCondition condition);

	void createDatabase(String dbName, Reader dumpFile);
}
