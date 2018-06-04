package unit1.example.com.crudmahasiswa.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static String BASE_URL = "http://192.168.43.172:8012/LaraSort/public/"; //Use ststic IP

    private static Retrofit mRetrofit;

    public static Retrofit getmRetrofit(){
        if(mRetrofit == null){
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return mRetrofit;
    }
}
