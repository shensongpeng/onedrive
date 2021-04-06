package ink.songsong.onedrive.controller;

import com.azure.identity.ClientSecretCredential;
import com.azure.identity.ClientSecretCredentialBuilder;
import com.microsoft.graph.authentication.TokenCredentialAuthProvider;
import ink.songsong.onedrive.configuration.OneDriveProperties;
import ink.songsong.onedrive.utils.Onedrive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("test")
public class TestController {
    @Autowired
    private Onedrive onedrive;

    @Autowired
    private OneDriveProperties oneDriveProperties;

    @RequestMapping("printOneDriveProperties")
    @ResponseBody
    public Onedrive onedrive(){
        System.out.println(oneDriveProperties);
        System.out.println(onedrive);
        return onedrive;
    }

    @GetMapping ("testSuccess")
    public String test(){
        ClientSecretCredential clientSecretCredential = new ClientSecretCredentialBuilder()
                .clientId(oneDriveProperties.getClient_id())
                .clientSecret(oneDriveProperties.getClient_secret())
//                .tenantId(TENANT_GUID)
                .build();
        TokenCredentialAuthProvider tokenCredAuthProvider = new TokenCredentialAuthProvider(oneDriveProperties.getScope(), clientSecretCredential);
        return "success";
    }
    @RequestMapping("testError")
    public String testError(){
        return "error";
    }
}
