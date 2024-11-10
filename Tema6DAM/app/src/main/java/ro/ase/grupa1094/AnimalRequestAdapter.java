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
import ro.ase.grupa1094.TipAnimal;
import ro.ase.grupa1094.Animal;

public class AnimalRequestAdapter extends ArrayAdapter<Animal> {
    private Context context;
    private int layoutId;
    private List<Animal> animalList;
    private LayoutInflater inflater;

    public AnimalRequestAdapter(@NonNull Context context, int layoutId, List<Animal> animalList, LayoutInflater inflater) {
        super(context, layoutId, animalList);
        this.context = context;
        this.layoutId = layoutId;
        this.animalList = animalList;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = inflater.inflate(layoutId, parent, false);
        Animal animal = animalList.get(position);

        TextView tvNume = view.findViewById(R.id.tvNume);
        TextView tvPhoneNumber = view.findViewById(R.id.tvPhoneNumber);
        TextView tvEmail = view.findViewById(R.id.tvEmail);
        TextView tvAnimal = view.findViewById(R.id.tvAnimal);

        tvNume.setText(animal.getName());
        tvPhoneNumber.setText(animal.getPhoneNumber());
        tvEmail.setText(animal.getEmail());
        tvAnimal.setText(String.valueOf(animal.getTipAnimal()));

        if(animal.getTipAnimal()==TipAnimal.CAT){
            tvAnimal.setTextColor(Color.RED);
        }

        return view;
    }
}
