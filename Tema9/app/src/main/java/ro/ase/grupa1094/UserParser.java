package ro.ase.grupa1094;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class UserParser {
    private static final String NAME = "name";
    private static final String PASSWORD = "password";
    public static List<User> parsareJson(String json) {
        List<User> users = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String name = jsonObject.getString("name");
                String password = jsonObject.getString("password");

                // Creare utilizator cu ID unic
                User user = new User(name, password);
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
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
