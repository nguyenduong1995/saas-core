package co.ipicorp.saas.core.dao;

import java.util.List;

import co.ipicorp.saas.core.model.Role;
import grass.micro.apps.model.dto.SearchCondition;

public interface RoleDaoCustomMethods {
    List<Role> search(SearchCondition condition);
}
