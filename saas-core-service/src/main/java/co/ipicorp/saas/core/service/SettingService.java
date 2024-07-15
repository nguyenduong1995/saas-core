/**
 * SettingService.java
 * @copyright  Copyright © 2020 Hieu Micro
 * @author     thanh
 * @version    1.0.0
 */
package co.ipicorp.saas.core.service;

import java.util.List;

import co.ipicorp.saas.core.model.Setting;
import grass.micro.apps.service.GenericService;

/**
 * SettingService.
 * <<< Detail note.
 * @author thanh
 * @access public
 */
public interface SettingService extends GenericService<Setting, Integer> {

    Setting findByKey(String key);

    Setting save(Setting setting);
    
    Iterable<Setting> saveAll (List<Setting> settings);
    
    Iterable<Setting> getAllById (List<Integer> ids);

}
