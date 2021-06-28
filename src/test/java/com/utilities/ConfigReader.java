package com.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigReader {

//    1- properties uzantili olan configuration dosyasini okumasi icin Properties class'indan bir obje olusturuyoruz
//    ve projenin her yerinden Class ismi ile cagrilabilmesi icin static yapiyoruz
    private static Properties properties;

    static {
        String path = "configuration.properties";

        try{
            FileInputStream fileInputStream = new FileInputStream(path);

            properties = new Properties();
            properties.load(fileInputStream);

            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static String getProperty (String key){

    String value = properties.getProperty(key);

//    return properties.getProperty(key);  =>> olarak da yazilabilir. value degiskeni olusturmamiza gerek kalmaz
    return value;
    }

}
