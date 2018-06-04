package unit1.example.com.crudmahasiswa;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import unit1.example.com.crudmahasiswa.adapter.MahasiswaAdapter;
import unit1.example.com.crudmahasiswa.model.Mahasiswa;
import unit1.example.com.crudmahasiswa.model.MahasiswaResult;
import unit1.example.com.crudmahasiswa.network.ApiClient;
import unit1.example.com.crudmahasiswa.network.MahasiswaService;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mahasiswa> mahasiswaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1. Menyiapkan sumber data
        //2. Data POJO
        //3. Adapter (mengkomunikasikan sumber data dengan tampilan)
        //4. Tampilan

        //inisialisasi
        final ListView lvuser = (ListView)findViewById(R.id.lv_user);
        //ImageView img =(ImageView)findViewById(R.id.gbr_coba);
        //RecyclerView rvuser = (RecyclerView)findViewById(R.id.rv_mahasiswa);
        FloatingActionButton Fadd = (FloatingActionButton)findViewById(R.id.fab_add_mahasiswa);

        //muat gbr dr URL
//        int SDK = Build.VERSION.SDK_INT;
//        if(SDK > 8){
//            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
//            StrictMode.setThreadPolicy(policy);
//
//            try {
//                URL url = new URL("https://picsum.photos/200/300?random");
//                Bitmap bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
//                img.setImageBitmap(bitmap);
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
        //Picasso.with(this).load("https://picsum.photos/200/300?random").into(img);

        //2.a. 1 data
        String[] user = new String[]{"Halimah", "Itsna", "Wardany"};
        ArrayList<String> users = new ArrayList<>();
        users.add("User 1");
        users.add("User 2");
        users.add("User 3");
        users.add("User 4");
        users.add("User 5");
        ArrayAdapter<String> userAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, users);

        //2.b. POJO (Plain Old Java Object)
//        Mahasiswa mahasiswa = new Mahasiswa();
//        mahasiswa.setNama("Halimah");
//        mahasiswa.setNim("3.34.15.0.10");
//        mahasiswa.setEmail("halimah@gmail.com");
//        mahasiswa.setFoto("https://picsum.photos/200/300?random");
//
//        Mahasiswa mahasiswa1 = new Mahasiswa();
//        mahasiswa1.setNama("Itsna");
//        mahasiswa1.setNim("3.34.15.0.10");
//        mahasiswa1.setEmail("itsna@gmail.com");
//        mahasiswa1.setFoto("https://picsum.photos/200/300?random");
//
//
//        mahasiswaList = new ArrayList<>();
//        mahasiswaList.add(mahasiswa);
//        mahasiswaList.add(mahasiswa1);

        //2.c. Sumber Data Dari API /JSON Object dr internet
        MahasiswaService mService = ApiClient.getmRetrofit().create(MahasiswaService.class);

        Call<MahasiswaResult> mahasiswaServiceCall = mService.getMahasiswas();
        mahasiswaServiceCall.enqueue(new Callback<MahasiswaResult>() {
            @Override
            public void onResponse(Call<MahasiswaResult> call, Response<MahasiswaResult> response) {
                Toast.makeText(getApplicationContext(), "Jumlah data: " +response.body().getMahasiswas().size(), Toast.LENGTH_LONG).show();
                MahasiswaResult jsonResponse = response.body();
                List<Mahasiswa> mahasiswas = jsonResponse.getMahasiswas();
                MahasiswaAdapter mahasiswaAdapter = new MahasiswaAdapter(getApplicationContext(), 0, mahasiswas);
                lvuser.setAdapter(mahasiswaAdapter);
            }

            @Override
            public void onFailure(Call<MahasiswaResult> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Gagal Ambil Data Mahasiswa", Toast.LENGTH_SHORT).show();

            }
        });

        //Adapter
        //MahasiswaAdapter mahasiswaAdapter = new MahasiswaAdapter(this, 0, mahasiswaList);

        //lvuser.setAdapter(mahasiswaAdapter);
        //rvuser.setHasFixedSize(true);
        //RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        //rvuser.setItemAnimator(new DefaultItemAnimator());
        //rvuser.setLayoutManager(layoutManager);
        //rvuser.setAdapter(mahasiswaAdapter);
    }
}
