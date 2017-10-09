package com.example.user.bloodbank;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.List;

public class OrganizationList extends AppCompatActivity {

    MaterialSearchView searchView;


   // List<Data>data = fill_with_data();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organization_list);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Organization List");
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));
        searchView = (MaterialSearchView)findViewById(R.id.search_view);
        searchView.setSuggestions(getResources().getStringArray(R.array.query_suggestions));
        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(newText !=null && !newText.isEmpty()){
                    List<Data> lstFound = new ArrayList<>();
                    for(Data item:fill_with_data()){
                            lstFound.add(item);
                    }
                }
                return false;
            }
        });
        searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {

            }

            @Override
            public void onSearchViewClosed() {
                final List<Data>data = fill_with_data();
                final RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
                Recycler_View_Adapter adapter = new Recycler_View_Adapter(data, getApplication());
                recyclerView.setAdapter(adapter);
            }
        });
        searchView.setVoiceSearch(true);

        final List<Data>data = fill_with_data();
        final RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        Recycler_View_Adapter adapter = new Recycler_View_Adapter(data, getApplication());
        recyclerView.setAdapter(adapter);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_item, menu);

        MenuItem item = menu.findItem(R.id.action_search);
        searchView.setMenuItem(item);
        //searchView = (MaterialSearchView)item.getActionView();

        return true;
    }


    private List<Data> fill_with_data() {

        List<Data>data = new ArrayList<>();

        data.add(new Data("Name: Redcrecent Society", "Address: Dhaka", "City: Dhaka", "Mobile: 01676299805", R.drawable.orgg));
        data.add(new Data("Name: Redcrecent Society", "Address: Dhaka", "City: Dhaka", "Mobile: 01676299805", R.drawable.orgg));
        data.add(new Data("Name: Redcrecent Society", "Address: Dhaka", "City: Dhaka", "Mobile: 01676299805", R.drawable.orgg));
        data.add(new Data("Name: Redcrecent Society", "Address: Dhaka", "City: Dhaka", "Mobile: 01676299805", R.drawable.orgg));
        data.add(new Data("Name: Redcrecent Society", "Address: Dhaka", "City: Dhaka", "Mobile: 01676299805", R.drawable.orgg));
        data.add(new Data("Name: Redcrecent Society", "Address: Dhaka", "City: Dhaka", "Mobile: 01676299805", R.drawable.orgg));
        data.add(new Data("Name: Redcrecent Society", "Address: Dhaka", "City: Khulna", "Mobile: 01676299805", R.drawable.orgg));


        return data;
    }
}
