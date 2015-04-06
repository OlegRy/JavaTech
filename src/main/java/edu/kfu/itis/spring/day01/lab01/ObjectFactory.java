package edu.kfu.itis.spring.day01.lab01;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by oleg on 06.04.15.
 */
public class ObjectFactory {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class clazzToInstantiate = Class.forName(args[0]);
        Object newInstance = clazzToInstantiate.newInstance();
        System.out.println(newInstance);
        Method[] methods = clazzToInstantiate.getMethods();
        for (Method method : methods) {
            RunThisMethod annotation = method.getAnnotation(RunThisMethod.class);
            if (annotation != null) {
                int repeat = annotation.repeat();
                for (int j = 0; j < repeat; j++) {
                    method.invoke(newInstance);
                }
            }
        }
    }
}
