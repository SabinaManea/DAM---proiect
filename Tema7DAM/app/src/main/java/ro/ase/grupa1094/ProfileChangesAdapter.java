package ro.ase.grupa1094;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.List;

public class ProfileChangesAdapter extends ArrayAdapter<User> {
    private Context context;
    private int layoutId;
    private List<User> userList;
    private LayoutInflater inflater;

    public ProfileChangesAdapter(@NonNull Context context, int layoutId, List<User> userList, LayoutInflater inflater) {
        super(context, layoutId, userList);
        this.context = context;
        this.layoutId = layoutId;
        this.userList = userList;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = inflater.inflate(layoutId, parent, false);
        User user = userList.get(position);

        TextView tvNume = view.findViewById(R.id.tvNume);
        TextView tvPassword = view.findViewById(R.id.tvPassword);

        tvNume.setText(user.getName());
        tvPassword.setText(user.getPassword());

        if(user.getName()!=null){
            tvNume.setAllCaps(true);
        }
        return view;
    }
}
