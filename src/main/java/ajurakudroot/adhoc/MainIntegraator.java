package ajurakudroot.adhoc;


import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MainIntegraator {
    public static void main(String[] args) throws NoSuchMethodException {
        Reflections reflections = new Reflections("ajurakudroot/ajurakud", new SubTypesScanner(false));

        var classes = reflections.getSubTypesOf(Object.class);

        findAllPackages().forEach(System.out::println);


    }


    /**
     * Finds all package names
     * @return Set of package names
     */
    public static Set<String> findAllPackages() {
        List<ClassLoader> classLoadersList = new LinkedList<ClassLoader>();
        classLoadersList.add(ClasspathHelper.contextClassLoader());
        classLoadersList.add(ClasspathHelper.staticClassLoader());
        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .setScanners(new SubTypesScanner(false), new ResourcesScanner())
                .setUrls(ClasspathHelper.forClassLoader(classLoadersList.toArray(new ClassLoader[0])))
                .filterInputsBy(new FilterBuilder().include(FilterBuilder.prefix("my.base.package"))));
        Set<Class<? extends Object>> classes = reflections.getSubTypesOf(Object.class);
        Set<String> packageNameSet = new TreeSet<String>();
        for (Class classInstance : classes) {
            packageNameSet.add(classInstance.getPackage().getName());
        }
        return packageNameSet;
    }




}