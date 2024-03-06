package com.blog.eom.config;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.iv.RandomIvGenerator;
import org.junit.jupiter.api.Test;

public class JasyptConfigTest {

    private final String ALGORITHM_KEY = "PBEWITHHMACSHA512ANDAES_256";

    @Test
    void stringEncryptor() {
        //운영은 메일에 남겨놨음.
        String url = "jdbc:mariadb://127.0.0.1:3306/serviceName?serverTimezone=Asia/Seoul&characterEncoding=UTF-8";
        String username = "db_user_name";
        String password = "db_password";

        String endURL = jasyptEncoding(url);
        String endUser = jasyptEncoding(username);
        String endPassword = jasyptEncoding(password);

        System.out.println(String.format("암호화 URL : %s", endURL) );
        System.out.println(String.format("유저 : %s", endUser) );
        System.out.println(String.format("비번 : %s", endPassword) );
        System.out.println(String.format("복호화 URL : %s", jasyptDecryt(endURL)) );
        System.out.println(String.format("유저 : %s", jasyptDecryt(endUser)) );
        System.out.println(String.format("비번 : %s", jasyptDecryt(endPassword)) );
    }

    public String jasyptEncoding(String value) {

        String key = "jasypt-key";   // 메일에 남겨놨음
        StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
        pbeEnc.setAlgorithm(ALGORITHM_KEY);
        pbeEnc.setPassword(key);
        pbeEnc.setIvGenerator(new RandomIvGenerator());
        return pbeEnc.encrypt(value);
    }

    private String jasyptDecryt(String input){
        String key = "jasypt-key";   // 메일에 남겨놨음
        StandardPBEStringEncryptor pbeDec = new StandardPBEStringEncryptor();
        pbeDec.setAlgorithm(ALGORITHM_KEY);
        pbeDec.setPassword(key);
        pbeDec.setIvGenerator(new RandomIvGenerator());
        return pbeDec.decrypt(input);
    }
}
