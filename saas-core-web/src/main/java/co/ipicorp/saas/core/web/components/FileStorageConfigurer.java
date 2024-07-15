/**
 * FileStorageConfiguration.java
 * @copyright  Copyright © 2020 Hieu Micro
 * @author     thuy.nguyen
 * @version    1.0.0
 */
package co.ipicorp.saas.core.web.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

import grass.micro.apps.component.SystemConfiguration;

/**
 * FileStorageConfiguration. <<< Detail note.
 * 
 * @author thuy.nguyen
 * @access public
 */
@Configuration
public class FileStorageConfigurer {
    
    @Autowired
    private SystemConfiguration systemConfiguration;

    private String server;
    private Integer port;
    private String user;
    private String password;
    private String uploadDir;
    
    @PostConstruct
    public void init() {
        setServer(this.systemConfiguration.getProperty("ftp.server"));
        setPort(this.systemConfiguration.getInt("ftp.port",21));
        setUser(this.systemConfiguration.getProperty("ftp.user"));
        setPassword(this.systemConfiguration.getProperty("ftp.password"));
        setUploadDir(this.systemConfiguration.getProperty("ftp.uploadDir"));
    }
    
    /**
     * get value of <b>systemConfiguration</b>.
     * @return the systemConfiguration
     */
    public SystemConfiguration getSystemConfiguration() {
        return systemConfiguration;
    }

    /**
     * Set value to <b>systemConfiguration</b>.
     * @param systemConfiguration the systemConfiguration to set
     */
    public void setSystemConfiguration(SystemConfiguration systemConfiguration) {
        this.systemConfiguration = systemConfiguration;
    }

    /**
     * get value of <b>server</b>.
     * @return the server
     */
    public String getServer() {
        return server;
    }

    /**
     * Set value to <b>server</b>.
     * @param server the server to set
     */
    public void setServer(String server) {
        this.server = server;
    }

    /**
     * get value of <b>port</b>.
     * @return the port
     */
    public Integer getPort() {
        return port;
    }

    /**
     * Set value to <b>port</b>.
     * @param port the port to set
     */
    public void setPort(Integer port) {
        this.port = port;
    }

    /**
     * get value of <b>user</b>.
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * Set value to <b>user</b>.
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * get value of <b>password</b>.
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set value to <b>password</b>.
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public String getUploadDir() {
        return uploadDir;
    }

    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }
}
