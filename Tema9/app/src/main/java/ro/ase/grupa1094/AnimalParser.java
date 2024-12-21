package ro.ase.grupa1094;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AnimalParser {
    private static final String NAME = "name";
    private static final String PHONE_NUMBER = "phoneNumber";
    private static final String EMAIL = "email";
    private static final TipAnimal TIP_ANIMAL = TipAnimal.valueOf("tipAnimal");

    public static List<Animal> parsareJson(String json){
        try {
            JSONArray jsonArray = new JSONArray(json);
            return parsareAnimale(jsonArray);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
    private static List<Animal> parsareAnimale(JSONArray jsonArray) throws JSONException {
        List<Animal> animale = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++){
            animale.add(parsareAnimal(jsonArray.getJSONObject(i)));
        }
        return animale;
    }
    private static Animal parsareAnimal(JSONObject jsonObject) throws JSONException {
        String name = jsonObject.getString(NAME);
        String phoneNumber = jsonObject.getString(PHONE_NUMBER);
        String email = jsonObject.getString(EMAIL);
        TipAnimal tipAnimal = TipAnimal.valueOf(jsonObject.getString("tipAnimal"));
        return new Animal(name, phoneNumber, email, tipAnimal);
    }
}
