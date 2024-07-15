package co.ipicorp.saas.core.dao;

import java.util.List;

import co.ipicorp.saas.core.model.User;
import grass.micro.apps.model.dto.SearchCondition;

public interface UserDaoCustomMethods {
    List<User> search(SearchCondition condition);
}
