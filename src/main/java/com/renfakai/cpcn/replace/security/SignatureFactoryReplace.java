package com.renfakai.cpcn.replace.security;

import cpcn.institution.tools.security.Signer;

/**
 * 替换到原来的SignatureFactory
 *
 * @author renfakai
 * @since 2019/08/22
 */
public class SignatureFactoryReplace {

    private Signer signer;

    public Signer getSigner() {
        return signer;
    }

    public void setSigner(Signer signer) {
        this.signer = signer;
    }
}
