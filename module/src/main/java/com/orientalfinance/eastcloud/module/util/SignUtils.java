package com.orientalfinance.eastcloud.module.util;



import android.util.Base64;

import com.orientalfinance.eastcloud.module.util.Base64Util;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * 阿里签名方法
 */
public class SignUtils {

//    private static final String ALGORITHM = "RSA";

    private static final String SIGN_ALGORITHMS = "SHA1WithRSA";

    private static final String DEFAULT_CHARSET = "UTF-8";

    // 商户的私钥
    public static String key = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAODxerJ4j1ASi69i24Fb8zgKnAvVASK2wRNagw/3BuyFV0Lmepm0UOLZC0WR/n7gL0ShpFsdeAqQ+K1IvIATPUcAJCkYOxF+I8lRcLGVlOvPxIUV6qo40OcKDWLe5haxUr8yv0fFDuiRvvCMSgtTbgKbc9PEV/sZbJAprRu2IdO1AgMBAAECgYAaygd/y8XdlmfWWmKj9ExyBylwa0y4UqWJ5YSoWRYVAwhSalp9hbEAYzLpdSqm95IJjWqig07xizRihsAUTLZGTiQUlBgzEw7/jpfD3hRI3cfgcH61k257tUuobm/+XC6nZxh7GWQ1FMzvEwid9HscDtaXus3WvRGPcDwHGNHM/QJBAP9kIxOLXwyR83/tAe+KK23ccZaqcrO5esw1lkDpXvRDRbC7trv9wrcc9gqAmbYgRXr1lcL4Iqz/p3OGbII9XHsCQQDhesKcEDAGP1MHCFhPBRycykETf+lBdP7Dnry0zTsP2IySlNykdf2kQCyw9nHwcsBw/pnMUaiBq3Dm19LT9RGPAkEAu+qUnKbqUzd5MeHUkMrb1cRkl/Xm3DNYFbZATpbo1VZCix40APNhOJdIusWRVJ8+QJE/luw5p42dSrXYVaSMzQJBALkcu6C8eXDnlBZ192oIXFEsivijTrB6iJ25OFuHEjIUKnQ82lf6tl2eghJWgXxR+UPLAiEH+TtbsLkT/vYcgGkCQQD6URNtCVoiyroBnzzOTK3med5hs3N9lUQwLGNPVYpcJLiV6i0BPBDUDrjo9UM3gxhmOK7o4jc7wfmhcYk6nhIm";
    public static final String ALGORITHM = "RSA";

    public static String sign(String content, String privateKey) {
        try {
            PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64Util.decode(privateKey));
            KeyFactory keyf = KeyFactory.getInstance(ALGORITHM);
            PrivateKey priKey = keyf.generatePrivate(priPKCS8);

            java.security.Signature signature = java.security.Signature.getInstance(SIGN_ALGORITHMS);

            signature.initSign(priKey);
            signature.update(content.getBytes(DEFAULT_CHARSET));

            byte[] signed = signature.sign();
            return Base64.encodeToString(signed,Base64.DEFAULT);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static boolean doCheck(String content, String sign, String publicKey) {

        try {
            KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
            byte[] encodedKey = Base64.decode(publicKey,Base64.DEFAULT);
            PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));
            java.security.Signature signature = java.security.Signature.getInstance(SIGN_ALGORITHMS);

            signature.initVerify(pubKey);

            signature.update(content.getBytes("utf-8"));
            boolean bVerify = signature.verify(Base64.decode(publicKey,Base64.DEFAULT));
            return bVerify;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


    public static void main(String[] args) {
        String content = "aaa";
        System.out.println(sign(content,key));

    }

}
