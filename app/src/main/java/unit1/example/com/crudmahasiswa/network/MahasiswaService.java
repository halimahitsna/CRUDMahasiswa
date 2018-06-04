package unit1.example.com.crudmahasiswa.network;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import unit1.example.com.crudmahasiswa.model.Mahasiswa;
import unit1.example.com.crudmahasiswa.model.MahasiswaResult;

public interface MahasiswaService {

    @GET("mahasiswa")
    Call<MahasiswaResult> getMahasiswas();

    @GET("mahasiswa/{id}")
    Call<MahasiswaResult> getMahasiswasId(@Path("id") int id);

    @POST("mahasiswa")
    Call<String> setMahasiswa(@Body Mahasiswa mahasiswa);

    @DELETE("mahasiswa/{id}")
    Call<String> hapusMahasiswa(@Path("id") int id);
}
