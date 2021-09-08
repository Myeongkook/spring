package com.hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }

    private SingletonService(){
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }

    public static void main(String[] args) {
        SingletonService singletonService = new SingletonService();
        SingletonService singletonService1 = new SingletonService();
        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService = " + singletonService);
    }
}
