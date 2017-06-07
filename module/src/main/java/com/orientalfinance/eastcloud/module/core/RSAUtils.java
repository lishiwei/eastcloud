//package com.orientalfinance.eastcloud.module.core;
//
//
//
//import org.apache.commons.codec.binary.Base64;
//import org.bouncycastle.asn1.ASN1Sequence;
//import org.bouncycastle.asn1.pkcs.RSAPrivateKeyStructure;
//
//import javax.crypto.Cipher;
//import java.io.*;
//import java.math.BigInteger;
//import java.security.*;
//import java.security.interfaces.RSAPrivateKey;
//import java.security.interfaces.RSAPublicKey;
//import java.security.spec.*;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * <p>
// * RSA公钥/私钥/签名工具包
// * </p>
// * <p>
// * 罗纳德·李维斯特（Ron [R]ivest）、阿迪·萨莫尔（Adi [S]hamir）和伦纳德·阿德曼（Leonard [A]dleman）
// * </p>
// * <p>
// * 字符串格式的密钥在未在特殊说明情况下都为BASE64编码格式<br/>
// * 由于非对称加密速度极其缓慢，一般文件不使用它来加密而是使用对称加密，<br/>
// * 非对称加密算法可以用来对对称加密的密钥加密，这样保证密钥的安全也就保证了数据的安全
// * </p>
// *
// * @author
// * @version 1.0
// * @date 2016-3-8
// */
//public class RSAUtils {
//
//    /**
//     * 加密算法RSA
//     */
//    public static final String KEY_ALGORITHM = "RSA";
//
//    /**
//     * 签名算法
//     */
////    public static final String SIGNATURE_ALGORITHM = "MD5withRSA";
//    public static final String SIGNATURE_ALGORITHM = "SHA1WithRSA";
////    public static final String SIGNATURE_ALGORITHM = "SHA256withRSA";
////
//    /**
//     * 获取公钥的key
//     */
//    private static final String PUBLIC_KEY = "RSAPublicKey";
//
//    /**
//     * 获取私钥的key
//     */
//    private static final String PRIVATE_KEY = "RSAPrivateKey";
//
//    /**
//     * RSA最大加密明文大小
//     */
//    private static final int MAX_ENCRYPT_BLOCK = 500;
//
//    /**
//     * RSA最大解密密文大小
//     */
//    private static final int MAX_DECRYPT_BLOCK = 192;
//
//    /**
//     * <p>
//     * 生成密钥对(公钥和私钥)
//     * </p>
//     *
//     * @return
//     * @throws Exception
//     */
//    public static Map<String, Object> genKeyPair() throws Exception {
//        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
//        keyPairGen.initialize(1024);
//        KeyPair keyPair = keyPairGen.generateKeyPair();
//        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
//        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
//        Map<String, Object> keyMap = new HashMap<String, Object>(2);
//        keyMap.put(PUBLIC_KEY, publicKey);
//        keyMap.put(PRIVATE_KEY, privateKey);
//        return keyMap;
//    }
//
//    /**
//     * 使用模和指数生成RSA公钥
//     * 注意：【此代码用了默认补位方式，为RSA/None/PKCS1Padding，不同JDK默认的补位方式可能不同，如Android默认是RSA
//     * /None/NoPadding】
//     *
//     * @param modulus  模
//     * @param exponent 指数
//     * @return
//     */
//    public static RSAPublicKey getPublicKey(String modulus, String exponent) {
//        try {
//            BigInteger b1 = new BigInteger(modulus);
//            BigInteger b2 = new BigInteger(exponent);
//            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
//            RSAPublicKeySpec keySpec = new RSAPublicKeySpec(b1, b2);
//            return (RSAPublicKey) keyFactory.generatePublic(keySpec);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    /**
//     * 使用模和指数生成RSA私钥
//     * 注意：【此代码用了默认补位方式，为RSA/None/PKCS1Padding，不同JDK默认的补位方式可能不同，如Android默认是RSA
//     * /None/NoPadding】
//     *
//     * @param modulus  模
//     * @param exponent 指数
//     * @return
//     */
//    public static RSAPrivateKey getPrivateKey(String modulus, String exponent) {
//        try {
//            BigInteger b1 = new BigInteger(modulus);
//            BigInteger b2 = new BigInteger(exponent);
//            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
//            RSAPrivateKeySpec keySpec = new RSAPrivateKeySpec(b1, b2);
//            return (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//
//    /**
//     * <p>
//     * 用私钥对信息生成数字签名
//     * </p>
//     *
//     * @param data       已加密数据
//     * @param privateKey 私钥(BASE64编码)
//     * @return
//     * @throws Exception
//     */
//    public static String sign(byte[] data, String privateKey) {
//        try {
//            byte[] keyBytes = Base64Util.decode(privateKey);
////            PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
////            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
////            RSAPrivateKey privateK = (RSAPrivateKey) keyFactory.generatePrivate(pkcs8KeySpec);
////        RSAPrivateKey pk = getPrivateKey(privateK.getModulus().toString(),privateK.getPrivateExponent().toString());
//
//
//            RSAPrivateKeyStructure asn1PrivKey = new RSAPrivateKeyStructure((ASN1Sequence) ASN1Sequence.fromByteArray(keyBytes));
//            RSAPrivateKeySpec rsaPrivKeySpec = new RSAPrivateKeySpec(asn1PrivKey.getModulus(), asn1PrivKey.getPrivateExponent());
//            KeyFactory keyFactory= KeyFactory.getInstance(KEY_ALGORITHM);
//            PrivateKey privateK= keyFactory.generatePrivate(rsaPrivKeySpec);
//
//
//            Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
//            signature.initSign(privateK);
//            signature.update(data);
//            return Base64Util.encode(signature.sign());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    /**
//     * <p>
//     * 用私钥对信息生成数字签名 String方式 符合支付宝方式
//     * </p>
//     *
//     * @param data
//     * @param privateKey
//     * @return
//     * @throws Exception
//     */
//    public static String sign(String data, String privateKey){
//        try {
//            return sign(data.getBytes("utf-8"), privateKey);
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    /**
//     * <p>
//     * 校验数字签名
//     * </p>
//     *
//     * @param data      已加密数据
//     * @param publicKey 公钥(BASE64编码)
//     * @param sign      数字签名
//     * @return
//     * @throws Exception
//     */
//    public static boolean verify(byte[] data, String publicKey, String sign)
//            throws Exception {
//        byte[] keyBytes = Base64Util.decode(publicKey);
//        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
//        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
//        PublicKey publicK = keyFactory.generatePublic(keySpec);
//        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
//        signature.initVerify(publicK);
//        signature.update(data);
//        return signature.verify(Base64Util.decode(sign));
//    }
//
//    /**
//     * rsa验签
//     *
//     * @param content 被签名的内容
//     * @param sign 签名后的结果
//     * @param publicKey rsa公钥
//     * @param charset 字符集
//     * @return 验签结果
//     * @throws SignatureException 验签失败，则抛异常
//     */
//    public static boolean doCheck(String content, String sign, String publicKey, String charset) throws SignatureException {
//        try {
//            PublicKey pubKey = getPublicKeyFromX509(KEY_ALGORITHM, new ByteArrayInputStream(publicKey.getBytes()));
//
//            Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
//            signature.initVerify(pubKey);
//            signature.update(getContentBytes(content, charset));
//            return signature.verify(Base64.decodeBase64(sign.getBytes()));
//        } catch (Exception e) {
//            throw new SignatureException("RSA验证签名[content = " + content + "; charset = " + charset
//                    + "; signature = " + sign + "]发生异常!", e);
//        }
//    }
//
//    private static PublicKey getPublicKeyFromX509(String algorithm, InputStream ins) throws NoSuchAlgorithmException {
//        try {
//            KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
//
//            StringWriter writer = new StringWriter();
//            StreamUtil.io(new InputStreamReader(ins), writer);
//            byte[] encodedKey = writer.toString().getBytes();
//
//            // 先base64解码
//            encodedKey = Base64.decodeBase64(encodedKey);
//            return keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));
//        } catch (IOException ex) {
//            // 不可能发生
//        } catch (InvalidKeySpecException ex) {
//            // 不可能发生
//        }
//        return null;
//    }
//
//    private static byte[] getContentBytes(String content, String charset) throws UnsupportedEncodingException {
//        if (StringUtil.isEmpty(charset)) {
//            return content.getBytes();
//        }
//
//        return content.getBytes(charset);
//    }
//
//
//    /**
//     * <P>
//     * 私钥解密
//     * </p>
//     *
//     * @param encryptedData 已加密数据
//     * @param privateKey    私钥(BASE64编码)
//     * @return
//     * @throws Exception
//     */
//    public static byte[] decryptByPrivateKey(byte[] encryptedData, String privateKey)
//            throws Exception {
//        byte[] keyBytes = Base64Util.decode(privateKey);
//        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
//        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
//        Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);
//        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
//        cipher.init(Cipher.DECRYPT_MODE, privateK);
//        int inputLen = encryptedData.length;
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//        int offSet = 0;
//        byte[] cache;
//        int i = 0;
//        // 对数据分段解密
//        while (inputLen - offSet > 0) {
//            if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
//                cache = cipher.doFinal(encryptedData, offSet, MAX_DECRYPT_BLOCK);
//            } else {
//                cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
//            }
//            out.write(cache, 0, cache.length);
//            i++;
//            offSet = i * MAX_DECRYPT_BLOCK;
//        }
//        byte[] decryptedData = out.toByteArray();
//        out.close();
//        return decryptedData;
//    }
//
//    /**
//     * <p>
//     * 公钥解密
//     * </p>
//     *
//     * @param encryptedData 已加密数据
//     * @param publicKey     公钥(BASE64编码)
//     * @return
//     * @throws Exception
//     */
//    public static byte[] decryptByPublicKey(byte[] encryptedData, String publicKey)
//            throws Exception {
//        byte[] keyBytes = Base64Util.decode(publicKey);
//        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
//        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
//        Key publicK = keyFactory.generatePublic(x509KeySpec);
//        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
//        cipher.init(Cipher.DECRYPT_MODE, publicK);
//        int inputLen = encryptedData.length;
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//        int offSet = 0;
//        byte[] cache;
//        int i = 0;
//        // 对数据分段解密
//        while (inputLen - offSet > 0) {
//            if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
//                cache = cipher.doFinal(encryptedData, offSet, MAX_DECRYPT_BLOCK);
//            } else {
//                cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
//            }
//            out.write(cache, 0, cache.length);
//            i++;
//            offSet = i * MAX_DECRYPT_BLOCK;
//        }
//        byte[] decryptedData = out.toByteArray();
//        out.close();
//        return decryptedData;
//    }
//
//    /**
//     * <p>
//     * 公钥加密
//     * </p>
//     *
//     * @param data      源数据
//     * @param publicKey 公钥(BASE64编码)
//     * @return
//     * @throws Exception
//     */
//    public static byte[] encryptByPublicKey(byte[] data, String publicKey)
//            throws Exception {
//        byte[] keyBytes = Base64Util.decode(publicKey);
//        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
//        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
//        Key publicK = keyFactory.generatePublic(x509KeySpec);
//        // 对数据加密
//        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
//        cipher.init(Cipher.ENCRYPT_MODE, publicK);
//        int inputLen = data.length;
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//        int offSet = 0;
//        byte[] cache;
//        int i = 0;
//        // 对数据分段加密
//        while (inputLen - offSet > 0) {
//            if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
//                cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
//            } else {
//                cache = cipher.doFinal(data, offSet, inputLen - offSet);
//            }
//            out.write(cache, 0, cache.length);
//            i++;
//            offSet = i * MAX_ENCRYPT_BLOCK;
//        }
//        byte[] encryptedData = out.toByteArray();
//        out.close();
//        return encryptedData;
//    }
//
//    /**
//     * <p>
//     * 私钥加密
//     * </p>
//     *
//     * @param data       源数据
//     * @param privateKey 私钥(BASE64编码)
//     * @return
//     * @throws Exception
//     */
//    public static byte[] encryptByPrivateKey(byte[] data, String privateKey)
//            throws Exception {
//        byte[] keyBytes = Base64Util.decode(privateKey);
//        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
//        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
//        Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);
//        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
//        cipher.init(Cipher.ENCRYPT_MODE, privateK);
//        int inputLen = data.length;
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//        int offSet = 0;
//        byte[] cache;
//        int i = 0;
//        // 对数据分段加密
//        while (inputLen - offSet > 0) {
//            if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
//                cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
//            } else {
//                cache = cipher.doFinal(data, offSet, inputLen - offSet);
//            }
//            out.write(cache, 0, cache.length);
//            i++;
//            offSet = i * MAX_ENCRYPT_BLOCK;
//        }
//        byte[] encryptedData = out.toByteArray();
//        out.close();
//        return encryptedData;
//    }
//
//    /**
//     * <p>
//     * 获取私钥
//     * </p>
//     *
//     * @param keyMap 密钥对
//     * @return
//     * @throws Exception
//     */
//    public static String getPrivateKey(Map<String, Object> keyMap)
//            throws Exception {
//        Key key = (Key) keyMap.get(PRIVATE_KEY);
//        return Base64Util.encode(key.getEncoded());
//    }
//
//    /**
//     * <p>
//     * 获取公钥
//     * </p>
//     *
//     * @param keyMap 密钥对
//     * @return
//     * @throws Exception
//     */
//    public static String getPublicKey(Map<String, Object> keyMap)
//            throws Exception {
//        Key key = (Key) keyMap.get(PUBLIC_KEY);
//        return Base64Util.encode(key.getEncoded());
//    }
//
//    public static void main(String[] args) throws Exception {
//        String privateKey="MIICXQIBAAKBgQDKoeRzRVf8WoRSDYYqUzThpYCr90jfdFwTSXHJ526K8C6TEwdT" +
//                "UA+CFPQPRUg9jrYgFcown+J2myzO8BRLynD+XHb9ilLb49Mqk2CvDt/yK32lgHv3" +
//                "QVx14Dpb6h8isjncSF965fxBxlHGbvPwnHkJ9etRIYdYV3QpYohFszH3wQIDAQAB" +
//                "AoGAFhKqkw/ztK6biWClw8iKkyX3LURjsMu5F/TBK3BFb2cYe7bv7lhjSBVGPL+c" +
//                "TfBU0IvvGXrhLXBb4jLu0w67Xhggwwfc86vlZ8eLcrmYVat7N6amiBmYsw20GViU" +
//                "UFmePbo1G2BXqMA43JxqbIQwOLZ03zdw6GHj6EVlx369IAECQQD4K2R3K8ah50Yz" +
//                "LhF7zbYPIPGbHw+crP13THiYIYkHKJWsQDr8SXoNQ96TQsInTXUAmF2gzs/AwdQg" +
//                "gjIJ/dmBAkEA0QarqdWXZYbse1XIrQgBYTdVH9fNyLs1e1sBmNxlo4QMm/Le5a5L" +
//                "XenorEjnpjw5YpEJFDS4ijUI3dSzylC+QQJARqcD6TGbUUioobWB4L9GD7SPVFxZ" +
//                "c3+EgcxRoO4bNuCFDA8VO/InP1ONMFuXLt1MbCj0ru1yFCyamc63NEUDAQJBALt7" +
//                "PjGgsKCRuj6NnOcGDSbDWIitKZhnwfqYkAApfsiBQkYGO0LLaDIeAWG2KoCB9/6e" +
//                "lAQZnYPpOcCubWyDq4ECQQCrRDf0gVjPtipnPPS/sGN8m1Ds4znDDChhRlw74MI5" +
//                "FydvHFumChPe1Dj2I/BWeG1gA4ymXV1tE9phskV3XZfq";
////        String publicKey="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDg8XqyeI9QEouvYtuBW/M4CpwL1QEitsETWoMP9wbshVdC5nqZtFDi2QtFkf5+4C9EoaRbHXgKkPitSLyAEz1HACQpGDsRfiPJUXCxlZTrz8SFFeqqONDnCg1i3uYWsVK/Mr9HxQ7okb7wjEoLU24Cm3PTxFf7GWyQKa0btiHTtQIDAQAB";
////        String publicKey="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC8rPqGGsar+BWI7vAtaaDOqphy" +
////                "41j5186hCU9DcchV4HWiv0HvQ3KXAEqHfZiAHZSyMSRMmDZVnqJwCVWFvKUPqU1R" +
////                "sCPZ9Imk+9ZXVkM3DDdw74v/s6YMNx8cTuxybRCJUfOKbyC79cnHgmQqqkODv+En" +
////                "prBtNKE4k8g90jNmbwIDAQAB";
//
//        String publicKey="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDKoeRzRVf8WoRSDYYqUzThpYCr" +
//                "90jfdFwTSXHJ526K8C6TEwdTUA+CFPQPRUg9jrYgFcown+J2myzO8BRLynD+XHb9" +
//                "ilLb49Mqk2CvDt/yK32lgHv3QVx14Dpb6h8isjncSF965fxBxlHGbvPwnHkJ9etR" +
//                "IYdYV3QpYohFszH3wQIDAQAB";
//        String s = "H4sIAAAAAAAAAKtWyiypLEhVsjI0NNRRSkkty0xO9UxRslJygTKtFJLNUkySDC1TzZMsjCzNLQ0SDSwMTZKS0oyMko2MzdPSlID6EksSlayqa3WUSvKzU/OUrPJKc3JqAWijgiVcAAAA";
////        String s = "H4sIAAAAAAAAABWMQQqAIBBF7/LXLhx1WniDjiEpJIFKShHR3Rs3f/He47/I42kJnrRWiOnKW1ojPJiJDTta2DiylgxEhxHgX7R7Fi30ftczimh7LfIBktLOwacw6pGKQHw/emGYdmUAAAA=";
//        String sign =sign(s, privateKey);
//        System.out.println(sign);
////        String sign ="aac3ab4748a4dc7ad4c7fd6f1e7390043bc416c55e1b736ca9e8d75d447a4f5574fad5ed8d3d8f192b2dfa1402c3296d50d47410843556468b504b3a094bd28422077a9b2e4f9a5ae588438afb517b766a258f6de17865a541bbc99bf9f4cca3e8af0afa143e74b9da30888ab929fcdbf3d812b7217294cc5bbc81a6dd401216";
////            String sign="oyRRwGMEe33pzOxDo490kaNJ5z7q51jCxMlfev1gR8L4IHQ0amgenjswzQujK5djuVcA8XXyeuQiB1MtVvGLRtPb7M5/fbIuNuMYOclOdT3txs3oyi5IHwQt863knQjLQ680LC9l6yzRZV8agVP1yz8Upm1AgQH1hAdxC11sydk=";
//
////        boolean verify = verify(s.getBytes(),publicKey,sign);
//        boolean verify = doCheck(s,sign,publicKey,null);
//        System.out.println(verify);
//
//    }
//}