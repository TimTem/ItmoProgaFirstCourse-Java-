package Json;

import Flat.Flat;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import Validator.ValidatorForStack;
import javax.xml.validation.Validator;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Stack;

public class Deserializer {
    public static Stack<Flat> deserializer(String string){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDate.class, new DeserializerDate());
        Gson gson = gsonBuilder.setPrettyPrinting().create();
        Type type = new TypeToken<Stack<Flat>>(){}.getType();
        Stack<Flat> flats = gson.fromJson(string, type);
        ValidatorForStack.validator(flats);
        return flats;
    }
}
