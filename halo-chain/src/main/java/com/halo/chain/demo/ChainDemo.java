package com.halo.chain.demo;

import com.halo.chain.core.Handler;

/**
 * 责任链使用示例
 * 账号合规性检查 -> 账号存在性检查 -> 账号角色权限检查
 */
public class ChainDemo {

    public static void main(String[] args) {

        Handler<User> head = new Handler.Builder()
                .addHandler(new AccountValidatorHandler())
                .addHandler(new AccountExistHandler())
                .addHandler(new AccountRoleHandler())
                .build();

        head.doHandle(new User("leiming", "123456"));
    }

}
