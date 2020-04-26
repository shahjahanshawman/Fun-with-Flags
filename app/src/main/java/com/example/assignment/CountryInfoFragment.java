package com.example.assignment;

import androidx.fragment.app.Fragment;
import android.net.Uri;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.assignment.InfoFromAPI.MainInfo;

public class CountryInfoFragment extends Fragment {

    private ImageView flag;
    private TextView name, capital, currency, population;
    private Button search;
    private MainInfo newCountry;

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
        //int position = 0;
        newCountry = (MainInfo) getArguments().getSerializable("country");

        flag = v.findViewById(R.id.flag);
        name = v.findViewById(R.id.cname);
        search = v.findViewById(R.id.search);
        currency = v.findViewById(R.id.currency);
        capital = v.findViewById(R.id.capital);
        population = v.findViewById(R.id.population);

//        boolean wide = false;
//        if(this.getArguments() != null) {
//            wide = getArguments().getBoolean("wide",true);
//        }
//
//        if(wide) {
//            newCountry = Countries.getCountries().get(getArguments().getInt("position"));
//        } else {
//            Intent intent = getActivity().getIntent();
//            position = intent.getIntExtra("position",0);
//            newCountry = Countries.getCountries().get(position);
//        }

        String url ="https://www.countries-ofthe-world.com/flags-normal/flag-of-";
        String forImage = newCountry.getName();
        if(forImage.contains(" ")){
            forImage=forImage.replace(" ", "-");
        }


        url= url+forImage+".png";

        Glide.with(v).load(url).error(R.drawable.missing_flag).into(flag);


        // flag.setImageResource(newCountry.getFlag());

        name.setText(newCountry.getName());
        currency.setText(newCountry.getCurrencies().get(0).getName());
        capital.setText(newCountry.getCapital());

        Float pop = newCountry.getPopulation();
        population.setText(truncateNumber(pop));

        search.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                googleCountry(newCountry.getName());
            }
        });
        return v;
    }

    public void googleCountry (String countryName) {
        String url = "https://www.google.com/search?q=" + countryName;
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }




//
//    public String pop(long number, long divisor) {
//        long truncate = (number * 10L + (divisor / 2L)) / divisor;
//        float fraction = (float) truncate * 0.10F;
//        return fraction;
//
//        long million = 1000000L;
//        long billion = 1000000000L;
//        long trillion = 1000000000000L;
//        long number = Math.round(floatNumber);
//        if ((number >= million) && (number < billion)) {
//            float fraction = calculateFraction(number, million);
//            return Float.toString(fraction) + "M";
//        } else if ((number >= billion) && (number < trillion)) {
//            float fraction = calculateFraction(number, billion);
//            return Float.toString(fraction) + "B";
//        }
//        return Long.toString(number);
//    }
//    }

    public String truncateNumber(float floatNumber) {
        long million = 1000000L;
        long billion = 1000000000L;
        long trillion = 1000000000000L;
        long number = Math.round(floatNumber);
        if ((number >= million) && (number < billion)) {
            float fraction = calculateFraction(number, million);
            return Float.toString(fraction) + "M";
        } else if ((number >= billion) && (number < trillion)) {
            float fraction = calculateFraction(number, billion);
            return Float.toString(fraction) + "B";
        }
        return Long.toString(number);
    }

    public float calculateFraction(long number, long divisor) {
        long truncate = (number * 10L + (divisor / 2L)) / divisor;
        float fraction = (float) truncate * 0.10F;
        return fraction;
    }
}