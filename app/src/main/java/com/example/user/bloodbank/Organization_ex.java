package com.example.user.bloodbank;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class Organization_ex extends AppCompatActivity implements SearchView.OnQueryTextListener {

    MyRecAdapter myRecAdapter;
    RecyclerView recyclerView;
    List<Post> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organization_ex);
        recyclerView = (RecyclerView) findViewById(R.id.myrec);
        createdata();
        myRecAdapter = new MyRecAdapter(list, Organization_ex.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(Organization_ex.this));
        recyclerView.setAdapter(myRecAdapter);

    }

    void createdata() {
    // myRecAdapter.notifyDataSetChanged();
        list = new ArrayList<>();
        list.add(new Post("Name: A Voluntary Blood Donor Organization", "Address: TSC, Dhaka University", "City: Dhaka", "Phone: 8629042, 01711025876", R.drawable.orgg));
        list.add(new Post("Name: Islami Bank Hospital", "Address: Kakril, Dhaka", "City: Dhaka", "Phone: 8317090, 8321495", R.drawable.orgg));
        list.add(new Post("Name: Quantum Lab", "Address: 119, Shantinagar", "City: Dhaka", "Phone: 9351969, 8322987, 01714010869", R.drawable.orgg));
        list.add(new Post("Name: Red Crescent Blood Center", "Address: 7/5, Aurangzeb Road, Mohammadpur", "City: Dhaka", "Phone: 9116563, 8121497", R.drawable.orgg));
        list.add(new Post("Name: Sir Salimullah Medical College & Mitford Hospital Unit", "Address: Sir Salimullah Medical College & Mitford Hospital", "City: Dhaka", "Phone: 7319123, 9668690, 01819284878", R.drawable.orgg));
        list.add(new Post("Name: Bangladesh Medical College Unit", "Address: Dhanmondi", "City: Dhaka", "Phone: 0152371531, 0152423441", R.drawable.orgg));
        list.add(new Post("Name: Dental College Unit", "Address: Mirpur-14", "City: Dhaka", "Phone: 9011887", R.drawable.orgg));
        list.add(new Post("Name: Dhaka Medical College Hospital Unit", "Address: Dhaka Medical College Hospital", "City: Dhaka", "Phone: 9668690, 8616744, 9663429, 01819284878", R.drawable.orgg));
        list.add(new Post("Name: Mymensingh Medical College Unit", "Address: Mymensingh Medical College", "City: Mymensingh", "Phone: 091-54829", R.drawable.orgg));
        list.add(new Post("Name: Sandhani Central SMMU Unit", "Address: 34, Tinshed Building, Out DOOR, BSMMU, Shahbag", "City: Dhaka", "Phone: 8621658", R.drawable.orgg));
        list.add(new Post("Name: Rangpur Medical College Unit", "Address: Rangpur Sadar", "City: Rangpur", "Phone: 52165180", R.drawable.orgg));
        list.add(new Post("Name: Shahid Ziaur Rahman Medical College (Unit- Bogra)", "Address: Bogra", "City: Bogra", "Phone: 644-5100295", R.drawable.orgg));
        list.add(new Post("Name: Dinajpur Medical College Unit", "Address: Dinajpur", "City: Dinajpur", "Phone: 0531-478", R.drawable.orgg));
        list.add(new Post("Name: Rajshahi Medical College Unit", "Address: Rajshahi", "City: Rajshahi", "Phone: 0721-52165180, 01721773080", R.drawable.orgg));
        list.add(new Post("Name: Begum Tayeeba Mojumder Red Crescent Blood Centre", "Address: Paharpur, Dinajpur", "City: Dinajpur", "Phone: 0531-64021", R.drawable.orgg));
        list.add(new Post("Name: Chittagong Mrdical College", "Address: Chittagong", "City: Chittagong", "Phone: 616891-94, 94616199", R.drawable.orgg));
        list.add(new Post("Name: Fatema Begum Red Crescent Blood Center", "Address: 395, Anderkilla, Chittagong", "City: Chittagong", "Phone: 031-620685, 612395, 620926", R.drawable.orgg));
        list.add(new Post("Name: Sher-E-Bangla Medical College", "Address: South Alekanda, Band Road, Barisal", "City: Barisal", "Phone: +8804312173547", R.drawable.orgg));
        list.add(new Post("Name: Sandhani", "Address: Khulna Medical College Unit. Khulna", "City: Khulna", "Phone: 041-761509", R.drawable.orgg));
        list.add(new Post("Name: Blood Bank", "Address: Khulna Sadar", "City: Khulna", "Phone: 762006", R.drawable.orgg));
        list.add(new Post("Name: AHAD RED CRESCENT BLOOD CENTRE", "Address: Munshi Mehabullah Road, Jessore", "City: Jessore", "Phone: 0421 73100,73450", R.drawable.orgg));
        list.add(new Post("Name: Sandhani", "Address: Sylhet Osmani Medical College Unit, Sylhet", "City: Sylhet", "Phone: 0821-710880", R.drawable.orgg));
        list.add(new Post("Name: Sandhani", "Address: Jalalabad Ragib Rabeya Medical College Unit, Sylhet", "City: Sylhet", "Phone: 0821-710880", R.drawable.orgg));
        list.add(new Post("Name: RBC Blood", "Address: haque building, 2nd floor, jail rood point, Sylhet", "City: Sylhet", "Mobile: 01781428000, 01745402211", R.drawable.orgg));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);

        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
//        searchView.setQueryHint("Search In Your City");
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
//
//            }
            if(text1.contains(query)){
                filteredModelList.add(model);
            }
        }
        createdata();
        myRecAdapter = new MyRecAdapter(filteredModelList, Organization_ex.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(Organization_ex.this));
        recyclerView.setAdapter(myRecAdapter);
        myRecAdapter.notifyDataSetChanged();
        return filteredModelList;
    }
}
