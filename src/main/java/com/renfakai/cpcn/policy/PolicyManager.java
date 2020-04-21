package com.renfakai.cpcn.policy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class PolicyManager {

    private static final Map<String, AbstractCpcnPayService> CONTAINER = new ConcurrentHashMap<>();


    public static boolean register(String key, AbstractCpcnPayService service) {
        return CONTAINER.put(key, service) != null;
    }

    public static AbstractCpcnPayService getPolicy(String channel) {
        AbstractCpcnPayService policyService = CONTAINER.get(channel);
        return policyService;
    }
}
