package com.renfakai.cpcn.conf;

import com.renfakai.cpcn.replace.CpcnRedefine;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import payment.api.system.PaymentEnvironment;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.Security;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

@Slf4j
public final class Configuration {

    private static final Map<String, String> CONTAINER = new ConcurrentHashMap<>();

    public static void init() {

        loadConfiguration();

        CpcnRedefine.getInstance().redefine();

        loadCpcnConfiguration();
    }

    /**
     * 加载系统公开的配置文件
     */
    private static void loadConfiguration() {
        try {
            String path = new ClassPathResource("cpcn.properties").getURL().getPath();
            Stream.of(path).forEach(Configuration::loadFileSystemConfiguration);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 加载中金配置文件
     */
    private static void loadCpcnConfiguration() {
        try {
            Security.setProperty("ssl.SocketFactory.provider", "");
            Security.setProperty("ssl.ServerSocketFactory.provider", "");
            String cpcnConfigFilePath = new ClassPathResource("conf/cpcn").getURL().getPath();
            PaymentEnvironment.initialize(cpcnConfigFilePath);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    private static void loadFileSystemConfiguration(String filePath) {
        try {
            Properties properties = new Properties();
            properties.load(new InputStreamReader(new ByteArrayInputStream(Files.readAllBytes(Paths.get(filePath))), StandardCharsets.UTF_8));
            for (Map.Entry<Object, Object> entry : properties.entrySet()) {
                String key = entry.getKey().toString();
                String value = entry.getValue().toString();
                log.info("加载参数key:{},value:{}", key, value);
                CONTAINER.put(key, value);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static String get(String key) {
        if (key == null || "".equals(key.trim())) {
            return null;
        }

        return CONTAINER.get(key);
    }

    public static void put(String key, String value) {
        if (key != null && value != null && !"".equals(key.trim()) && !"".equals(value.trim())) {
            CONTAINER.put(key.trim(), value.trim());
        }
    }

    public static boolean getBoolean(String key) {
        if (key == null || "".equals(key = key.trim())) {
            return false;
        }

        return "true".equals(CONTAINER.get(key));
    }

    public static int getInt(String key) {
        if (key == null || "".equals(key = key.trim())) {
            return 0;
        }

        return Integer.parseInt(CONTAINER.get(key));
    }

    public static int getInt(String key, int defaultValue) {
        if (key == null || "".equals(key = key.trim())) {
            return defaultValue;
        }

        String value = CONTAINER.get(key);
        if (value == null || "".equals(value = value.trim())) {
            return defaultValue;
        }
        try {
            return Integer.parseInt(value);
        } catch (Throwable e) {
            return defaultValue;
        }
    }
}
