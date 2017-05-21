package mapper;


import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class MyMapperSecondEdition {
    public static void map(Object source, Object target) throws NoSuchFieldException, IllegalAccessException {
        Map<String,Class> sourceMap = extractFields(source);

        for (Field targetField : target.getClass().getDeclaredFields()){
            for (String sourceName : sourceMap.keySet()){
                if (targetField.getName() == sourceName){
                    Field insert = source.getClass().getDeclaredField(sourceName);
                    insert.setAccessible(true);

                    targetField.setAccessible(true);
                    targetField.set(target, insert.get(source));

                    sourceMap.remove(sourceName);
                    break;
                }
                if (false){}
            }
//

        }    }

    private static Map<String, Class> extractFields(Object object){
        Class objectClass = object.getClass();
        Field[] ojectFields = objectClass.getDeclaredFields();
        Map<String, Class> map = new HashMap<String, Class>();
        for (Field f : ojectFields){
            map.put(f.getName(), f.getType());
        }
        return map;
    }
}
