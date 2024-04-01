package reflect;

import java.lang.reflect.Constructor;

public class R01 {
    /*
    获取class对象的方法
     */
    public void test01() throws Exception{
        Class clazz1 = Main.class;
        Class clazz2 = new Main().getClass();
        Class clazz3 = Class.forName("reflect.Main");
    }
    /*
    获取构造方法
     */
    public void test02() throws Exception{
        Class clazz = Main.class;
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor c:constructors){
            System.out.println(c.getName() + c.getParameterTypes());
        }
        //获取包含私有属性的所有方法
        Constructor constructorss = clazz.getDeclaredConstructor();
        //指定有参数构造创建对象
        //1.构造public
        Constructor constructor= clazz.getConstructor(String.class);
        Main o = (Main)constructor.newInstance("张三");
        //2.构造private
        Constructor constructor1= clazz.getDeclaredConstructor(String.class);
        Main o1 = (Main)constructor1.newInstance("张三");
    }
    /*
    获取属性
     */
    public void test03() throws Exception{

    }
    /*
    获取方法
     */
}