package Synchronize;

/**
 * @author zhengstars
 * @date 2022/04/05
 */
public class SingletonJava {
    private static volatile SingletonJava singletonJava;

    public SingletonJava(){}

    public static SingletonJava getSingletonJava(){
        if(null == singletonJava){
            synchronized (SingletonJava.class){
                if(null == singletonJava){
                    singletonJava = new SingletonJava();
                }
            }
        }

        return singletonJava;
    }
}
