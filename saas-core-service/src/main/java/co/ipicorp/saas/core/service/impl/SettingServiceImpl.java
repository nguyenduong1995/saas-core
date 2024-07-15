/**
 * SettingServiceImpl.java
 * @copyright  Copyright © 2020 Hieu Micro
 * @author     thanh
 * @version    1.0.0
 */
package co.ipicorp.saas.core.service.impl;

import co.ipicorp.saas.core.dao.SettingDao;
import co.ipicorp.saas.core.model.Setting;
import co.ipicorp.saas.core.service.SettingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import grass.micro.apps.model.dto.SearchCondition;
import grass.micro.apps.service.exception.ServiceException;
import grass.micro.apps.service.impl.GenericServiceImpl;

/**
 * SettingServiceImpl.
 * <<< Detail note.
 * @author thanh
 * @access public
 */
@Service
public class SettingServiceImpl extends GenericServiceImpl<Setting, Integer> implements SettingService {
    @Autowired
    private SettingDao settingDao;
    
    @Override
    public CrudRepository<Setting, Integer> getDao() {
        return this.settingDao;
    }

    @Override
    public List<Setting> search(SearchCondition condition) throws ServiceException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Setting findByKey(String key) {
        return this.settingDao.findByKey(key);
    }

    @Override
    public Setting save(Setting setting) {
        return this.settingDao.save(setting);
    }

	@Override
	public Iterable<Setting> saveAll(List<Setting> settings) {
		return this.settingDao.saveAll(settings);
	}

	@Override
	public Iterable<Setting> getAllById(List<Integer> ids) {
		return this.settingDao.findAllById(ids);
	}

}
