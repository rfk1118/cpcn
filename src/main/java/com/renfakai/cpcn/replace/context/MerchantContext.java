package com.renfakai.cpcn.replace.context;

/**
 * 商户号传递参数
 *
 * @author renfakai
 * @date 2019/08/22
 */
public final class MerchantContext {

    private static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static String get() {
        return threadLocal.get();
    }

    public static void put(String t) {
        threadLocal.set(t);
    }

    public static void remove() {
        threadLocal.remove();
    }

}
