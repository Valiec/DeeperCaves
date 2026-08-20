package com.kpabr.DeeperCore.dimstack;

@FunctionalInterface
public interface QuadConsumer<T,U,V,W> {
    void accept(T arg1, U arg2, V arg3, W arg4);
    default QuadConsumer<T,U,V,W>  andThen(QuadConsumer<? super T, ? super U, ? super V, ? super W> after) {
        if(after == null) {
            throw new NullPointerException();
        }
        return (arg1, arg2, arg3, arg4) -> { accept(arg1, arg2, arg3, arg4); after.accept(arg1, arg2, arg3, arg4); };
    }
}
