package com.halo.chain.core;

public abstract class Handler<T> {

    /**
     * 下一次责任链
     */
    protected Handler<T> next;

    private void next(Handler<T> next){
        this.next = next;
    }

    /**
     * 当前责任链的主要行为
     * @param t
     */
    public abstract void process( T t);

    /**
     * 责任链执行操作
     *  1.执行本次责任
     *  2.执行下次责任
     * @param t
     */
    public void doHandle(T t) {

        process( t );

        if (next != null) {
            next.doHandle(t);
        }

    }

    /**
     * 责任链构造器
     * @param <T>
     */
    public static class Builder<T> {

        /**
         * 记录责任链头部引用
         */
        private Handler<T> head;

        /**
         * 记录新的责任链引用，用于追加责任链使用
         */
        private Handler<T> tail;

        public Builder<T> addHandler(Handler<T> handler) {
            if (this.head == null) {
                this.head = this.tail = handler;
                return this;
            }
            this.tail.next(handler);
            this.tail = handler;

            return this;
        }

        public Handler<T> build() {
            return this.head;
        }
    }
}
