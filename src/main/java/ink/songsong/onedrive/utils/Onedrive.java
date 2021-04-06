package ink.songsong.onedrive.utils;

import lombok.Data;

@Data
public class Onedrive {
    private String client_id;
    private String client_secret;
    private String redirect_uri;
    private String api_url ;
    private String oauth_url;
    private String tenantId;
    private String objectId;


}
