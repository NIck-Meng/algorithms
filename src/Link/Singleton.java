package Link;

public class Singleton {
    public static Singleton getInstance() {
//        懒汉式单例
//        if(instance==null){
//            instance=new Singleton();
//        }
        return instance;
    }

    //在类的内部是可以访问私有的结构
    private static Singleton  instance = new Singleton();//内部产生实例化对象
    private Singleton() {} //所有的方法都可以使用四种访问权限
    public void print() {
        System.out.println("Hello world !");
    }


}
