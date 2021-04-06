package ink.songsong.onedrive.configuration;


import ink.songsong.onedrive.utils.Onedrive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@EnableConfigurationProperties(OneDriveProperties.class)
@Configuration
public class OneDriveConfiguration {
    @Autowired
    private OneDriveProperties oneDriveProperties;

    @Bean
    @ConfigurationProperties(prefix = "spring.oneidrive")
    public Onedrive onedrive(){
        Onedrive onedrive = new Onedrive();
        return onedrive;
    }


}
