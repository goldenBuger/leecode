package reflect;

import java.lang.reflect.Field;

public class Main {
    public String name;
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
        // 创建类的实例
        MyClass obj = new MyClass("初始值");

        // 获取类的Class对象
        Class<?> clazz = obj.getClass();

        // 获取私有字段的Field对象
        Field privateField = clazz.getDeclaredField("privateVariable");

        // 移除私有字段的final修饰，这在JDK 9及更高版本中不被推荐
        // 因为JDK 9开始，final字段的值是不可变的
        privateField.setAccessible(true);

        // 修改私有变量的值
        privateField.set(obj, "新值");

        // 验证修改
        System.out.println(obj.getPrivateVariable()); // 输出: 新值
    }
}

class MyClass {
    private final String privateVariable;

    public MyClass(String privateVariable) {
        this.privateVariable = privateVariable;
    }

    public String getPrivateVariable() {
        return privateVariable;
    }
}