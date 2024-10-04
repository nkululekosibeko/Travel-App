package com.android.travelapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity {
    TextView txtNama, txtEmail;
    Button checkTickets;

    AlertDialog alertDialog;
    MenuInflater inflater;

    private ArrayList<String> al_img_tour = new ArrayList<>();
    private ArrayList<String> al_name_tour = new ArrayList<>();
    private ArrayList<String> al_desc_tour = new ArrayList<>();
    private ArrayList<Integer> al_price_tour = new ArrayList<>();
    private ArrayList<String> al_location = new ArrayList<>();

    SharedPreferences preferences;

    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PHONE = "phone";
    private static final String KEY_TOTAL_PRICE = "total_price";
    private static final String KEY_NAME_TOUR = "name_tour";
    private static final String KEY_COUNT_ITEMS = "count_items";

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        txtNama = findViewById(R.id.tv_fullname);
        txtEmail = findViewById(R.id.tv_email);
        checkTickets = findViewById(R.id.check_ticket);

        checkTickets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameView = preferences.getString(KEY_NAME, null);
                String emailView = preferences.getString(KEY_EMAIL, null);
                String phoneView = preferences.getString(KEY_PHONE, null);

                String nameTourView = preferences.getString(KEY_NAME_TOUR, null);
                String totalItemsView = preferences.getString(KEY_COUNT_ITEMS, null);
                String totalPriceView = preferences.getString(KEY_TOTAL_PRICE, null);

                if (nameView == "" || emailView == "" || phoneView == "" || nameTourView == "" || totalItemsView == "" || totalPriceView == "" ||
                        nameView == null || emailView == null || phoneView == null || nameTourView == null || totalItemsView == null || totalPriceView == null) {
                    AlertDialog dialog = new AlertDialog.Builder(Dashboard.this)
                            .setTitle("Check Tickets")
                            .setMessage("\nData is Empty")
                            .setIcon(android.R.drawable.ic_dialog_info)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent = new Intent(Dashboard.this, Dashboard.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }).show();
                }else if (nameView == nameView || emailView == emailView || phoneView == phoneView || nameTourView == nameTourView || totalItemsView == totalItemsView || totalPriceView == totalPriceView){
                    Intent intent = new Intent(Dashboard.this, Tickets.class);
                    startActivity(intent);
                }
            }
        });

        preferences = getSharedPreferences("userInfo", 0);

        String namaView = preferences.getString(KEY_NAME, null);
        String emailView = preferences.getString(KEY_EMAIL, null);

        if (namaView != null || emailView != null){
            txtNama.setText(namaView);
            txtEmail.setText(emailView);
        }

        getData();

        toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
    }

    private void getData() {

        al_img_tour.add("https://www.rentalmobilbali.net/wp-content/uploads/2016/05/Pantai-Pandawa-Kutuh.jpg");
        al_name_tour.add("Durban - Cape Town");
        al_desc_tour.add(" Located in the V&A Waterfront, this luxurious hotel offers stunning views of Table Mountain and the harbor. Enjoy elegant rooms, a spa, and world-class dining options.");
        al_price_tour.add(1250);
        al_location.add("The Table Bay Hotel, Cape Town, South Africa");


        al_img_tour.add("https://www.rentalmobilbali.net/wp-content/uploads/2016/05/Objek-Wisata-Kuta-Bali.jpg");
        al_name_tour.add("Durban - Cape Town");
        al_desc_tour.add("The Silo Hotel offers opulent accommodations, an art gallery, and breathtaking views of the city. Perfect for those looking for a unique experience in Cape Town.");
        al_price_tour.add(1800);
        al_location.add("The Silo Hotel, Cape Town, South Africa");


        al_img_tour.add("https://www.rentalmobilbali.net/wp-content/uploads/2016/05/Tanah-Lot-Tabanan-Bali.jpg");
        al_name_tour.add("Mpumalanga - Cape Town");
        al_desc_tour.add("Set against the backdrop of Table Mountain, this luxury resort offers spacious rooms, a world-class spa, and renowned dining experiences. An ideal getaway for relaxation and indulgence.");
        al_price_tour.add(2200);
        al_location.add("One&Only Cape Town, Cape Town, South Africa");



        al_img_tour.add("https://www.rentalmobilbali.net/wp-content/uploads/2016/03/Sunset-Pura-Uluwatu.jpg");
        al_name_tour.add("Cape Town - Durban");
        al_desc_tour.add("Nestled within a coastal forest, Zimbali Resort provides a tranquil escape with luxurious accommodations, golf courses, and access to pristine beaches. A perfect blend of nature and comfort.");
        al_price_tour.add(950);
        al_location.add("Zimbali Resort, Ballito, South Africa");


        al_img_tour.add("https://www.rentalmobilbali.net/wp-content/uploads/2013/11/tanjung-benoa-watersport.jpg");
        al_name_tour.add("Northern Cape - Durban");
        al_desc_tour.add("Situated in Umhlanga, this iconic hotel features elegant rooms with ocean views, fine dining, and a luxurious spa. Experience a blend of relaxation and sophistication by the sea.");
        al_price_tour.add(1500);
        al_location.add("The Beverly Hills Hotel, Umhlanga, South Africa");


        al_img_tour.add("https://www.rentalmobilbali.net/wp-content/uploads/2016/05/Objek-Wisata-Pura-Ulun-Danu-Bedugul.jpg");
        al_name_tour.add("Cape Town - Joburg");
        al_desc_tour.add("This award-winning hotel in Johannesburg offers luxurious accommodations, a world-class spa, and fine dining. Perfect for those seeking elegance and tranquility in a vibrant city.");
        al_price_tour.add(2500);
        al_location.add("Saxon Hotel, Villas & Spa, Johannesburg, South Africa");


        al_img_tour.add("https://ecs7.tokopedia.net/blog-tokopedia-com/uploads/2020/06/Pantai-Parai-Tenggiri.jpg");
        al_name_tour.add("Mpumalange - Durban");
        al_desc_tour.add("Overlooking the Indian Ocean, The Oyster Box in Umhlanga features elegant rooms, exceptional dining, and a stunning pool. A historic hotel perfect for a romantic getaway or family vacation.");
        al_price_tour.add(30000);
        al_location.add("The Oyster Box, Umhlanga, South Africa");


        al_img_tour.add("https://ecs7.tokopedia.net/blog-tokopedia-com/uploads/2020/06/Nusa-Dua-Bali.jpg");
        al_name_tour.add("Swaliland - Joburg");
        al_desc_tour.add("Known for its luxury and privacy, this hotel features opulent suites, a tranquil spa, and exquisite dining. A serene oasis in the bustling heart of Johannesburg.");
        al_price_tour.add(1000);
        al_location.add("The Saxon Hotel, Johannesburg, South Africa");


        al_img_tour.add("https://ecs7.tokopedia.net/blog-tokopedia-com/uploads/2020/06/gunung-rinjani.jpg");
        al_name_tour.add("Northern Cape - Cape Town");
        al_desc_tour.add("This stunning hotel offers breathtaking ocean views, a luxurious spa, and a perfect location near Cape Town's top attractions. Ideal for both business and leisure travelers.");
        al_price_tour.add(2500);
        al_location.add("Radisson Blu Hotel Waterfront, Cape Town, South Africa");


        al_img_tour.add("https://ecs7.tokopedia.net/blog-tokopedia-com/uploads/2018/11/danau-toba.jpg");
        al_name_tour.add("Danau Toba");
        al_desc_tour.add(" Located in the Kalahari Desert, Tswalu offers exclusive luxury lodges, exceptional game viewing, and a focus on sustainability. A unique safari experience for nature enthusiasts. ");
        al_price_tour.add(3000);
        al_location.add("Danau Toba, Sumatra Utara");

        RecycleViewAdapterProcess();

    }

    private void RecycleViewAdapterProcess() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecycleViewAdapter adapter = new RecycleViewAdapter(al_img_tour, al_name_tour, al_desc_tour, al_price_tour, al_location, this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.bar_call_center:
                callCenter();
                return true;
            case R.id.bar_email:
                emailCenter();
                return true;
            case R.id.bar_loc:
                getLoc();
                return true;
            case R.id.bar_edit_user:
                editUser();
                return true;
            case R.id.bar_logout:
                getLogout();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void callCenter() {
        alertDialog = new AlertDialog.Builder(Dashboard.this)
                .setIcon(android.R.drawable.ic_dialog_dialer)
                .setTitle("Call Center")
                .setMessage("\n0645458914")
                .setNeutralButton("Call", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Uri uri = Uri.parse("0766093558");
                        Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                        intent.setData(Uri.fromParts("tel", String.valueOf(uri), null));

                        if (intent.resolveActivity(getPackageManager()) != null){
                            startActivity(intent);
                        }
                    }
                })
                .show();

    }
    private void emailCenter(){
        alertDialog = new AlertDialog.Builder(Dashboard.this)
                .setIcon(android.R.drawable.ic_dialog_email)
                .setTitle("Email")
                .setMessage("\nsmartflying@gmail.com")
                .setNeutralButton("Go to Email", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(Intent.ACTION_SEND );
                        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"fihdanps@gmail.com"});
                        intent.putExtra(Intent.EXTRA_SUBJECT , "Hello");
                        intent.putExtra(Intent.EXTRA_TEXT , "Travel App");
                        intent.setType("message/rfc822");
                        startActivity(Intent.createChooser(intent , "Choose Your Apps : "));
                    }
                })
                .show();

    }
    private void getLoc(){
        alertDialog = new AlertDialog.Builder(Dashboard.this)
                .setIcon(android.R.drawable.ic_dialog_info)
                .setTitle("Location")
                .setMessage("\nDurban, South Beach.")
                .setNeutralButton("Go to Location", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Uri uri2 = Uri.parse("geo:0,0?q="+"Durban, South Beach.");
                        Intent mapIntent = new Intent(Intent.ACTION_VIEW, uri2);
                        mapIntent.setPackage("com.google.android.apps.maps");

                        if(mapIntent.resolveActivity(getPackageManager()) != null){
                            startActivity(mapIntent);
                        }
                    }
                })
                .show();

    }
    private void editUser(){
        Intent intent = new Intent(Dashboard.this, EditUser.class);
        startActivity(intent);

    }
    private void getLogout(){
        Intent intent = new Intent(Dashboard.this, LoginPage.class);
        startActivity(intent);
        finish();
    }
}