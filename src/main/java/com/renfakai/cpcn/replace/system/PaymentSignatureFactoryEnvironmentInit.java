package com.renfakai.cpcn.replace.system;

import com.renfakai.cpcn.conf.Configuration;
import com.renfakai.cpcn.replace.context.CpcnSignatureFactoryContext;
import com.renfakai.cpcn.replace.security.SignatureFactoryReplace;
import cpcn.institution.tools.security.PfxSigner;
import cpcn.institution.tools.security.Signer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.io.File;

/**
 * 中金证书加载,将证书放到容器中
 *
 * @author renfakai
 */
@Slf4j
@Component
public class PaymentSignatureFactoryEnvironmentInit {
    /**
     * 加密方式
     */
    private static final String CPCN_SIGNATURE_ALGORITHM = "cpcn.signature.algorithm";
    /**
     * 密码
     */
    private static final String CPCN_PASSWORD = ".cpcn.password";
    /**
     * 商户号
     */
    private static final String CPCN_MERCHANT = ".cpcn.merchant";

    @PostConstruct
    public void init() {
        try {
            String paymentConfigPath = new ClassPathResource("conf/cpcn/").getURL().getPath();
            File file = new File(paymentConfigPath);
            File[] allFile = file.listFiles();
            Assert.notNull(allFile, "中金配置文件不能为空");
            for (File item : allFile) {
                if (!item.isDirectory()) {
                    continue;
                }
                this.handler(item);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    public void handler(File file) {
        try {
            String name = file.getName();
            String myKeystorePassword = Configuration.get(name + CPCN_PASSWORD);
            String algorithm = Configuration.get(CPCN_SIGNATURE_ALGORITHM);
            String merchant = Configuration.get(name + CPCN_MERCHANT);
            File[] allFile = file.listFiles();

            Assert.notNull(allFile, "中金证书不能为空");
            SignatureFactoryReplace signatureFactoryReplace = new SignatureFactoryReplace();
            for (File innerFile : allFile) {
                if (innerFile.getName().endsWith("pfx")) {
                    Signer signer = new PfxSigner(innerFile.getAbsolutePath(), myKeystorePassword, algorithm);
                    signatureFactoryReplace.setSigner(signer);
                }
            }
            CpcnSignatureFactoryContext.putSignatureFactoryReplace(merchant, signatureFactoryReplace);
        } catch (Exception e) {
            log.error("加载中金证书出现错误", e);
            throw new RuntimeException("加载中金证书出现错误");
        }
    }
}
