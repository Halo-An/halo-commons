package com.halo.chain.demo;

import com.halo.chain.core.Handler;

public class AccountExistHandler extends Handler<User> {


    @Override
    public void process(User user) {
        System.out.println("账号存在性检查：失败");
    }
}
