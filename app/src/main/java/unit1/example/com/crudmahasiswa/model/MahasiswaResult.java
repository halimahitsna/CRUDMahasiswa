package unit1.example.com.crudmahasiswa.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MahasiswaResult {

    @SerializedName("mahasiswas")
    @Expose
    private List<Mahasiswa> mahasiswas = null;

    public List<Mahasiswa> getMahasiswas() {
        return mahasiswas;
    }

    public void setMahasiswas(List<Mahasiswa> mahasiswas) {
        this.mahasiswas = mahasiswas;
    }

}
