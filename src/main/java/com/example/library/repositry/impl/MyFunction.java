package com.example.library.repositry.impl;

@FunctionalInterface
public interface MyFunction<A, B, C, R> {

  R execute(A a, B b, C c);

}
