package Synchronize;

/**
 * @author zxx
 * @date 2022/03/31 15:50
 **/
public class Singleton {

    /**
     * volatile 修饰变量,禁止指令重排，使得语句按照拆分的步骤进行
     */
    private static volatile Singleton singleton;

    /**
     * 无参构造方法
     */
    private Singleton(){}

    public static Singleton getSingleton(){
        //第一个if：减少性能开销，避免实例在已经创建的情况下每次获取实例都加锁
        if(singleton ==  null){
            synchronized (Singleton.class){
                //第二个if：避免生成多个对象实例，考虑多线程的情况下，
                //两个以上线程都已经判断对象为空，如果锁内不再次判空，会导致实例重复创建
                if(singleton ==  null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }


}
