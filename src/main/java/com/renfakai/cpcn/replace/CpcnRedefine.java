package com.renfakai.cpcn.replace;

import com.renfakai.cpcn.replace.base.TxBaseRequestRedefine;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import payment.api.tx.TxBaseRequest;

import java.util.Objects;

/**
 * 中金代码重新定义类
 *
 * @author renfakai
 * @since 2019/08/22
 */
public class CpcnRedefine {

    private CpcnRedefine() {
        ByteBuddyAgent.install();
    }

    private volatile static CpcnRedefine instance;

    public static CpcnRedefine getInstance() {
        if (Objects.isNull(instance)) {
            synchronized (CpcnRedefine.class) {
                if (Objects.isNull(instance)) {
                    instance = new CpcnRedefine();
                }
            }
        }
        return instance;
    }

    private void txBaseRequestReplace() {
        new ByteBuddy()
                .redefine(TxBaseRequestRedefine.class)
                .name(TxBaseRequest.class.getName())
                .make()
                .load(TxBaseRequest.class.getClassLoader(), ClassReloadingStrategy.fromInstalledAgent());

    }

    public void redefine() {
        this.txBaseRequestReplace();
    }
}
