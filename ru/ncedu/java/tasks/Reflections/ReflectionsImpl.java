//package ru.ncedu.java.tasks;
//
//import java.lang.reflect.Constructor;
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
//import java.util.List;
//import java.util.Set;
//
///**
// * Created by Mari on 02.05.2016.
// */
//public class ReflectionImpl implements Reflections {
//    /**
//     * Метод возвращает текущее значение поля для данного экземпляра,
//     * имеющего идентификатор private, public, protected или default.
//     *
//     * @param object    экземпляр класса
//     * @param fieldName имя поля класса
//     * @return Текущее значение поля
//     * @throws NoSuchFieldException если поля с указанным именем не существует
//     * @throws NullPointerException если fieldName or object является null-ом
//     */
//    @Override
//    public Object getFieldValueByName(Object object, String fieldName) throws NoSuchFieldException {
//        return null;
//    }
//
//    /**
//     * Метод возвращает набор имен методов для класса, помеченных идентификатором protected
//     *
//     * @param clazz класс
//     * @return Набор имен методов
//     * @throws NullPointerException если clazz является null-ом
//     */
//    @Override
//    public Set<String> getProtectedMethodNames(Class clazz) {
//        return null;
//    }
//
//    /**
//     * Метод возвращает набор всех методов класса, в т.ч. методов его суперклассов.
//     * Возвращаемые методы могут иметь любые модификаторы.
//     * Если в иерархии есть переопределенные методы, должны возвращаться все они
//     * (а не только метод, переопределяющий остальные).<br/>
//     *
//     * @param clazz класс
//     * @return Набор методов для всей иерархии классов.
//     * @throws NullPointerException если clazz является null-ом
//     */
//    @Override
//    public Set<Method> getAllImplementedMethodsWithSupers(Class clazz) {
//        return null;
//    }
//
//    /**
//     * Метод возвращает список классов, являющихся суперклассами для указанного класса.
//     *
//     * @param clazz класс
//     * @return Набор классов всей иерархии.
//     * @throws NullPointerException если clazz является null-ом
//     */
//    @Override
//    public List<Class> getExtendsHierarchy(Class clazz) {
//        return null;
//    }
//
//    /**
//     * Метод возвращает список интерфейсов, которые реализует класс/интерфейс clazz
//     *
//     * @param clazz - класс/интерфейс
//     * @return Набор интерфейсов
//     * @throws NullPointerException - если clazz является null-ом
//     */
//    @Override
//    public Set<Class> getImplementedInterfaces(Class clazz) {
//        return null;
//    }
//
//    /**
//     * Метод возвращает список исключений, которые может порождать метод
//     *
//     * @param method метод
//     * @return Список порождаемых исключений
//     * @throws NullPointerException если method является null-ом
//     */
//    @Override
//    public List<Class> getThrownExceptions(Method method) {
//        return null;
//    }
//
//    /**
//     * Метод создает экземпляр класса SecretClass с помощью конструктора по умолчанию,
//     * после чего вызвает его метод foo()
//     *
//     * @return результат, который возвращает метод foo()
//     */
//    @Override
//    public String getFooFunctionResultForDefaultConstructedClass() {
////		Class<?> clazz = Class.forName("ru.ncedu.java.tasks.Reflections$SecretClass");
//        Class<?> clazz;
//        try {
//            clazz = Class.forName("ru.ncedu.java.tasks.Reflections");
//            clazz = clazz.getClasses()[0];
//
//            Constructor<?> constructor = clazz.getDeclaredConstructor(new Class<?>[0]);
//            constructor.setAccessible(true);
//
//            Object secretClassInstance = constructor.newInstance(new Object[0]);
//
//            Method method = clazz.getDeclaredMethod("foo", new Class<?>[0]);
//
//            method = clazz.getDeclaredMethod("foo", new Class<?>[] {String.class, Integer[].class});
//
//            method.setAccessible(true);
//
//            String result = (String) method.invoke(secretClassInstance, new Object[] {"Sum", new Integer[] {1, 2, 3, 4, 5}});
//
//            return result;
//        } catch (ClassNotFoundException e) {
//            throw new IllegalStateException("Class was not found", e);
//        } catch (NoSuchMethodException e) {
//            throw new IllegalStateException("Method or constructor was not found", e);
//        } catch (SecurityException e) {
//            throw new IllegalStateException("Method is private", e);
//        } catch (InstantiationException e) {
//            throw new IllegalStateException("Constructor error", e);
//        } catch (IllegalAccessException e) {
//            throw new IllegalStateException("Constructor error", e);
//        } catch (IllegalArgumentException e) {
//            throw new IllegalStateException("Constructor error", e);
//        } catch (InvocationTargetException e) {
//            throw new IllegalStateException("Constructor error", e);
//        }
//    }
//
//    /**
//     * Метод создает экземпляр класса SecretClass с помощью конструктора с параметром constructorParameter
//     * после чего вызвает его метод foo(...), в который передается тот же самый набор аргументов, что получила функция
//     *
//     * @param constructorParameter параметр, передаваемый конструктору
//     * @param string               первый аргумент для функции foo
//     * @param integers             последующие аргументы для функции foo
//     * @return результат, который возвращает метод foo(...)
//     */
//    @Override
//    public String getFooFunctionResultForClass(String constructorParameter, String string, Integer... integers) {
//        return null;
//    }
//}
package ru.ncedu.java.tasks.Reflections;

import java.lang.reflect.*;
import java.util.*;

public class ReflectionsImpl implements Reflections {

    public ReflectionsImpl() {

    }

    @Override
    public Object getFieldValueByName(Object object, String fieldName) throws NoSuchFieldException {
        if (object == null || fieldName == null) {
            throw new NullPointerException("fieldName or object is null");
        }

        try {
            Class<?> clazz = object.getClass();
            Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);

            return field.get(object);

        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Constructor error", e);
        }
    }

    private void throwNullPointerException(Object object) {
        if (object == null) {
            throw new NullPointerException("Method's parameter is null..");
        }
    }

    @Override
    public Set<String> getProtectedMethodNames(Class clazz) {
        throwNullPointerException(clazz);

        Set<Method> methods = new HashSet<>();
        Collections.addAll(methods, clazz.getDeclaredMethods());

        Set<String> nameMethods = new HashSet<>();
        for (Method m : methods) {
            if (Modifier.isProtected(m.getModifiers())) {
                nameMethods.add(m.getName());
            }
        }
        return nameMethods;
    }

    @Override
    public Set<Method> getAllImplementedMethodsWithSupers(Class clazz) {
        throwNullPointerException(clazz);

        Set<Method> methods = new HashSet<>();
        Collections.addAll(methods, clazz.getDeclaredMethods());

        for (Class c : getExtendsHierarchy(clazz)) {
            Collections.addAll(methods, c.getDeclaredMethods());
        }

        return methods;
    }

    @Override
    public List<Class> getExtendsHierarchy(Class clazz) {
        throwNullPointerException(clazz);

        List<Class> superClasses = new ArrayList<>();
        while ((clazz = clazz.getSuperclass()) != null) {
            superClasses.add(clazz);
        }

        return superClasses;
    }

    @Override
    public Set<Class> getImplementedInterfaces(Class clazz) {
        throwNullPointerException(clazz);

        Set<Class> interfaces= new HashSet<>();
        Collections.addAll(interfaces, clazz.getInterfaces());

        return interfaces;
    }

    @Override
    public List<Class> getThrownExceptions(Method method) {
        throwNullPointerException(method);

        List<Class> exceptions = new ArrayList<>();
        Collections.addAll(exceptions, method.getExceptionTypes());

        return exceptions;
    }

    @Override
    public String getFooFunctionResultForDefaultConstructedClass() {
        Class<?> clazz;
        try {
            clazz = Class.forName("ru.ncedu.java.tasks.Reflections");
            clazz = clazz.getClasses()[0];

            Constructor<?> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);

            Object secretClassInstance = constructor.newInstance();

            Method method = clazz.getDeclaredMethod("foo");
            method.setAccessible(true);

            return (String) method.invoke(secretClassInstance);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Class was not found", e);
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException("Method or constructor was not found", e);
        } catch (SecurityException e) {
            throw new IllegalStateException("Method is private", e);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | IllegalArgumentException e) {
            throw new IllegalStateException("Constructor error", e);
        }
    }

    @Override
    public String getFooFunctionResultForClass(String constructorParameter, String string, Integer... integers) {
        Class<?> clazz;
        try {
            clazz = Class.forName("ru.ncedu.java.tasks.Reflections");
            clazz = clazz.getClasses()[0];

            Constructor<?> constructor = clazz.getDeclaredConstructor(String.class);
            constructor.setAccessible(true);

            Object secretClassInstance = constructor.newInstance(constructorParameter);

            Method method = clazz.getDeclaredMethod("foo", String.class, Integer[].class);
            method.setAccessible(true);

            return (String) method.invoke(secretClassInstance, string, integers);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Class was not found", e);
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException("Method or constructor was not found", e);
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new IllegalStateException("Constructor error", e);
        }

    }
}