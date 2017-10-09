package com.example.user.bloodbank;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class BloodBankList extends AppCompatActivity implements SearchView.OnQueryTextListener{

    MyRecAdapter myRecAdapter;
    RecyclerView recyclerView;
    List<Post> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organization_ex);
        recyclerView = (RecyclerView) findViewById(R.id.myrec);
        createdata();
        myRecAdapter = new MyRecAdapter(list, BloodBankList.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(BloodBankList.this));
        recyclerView.setAdapter(myRecAdapter);

    }

    void createdata() {
//        myRecAdapter.notifyDataSetChanged();
        list = new ArrayList<>();
        list.add(new Post("Name : Redcrecent Society", "Address : Dhaka", "City : Dhaka", "Mobile : 01676299805", R.drawable.bloodbankpic35));
        list.add(new Post("Name : Redcrecent Society", "Address : Khulna", "City : Khulna", "Mobile : 01676299805", R.drawable.bloodbankpic35));
        list.add(new Post("Name : Redcrecent Society", "Address : Barisal", "City : Barisal", "Mobile : 01676299805", R.drawable.bloodbankpic35));
        list.add(new Post("Name : Redcrecent Society", "Address : Chitagong", "City : Chitagong", "Mobile : 01676299805", R.drawable.bloodbankpic35));
        list.add(new Post("Name : Redcrecent Society", "Address : Jessore", "City : Jessore", "Mobile : 01676299805", R.drawable.bloodbankpic35));
        list.add(new Post("Name  Redcrecent Society", "Address : Comilla", "City : Comilla", "Mobile : 01676299805", R.drawable.bloodbankpic35));
        list.add(new Post("Name : Redcrecent Society", "Address : Gazipur", "City : Gazipur", "Mobile : 01676299805", R.drawable.bloodbankpic35));
        list.add(new Post("Name : Redcrecent Society", "Address : Sylhet", "City : Sylhet", "Mobile : 01676299805", R.drawable.bloodbankpic35));
        list.add(new Post("Name : Redcrecent Society", "Address : Rajshahi", "City : Rajshahi", "Mobile : 01676299805", R.drawable.bloodbankpic35));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);

        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setQueryHint(Html.fromHtml("<font color = #ffffff>" + getResources().getString(R.string.hintSearchMess) + "</font>"));

        searchView.setOnQueryTextListener(this);

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
//        Toast.makeText(MainActivity.this, "Name is : "+query, Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        final List<Post> filteredModelList = filter(list, newText);
        if (filteredModelList.size() > 0) {
            myRecAdapter.setFilter(filteredModelList);
            return true;
        }
//        else {
//            Toast.makeText(Organization_ex.this, "Not Found", Toast.LENGTH_SHORT).show();
//            return false;
//        }
        return false;
    }

    private List<Post> filter(List<Post> models, String query) {
        query = query.toLowerCase();

        final List<Post> filteredModelList = new ArrayList<>();
        for (Post model : models) {
//            final String text = model.getPostTitle().toLowerCase();
            final String text1 = model.getPostCity().toLowerCase();
//            if (text.contains(query)) {
//                filteredModelList.add(model);
//            }
            if(text1.contains(query)){
                filteredModelList.add(model);
            }
        }
        createdata();
        myRecAdapter = new MyRecAdapter(filteredModelList, BloodBankList.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(BloodBankList.this));
        recyclerView.setAdapter(myRecAdapter);
        myRecAdapter.notifyDataSetChanged();
        return filteredModelList;
    }
}
