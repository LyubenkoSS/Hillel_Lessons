package mapper;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;


public class MyMapper {

    //работает если Class полей уникален иначе мапит первые сопоставления
   public static void map(Object fromMappied, Object whereMapping)
           throws NoSuchFieldException, IllegalAccessException{

        Map<String, Class> fieldsFromMappied = extractFields(fromMappied);
        Map<String, Class> fieldsWhereMapping = extractFields(whereMapping);

        for (String nameField : fieldsFromMappied.keySet()){
            if (fieldsWhereMapping.containsKey(nameField)){
                Field insert = fromMappied.getClass().getDeclaredField(nameField);
                insert.setAccessible(true);

                Field f = whereMapping.getClass().getDeclaredField(nameField);
                f.setAccessible(true);
                f.set(whereMapping, insert.get(fromMappied));

                fieldsWhereMapping.remove(nameField);
                fieldsFromMappied.remove(nameField);
            }
        }

        for (String nameFieldFrom : fieldsFromMappied.keySet()){
            for (String nameFieldWhere : fieldsWhereMapping.keySet()){
                if (fieldsWhereMapping.get(nameFieldWhere).equals(fieldsFromMappied.get(nameFieldFrom))){
                    Field insert = fromMappied.getClass().getDeclaredField(nameFieldFrom);
                    insert.setAccessible(true);

                    Field f = whereMapping.getClass().getDeclaredField(nameFieldWhere);
                    f.setAccessible(true);
                    f.set(whereMapping, insert.get(fromMappied));

                    fieldsWhereMapping.remove(nameFieldWhere);
                }
            }
        }

       System.out.println(fieldsWhereMapping.keySet().toArray().length);
       System.out.println(fieldsFromMappied.keySet().toArray().length);
       System.out.println(whereMapping);
    }

    private static   Map<String, Class> extractFields(Object object){
        Class objectClass = object.getClass();
        Field[] ojectFields = objectClass.getDeclaredFields();
        Map<String, Class> map = new HashMap<String, Class>();
        for (Field f : ojectFields){
            map.put(f.getName(), f.getType());
        }
        return map;
    }
}
