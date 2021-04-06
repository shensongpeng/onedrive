package ink.songsong.onedrive.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "onedrive")
@Data
public class OneDriveProperties {
    private String client_id;
    private String client_secret;
    private String redirect_uri;
    private String api_url;
    private String oauth_url;
    private List<String> scope;
}
