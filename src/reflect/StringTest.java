package reflect;

import java.lang.reflect.Field;

public class StringTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String s = new String("中国");

        System.out.println(s.hashCode());
        String s1 = s+"123";
        System.out.println(s.hashCode());
        // 获取类的Class对象
        Class<?> clazz = s.getClass();

        // 获取私有字段的Field对象
        Field privateField = clazz.getDeclaredField("value");

        // 移除私有字段的final修饰，这在JDK 9及更高版本中不被推荐
        // 因为JDK 9开始，final字段的值是不可变的
        privateField.setAccessible(true);
        char[] chars = {'1', '2', '3'};
        // 修改私有变量的值
        privateField.set(s,chars);
        // 验证修改
        System.out.println(s.hashCode()); // 输出: 新值
    }
}
