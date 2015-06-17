package io.pivotal.spring.cloud.service.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.springframework.cloud.service.AbstractServiceConnectorCreator;
import org.springframework.cloud.service.ServiceConnectorConfig;
import io.pivotal.spring.cloud.service.common.HadoopServiceInfo;

/**
 * 
 * @author Ramnivas Laddad
 *
 */
public class HadoopConfigurationCreator  extends AbstractServiceConnectorCreator<Configuration, HadoopServiceInfo> {

    @Override
    public Configuration create(HadoopServiceInfo hadoopServiceInfo, ServiceConnectorConfig serviceConnectorConfig) {
        Configuration configuration = new Configuration();
        configuration.set("fs.defaultFS", hadoopServiceInfo.getDefaultFS());
        configuration.set("yarn.resourcemanager.address", hadoopServiceInfo.getYarnResourceManagerAddress());
        configuration.set("yarn.resourcemanager.scheduler.address", hadoopServiceInfo.getYarnResourceManagerSchedulerAddress());

        return configuration;
    }


}
