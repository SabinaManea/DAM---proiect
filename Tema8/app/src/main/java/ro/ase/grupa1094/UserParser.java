package ro.ase.grupa1094;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class UserParser {
    private static final String NAME = "name";
    private static final String PASSWORD = "password";
    public static List<User> parsareJson(String json){
        try{
            JSONArray jsonArray = new JSONArray(json);
            return parsareUsers(jsonArray);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<User> parsareUsers(JSONArray jsonArray) throws JSONException {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++){
            users.add(parsareUser(jsonArray.getJSONObject(i)));
        }
        return users;
    }

    private static User parsareUser(JSONObject jsonObject) throws JSONException {
        String name = jsonObject.getString(NAME);
        String password = jsonObject.getString(PASSWORD);
        return  new User(name, password);
    }
}
