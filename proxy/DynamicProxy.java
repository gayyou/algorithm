package proxy;

import java.lang.reflect.Proxy;

public class DynamicProxy {
  public static void main(String[] args) {
    JavaDeveloper Weybn = new JavaDeveloper();

    Developer WeybnProxy = (Developer) Proxy.newProxyInstance(Weybn.getClass().getClassLoader(),
            Weybn.getClass().getInterfaces(), (proxy, method, agrs) -> {
              if (method.getName().equals("code")) {
                System.out.println("Weybn is Coding");
                return method.invoke(Weybn, args);
              }
              if (method.getName().equals("debug")) {
                System.out.println("Weybn is Debugging");
                return method.invoke(Weybn, args);
              }

              return null;
            });

    WeybnProxy.code();
    WeybnProxy.debug();
  }
}
