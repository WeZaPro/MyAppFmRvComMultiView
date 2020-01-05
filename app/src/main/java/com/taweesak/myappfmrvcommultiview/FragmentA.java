package com.taweesak.myappfmrvcommultiview;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

//Todo Step 2 ==> Create FM A
public class FragmentA extends Fragment {

    // Set data ArrayList
    // Set Rv Layout
    // Set Adapter
    // set Listener (Interface)
    // onAttact Listener
    // onDetact Listener

    View v;
    MyAdapter myAdapter;
    RecyclerView _myRecycylerView;
    ArrayList<MyChidModel> listData = new ArrayList<>();
    MyListener listener;
    MyChidModel myChidModel;

    public FragmentA() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // check v = null
        if( v == null){
            v = inflater.inflate(R.layout.fragment_a, container, false);

            setRecyclerviewLayout(v);
            setMyData();
            setMyAdapter();

        }
        return v;
    }



    private void setRecyclerviewLayout(View v) {
        _myRecycylerView = v.findViewById(R.id.myRecyclerView);
        _myRecycylerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private void setMyData() {

        double rate[] = {100,200,300,400,500,600,700,800,900};
        int image[] = {R.drawable.brazil,R.drawable.ghana,R.drawable.island,
                R.drawable.japan,R.drawable.polynesia,R.drawable.southkorea,
                R.drawable.spain,R.drawable.unitedkingdom,R.drawable.usa};
        String country[] = {"brazil","ghana","island","japan","polynesia",
                "southkorea","spain","unitedkingdom","usa"};
        int Type[] = {0,1,0,1,0,1,0,1,0};

        String setTextText[] = {"R.drawable.brazil","R.drawable.ghana","R.drawable.island",
                "R.drawable.japan","R.drawable.polynesia","R.drawable.southkorea",
                "R.drawable.spain","R.drawable.unitedkingdom","R.drawable.usa"};

        int dataSize = image.length;

        for (int i = 0; i < dataSize; i++) {
            MyChidModel myChidModel;
            myChidModel = new MyChidModel(rate[i],image[i],country[i],setTextText[i],Type[i]);
            listData.add(myChidModel);
        }
    }

    private void setMyAdapter() {
        myAdapter = new MyAdapter(getActivity(),listData,listener);
        _myRecycylerView.setAdapter(myAdapter);
    }

}
