package ro.ase.grupa1094;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseService {
    private final DatabaseReference reference;
    private static FirebaseService firebaseService;

    private FirebaseService() {
        reference = FirebaseDatabase.getInstance().getReference();
    }

    public static FirebaseService getInstance() {
        if (firebaseService == null) {
            synchronized (FirebaseService.class) {
                if (firebaseService == null) {
                    firebaseService = new FirebaseService();
                }
            }
        }
        return firebaseService;
    }

    public void insert(LoginInfo loginInfo){
        if(loginInfo == null || loginInfo.getId() != null){
            return;
        }
        String id = reference.push().getKey();
        loginInfo.setId(id);
        reference.child(loginInfo.getId()).setValue(loginInfo);
    }

    public void insert(SignUpInfo signUpInfo){
        if(signUpInfo==null || signUpInfo.getId()!=null){
            return;
        }
        String id = reference.push().getKey();
        signUpInfo.setId(id);
        reference.child(signUpInfo.getId()).setValue(signUpInfo);
    }

    public void update(LoginInfo loginInfo){
        if(loginInfo == null || loginInfo.getId() == null){
            return;
        }
        reference.child(loginInfo.getId()).setValue(loginInfo);
    }

    public void update(SignUpInfo signUpInfo){
        if(signUpInfo==null || signUpInfo.getId()==null){
            return;
        }
        reference.child(signUpInfo.getId()).setValue(signUpInfo);
    }
    public void delete(LoginInfo loginInfo){
        if(loginInfo == null || loginInfo.getId() != null){
            return;
        }
        reference.child(loginInfo.getId()).removeValue();
    }
    public void delete(SignUpInfo signUpInfo){
        if(signUpInfo==null || signUpInfo.getId()!=null){
            return;
        }
        reference.child(signUpInfo.getId()).removeValue();
    }
    public void addLoginInfoListener(Callback<List<LoginInfo>> callback){
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<LoginInfo> loginInfos = new ArrayList<>();
                for (DataSnapshot data : snapshot.getChildren()){
                    LoginInfo loginInfo = data.getValue(LoginInfo.class);
                    if(loginInfo!=null){
                        loginInfos.add(loginInfo);
                    }
                }
                callback.runOnUI(loginInfos);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("firebase", "Userul este deja folosit!");
            }
        });
    }
    
    public void addSignUpInfoListener(Callback<List<SignUpInfo>> callback){
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<SignUpInfo> signUpInfos = new ArrayList<>();
                for (DataSnapshot data : snapshot.getChildren()){
                    SignUpInfo signUpInfo = data.getValue(SignUpInfo.class);
                    if(signUpInfo!=null){
                        signUpInfos.add(signUpInfo);
                    }
                }
                callback.runOnUI(signUpInfos);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("firebase", "Userul este deja folosit!");
            }
        });
    }
}
