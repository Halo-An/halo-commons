package com.halo.chain.demo;

import com.halo.chain.core.Handler;

public class AccountRoleHandler extends Handler<User> {


    @Override
    public void process(User user) {
        System.out.println("账号角色权限检查：通过");
    }
}
