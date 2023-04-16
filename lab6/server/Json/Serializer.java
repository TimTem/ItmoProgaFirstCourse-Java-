package Json;

import Flat.Flat;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Stack;
import java.util.TreeSet;

public class Serializer {
    public static String serializer(Stack<Flat> stack){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDate.class, new SerializerDate());
        Gson gson = gsonBuilder.setPrettyPrinting().create();
        Type type = new TypeToken<Stack<Flat>>(){}.getType();
        return gson.toJson(stack, type);
    }
}
