package com.example.dell.askme;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */



public class HomeFragment extends Fragment {

ListView listView;



    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

      View view = inflater.inflate(R.layout.fragment_home, container, false);
      /*  listView =(ListView)view.findViewById(R.id.list);

        String[] listid ={"profile1","profile2"};  //Enter profile id here in text...list is clickable
        ListAdapter adapter = new ListAdapter(this,listid);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {@Override
        public void onItemClick(AdapterView<?> a, View v, int position, long id) {
            //do ur work here when list row selected
        }
        }); */
        return view;

    }


}

