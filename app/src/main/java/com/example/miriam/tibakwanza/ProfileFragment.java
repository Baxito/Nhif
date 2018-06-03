package com.example.miriam.tibakwanza;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    TextView head1;
    TextView head2,gnd,fml,reg,no,nation,doB,date,country;
    ImageView image;


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        head1 = view.findViewById(R.id.textView5);
        head2 = view.findViewById(R.id.textView6);
        gnd = view.findViewById(R.id.textView7);
        fml = view.findViewById(R.id.textView13);
        reg = view.findViewById(R.id.textView8);
        no = view.findViewById(R.id.textView15);
        nation = view.findViewById(R.id.textView12);
        country = view.findViewById(R.id.textView17);
        doB = view.findViewById(R.id.textView11);
        date = view.findViewById(R.id.textView16);
        image = view.findViewById(R.id.imageView6);

        return view;



    }

}
