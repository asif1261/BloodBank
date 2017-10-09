package com.example.user.bloodbank;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DonorList extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private RecyclerView recyclerView;
    private DatabaseReference myRef;

    //private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_list);

       // FirebaseUser user = firebaseAuth.getCurrentUser();

        myRef= FirebaseDatabase.getInstance().getReference().child("donors");

        recyclerView = (RecyclerView)findViewById(R.id.donorlist_recyclerview) ;
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerAdapter<Donor,DonorViewHolde> adapter = new FirebaseRecyclerAdapter<Donor, DonorViewHolde>(
                Donor.class,
                R.layout.donorlist_custom,
                DonorViewHolde.class,
                myRef

        )

        {
            @Override
            protected void populateViewHolder(DonorViewHolde viewHolder, Donor model, int position) {
                viewHolder.setName(model.getName());
                viewHolder.setBloodGroup(model.getBloodGroup());
                viewHolder.setSex(model.getSex());
                viewHolder.setAge(model.getAge());
                viewHolder.setAddress(model.getAddress());
                viewHolder.setContactNumber(model.getContactNumber());
            }

        };

        Toast.makeText(DonorList.this, "Information Loading...", Toast.LENGTH_SHORT).show();

        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    public static class DonorViewHolde extends RecyclerView.ViewHolder {

        TextView text_name,text_bloodGroup,text_sex,text_age,text_address,text_contactNumber;
        ImageView imageView;
        public DonorViewHolde(View itemView) {
            super(itemView);

            text_name =(TextView)itemView.findViewById(R.id.list_name);
            text_bloodGroup =(TextView)itemView.findViewById(R.id.list_blood_group);
            text_sex =(TextView)itemView.findViewById(R.id.list_gender);
            text_age =(TextView)itemView.findViewById(R.id.list_age);
            text_address =(TextView)itemView.findViewById(R.id.list_address);
            text_contactNumber =(TextView)itemView.findViewById(R.id.list_contact);
            imageView =(ImageView)itemView.findViewById(R.id.donorlist_avatar);

        }

        public void setName(String name) {
            text_name.setText(name);
        }

        public void setBloodGroup(String bloodGroup) {
            text_bloodGroup.setText(bloodGroup);
        }

        public void setSex(String sex) {
            text_sex.setText(sex);
        }

        public void setAge(String age) {
            text_age.setText(age);
        }

        public void setAddress(String address) {
            text_address.setText(address);
        }

        public void setContactNumber(String contactNumber) {
            text_contactNumber.setText(contactNumber);
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
      //  getMenuInflater().inflate(R.menu.menu_item, menu);

        //MenuItem item = menu.findItem(R.id.action_search);
        //SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
//        searchView.setQueryHint("Search In Your City");
       // searchView.setQueryHint(Html.fromHtml("<font color = #ffffff>" + getResources().getString(R.string.hintSearchMess) + "</font>"));

       // searchView.setOnQueryTextListener(DonorList.this);

        return super.onCreateOptionsMenu(menu);
    }

}
