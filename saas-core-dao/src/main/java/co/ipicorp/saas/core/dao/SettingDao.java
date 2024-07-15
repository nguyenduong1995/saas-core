/**
 * SettingDao.java
 * @copyright  Copyright © 2020 Hieu Micro
 * @author     thanh
 * @version    1.0.0
 */
package co.ipicorp.saas.core.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import grass.micro.apps.dao.base.PersistentCrudRepository;
import co.ipicorp.saas.core.model.Setting;

/**
 * SettingDao.
 * <<< Detail note.
 * @author nt.duong
 * @access public
 */
public interface SettingDao extends PersistentCrudRepository<Setting, Integer>, SettingDaoCustomMethods {
    @Override
    @Query("SELECT st FROM Setting st WHERE st.status = grass.micro.apps.model.base.Status.ACTIVE")
    Iterable<Setting> findAllActivated();
    
    @Override
    @Query("SELECT st FROM Setting st WHERE st.status != grass.micro.apps.model.base.Status.DELETED")
    Iterable<Setting> findAllAvailable();
    
    @Query("SELECT st FROM Setting st WHERE st.key = :key AND st.status = grass.micro.apps.model.base.Status.ACTIVE")
    Setting findByKey(@Param("key") String key);

}
