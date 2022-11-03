package com.halo.chain.demo;

import com.halo.chain.core.Handler;

public class AccountValidatorHandler extends Handler<User> {


    @Override
    public void process(User user) {
        System.out.println("账号合规性检查：通过");
    }
}
