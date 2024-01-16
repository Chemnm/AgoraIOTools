package io.agora.sample;

import io.agora.media.RtcTokenBuilder2;
import io.agora.media.RtcTokenBuilder2.Role;

public class RtcTokenBuilder2Sample {
    // Need to set environment variable AGORA_APP_ID
    static String appId = System.getenv("AGORA_APP_ID");
    // Need to set environment variable AGORA_APP_CERTIFICATE
    static String appCertificate = System.getenv("AGORA_APP_CERTIFICATE");

    static String channelName = "7d72365eb983485397e3e3f9d460bdda";
    static String account = "2082341273";
    static int uid = 2082341273;
    static int tokenExpirationInSeconds = 3600;
    static int privilegeExpirationInSeconds = 3600;
    static int joinChannelPrivilegeExpireInSeconds = 3600;
    static int pubAudioPrivilegeExpireInSeconds = 3600;
    static int pubVideoPrivilegeExpireInSeconds = 3600;
    static int pubDataStreamPrivilegeExpireInSeconds = 3600;

    public static void main(String[] args) {
        RtcTokenBuilder2 token = new RtcTokenBuilder2();
        String result = token.buildTokenWithUid(appId, appCertificate, channelName, uid, Role.ROLE_SUBSCRIBER,
                tokenExpirationInSeconds, privilegeExpirationInSeconds);
        System.out.println("Token with uid: " + result);

        result = token.buildTokenWithUserAccount(appId, appCertificate, channelName, account,
                Role.ROLE_SUBSCRIBER,
                tokenExpirationInSeconds, privilegeExpirationInSeconds);
        System.out.println("Token with account: " + result);

        result = token.buildTokenWithUid(appId, appCertificate, channelName, uid, tokenExpirationInSeconds,
                joinChannelPrivilegeExpireInSeconds, pubAudioPrivilegeExpireInSeconds,
                pubVideoPrivilegeExpireInSeconds,
                pubDataStreamPrivilegeExpireInSeconds);
        System.out.println("Token with uid and privilege: " + result);

        result = token.buildTokenWithUserAccount(appId, appCertificate, channelName, account,
                tokenExpirationInSeconds,
                joinChannelPrivilegeExpireInSeconds, pubAudioPrivilegeExpireInSeconds,
                pubVideoPrivilegeExpireInSeconds, pubDataStreamPrivilegeExpireInSeconds);
        System.out.println("Token with account and privilege: " + result);
    }
}
