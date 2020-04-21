package com.renfakai.cpcn.replace.context;


import com.renfakai.cpcn.replace.security.SignatureFactoryReplace;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 缓存中金相关信息
 *
 * @author renfakai
 */
public class CpcnSignatureFactoryContext {

    /**
     * key商户号
     */
    private static final Map<String, SignatureFactoryReplace> signContainer = new ConcurrentHashMap<>();

    private CpcnSignatureFactoryContext() {
    }

    public static void putSignatureFactoryReplace(String key, SignatureFactoryReplace value) {
        signContainer.put(key, value);
    }

    public static SignatureFactoryReplace getSignatureFactoryReplace(String key) {
        return signContainer.get(key);
    }
}
