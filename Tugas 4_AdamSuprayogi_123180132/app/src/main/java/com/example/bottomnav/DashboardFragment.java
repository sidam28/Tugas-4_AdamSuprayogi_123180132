package com.example.bottomnav;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DashboardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DashboardFragment extends Fragment {



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DashboardFragment() {
        // Required empty public constructor

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DashboardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DashboardFragment newInstance(String param1, String param2) {
        DashboardFragment fragment = new DashboardFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        RecyclerView phpRecycler;

        ArrayList<MainModel> mainModels;
        MainAdapter mainAdapter;

        View view = inflater.inflate(R.layout.fragment_dashboard, container,false);

        phpRecycler = view.findViewById(R.id.rv_game_seru);

        Integer[] phpFrameworkLogo = {R.drawable.role_rancing,
                R.drawable.forzahorizon,
                R.drawable.aspalt,
                R.drawable.minecraft};

        String[] phpFrameworkName = {"Rancing", "Forza", "Aspal", "Minecraf"};

        String[] phpDetail = {
                "Tear up the Asphalt in the ultimate console racing experience! Enjoy the intuitive TouchDrive controls as you take the wheel of the most prestigious dream cars across 70 gravity-defying tracks. Complete over 800 events in the solo Career mode and face up to 7 players in real time in mu",
                "Tear up the Asphalt in the ultimate console racing experience! Enjoy the intuitive TouchDrive controls as you take the wheel of the most prestigious dream cars across 70 gravity-defying tracks. Complete over 800 events in the solo Career mode and face up to 7 players in real time in mu",
                "Tear up the Asphalt in the ultimate console racing experience! Enjoy the intuitive TouchDrive controls as you take the wheel of the most prestigious dream cars across 70 gravity-defying tracks. Complete over 800 events in the solo Career mode and face up to 7 players in real time in mu",
                "Tear up the Asphalt in the ultimate console racing experience! Enjoy the intuitive TouchDrive controls as you take the wheel of the most prestigious dream cars across 70 gravity-defying tracks. Complete over 800 events in the solo Career mode and face up to 7 players in real time in mu",
        };

        mainModels = new ArrayList<>();
        for (int i = 0; i<phpFrameworkLogo.length; i++){
            MainModel model = new MainModel(phpFrameworkLogo[i], phpFrameworkName[i], phpDetail[i]);
            mainModels.add(model);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(
                getContext(), LinearLayoutManager.VERTICAL, false
        );


        phpRecycler.setLayoutManager(layoutManager);
        phpRecycler.setItemAnimator(new DefaultItemAnimator());


        mainAdapter = new MainAdapter(mainModels,getContext());

        phpRecycler.setAdapter(mainAdapter);
        return view;


//        RecyclerView recyclerView = findViewById(R.id.rv_game_seru);
//        RecyclerViewAdapter adapter = new RecyclerViewAdapter(imageGame, namaGame, genreGame, detailGame,this);
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));



//        return inflater.inflate(R.layout.fragment_dashboard, container, false);
    }

}