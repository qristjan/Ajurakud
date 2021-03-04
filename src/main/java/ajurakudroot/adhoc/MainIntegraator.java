package ajurakudroot.adhoc;


import org.reflections.Reflections;
import org.reflections.scanners.MethodParameterScanner;
import org.reflections.scanners.SubTypesScanner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class MainIntegraator {
    public static void main(String[] args) throws NoSuchMethodException {
        Reflections reflections = new Reflections("ajurakudroot", new SubTypesScanner(false), new MethodParameterScanner());
        var mainMethods = reflections.getMethodsMatchParams(String[].class).stream()
                .filter(method -> (method.getModifiers() & Modifier.STATIC) == 8);

        // TODO : FILTER OUT BY NAME MAIN

        String[] paramas = null;
        var futures = new ArrayList<CompletableFuture<Void>>();
        mainMethods.forEach(method -> futures.add(CompletableFuture.runAsync(() -> {
            try {
                var m = method.invoke(null, (Object) paramas);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        })));

        CompletableFuture<Void> future = CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]));
        try {
            future.get(); // this line waits for all to be completed
        } catch (InterruptedException  | ExecutionException e) {
            // Handle
        }
    }
}