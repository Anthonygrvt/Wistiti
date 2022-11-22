package fr.projete3.wistiti;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class NavFragment extends Fragment {

    interface OnItemClickListener {
        void onItemSelected(int btnpress);

        // for nested class ListFragment.onItemClickListener
    }

    public NavFragment() {
    }

    private Button btnHome;
    private Button btnPlus;
    private Button btnMenu;

    private int btnpress;

    private OnItemClickListener callback;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // This makes sure that the host activity has implemented the callback interface
        // If not, it throws an exception
        try {
            callback = (OnItemClickListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnItemClickListener");
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_nav, container, false);

        btnHome = (Button) rootView.findViewById(R.id.btnHome);
        btnMenu = (Button) rootView.findViewById(R.id.btnMenu);
        btnPlus = (Button) rootView.findViewById(R.id.btnPlus);


        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnpress = 1;
                callback.onItemSelected(btnpress);
            }});
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnpress = 2;
                callback.onItemSelected(btnpress);
            }});
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnpress = 3;
                callback.onItemSelected(btnpress);
            }});
        return rootView;
    }
}