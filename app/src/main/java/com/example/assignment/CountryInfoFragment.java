package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.net.Uri;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CountryInfoFragment extends Fragment {

    private ImageView flag;
    private TextView name;
    private TextView level;
    private Button search;
    private Countries newCountry;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public CountryInfoFragment(){

    }

    public static CountryInfoFragment newInstance(String param1, String param2) {
        CountryInfoFragment fragment = new CountryInfoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_country_info_fragment, container, false);
        int position = 0;

        flag = v.findViewById(R.id.flag);
        name = v.findViewById(R.id.name);
        level = v.findViewById(R.id.level);
        search = v.findViewById(R.id.search);

        boolean wide = false;
        if(this.getArguments() != null) {
            wide = getArguments().getBoolean("wide",true);
        }

        if(wide) {
            newCountry = Countries.getCountries().get(getArguments().getInt("position"));
        } else {
            Intent intent = getActivity().getIntent();
            position = intent.getIntExtra("position",0);
            newCountry = Countries.getCountries().get(position);
        }

        flag.setImageResource(newCountry.getFlag());
        name.setText(newCountry.getAnswers());
        level.setText(newCountry.getLevel());

        search.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                googleCountry(newCountry.getAnswers());
            }
        });
        return v;
    }

    public void googleCountry (String countryName) {
        String url = "https://www.google.com/search?q=" + countryName;
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}
