package unit1.example.com.crudmahasiswa.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import unit1.example.com.crudmahasiswa.R;
import unit1.example.com.crudmahasiswa.model.Mahasiswa;

/*
public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.ViewHolder> {
    private ArrayList<Mahasiswa> mahasiswas;
    private Context context;

    public MahasiswaAdapter(Context context, ArrayList<Mahasiswa> mahasiswa) {
        this.mahasiswas = mahasiswa;
        this.context = context;
    }

    @Override
    public MahasiswaAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_mahasiswa, viewGroup, false);
        return new MahasiswaAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MahasiswaAdapter.ViewHolder viewHolder, int position) {
        Picasso.with(context).load(mahasiswas.get(position).getFoto()).resize(150,150).placeholder(R.mipmap.ic_launcher).into(viewHolder.tFoto);
        viewHolder.tNama.setText(mahasiswas.get(position).getNama());
        viewHolder.tNim.setText(mahasiswas.get(position).getNim());
        viewHolder.tEmail.setText(mahasiswas.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return mahasiswas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tNama, tNim, tEmail;
        ImageView tFoto;
        public ViewHolder(View view) {
            super(view);

            tNama = view.findViewById(R.id.tnama);
            tNim = view.findViewById(R.id.tnim);
            tEmail = view.findViewById(R.id.temail);
            tFoto = view.findViewById(R.id.img);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }
    }
}
*/

public class MahasiswaAdapter extends ArrayAdapter<Mahasiswa> {

    List<Mahasiswa> mahasiswas;
    Context context;

    public MahasiswaAdapter(@NonNull Context context, int resource, @NonNull List<Mahasiswa> objects) {
        super(context, resource, objects);
        this.mahasiswas = objects;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView (int position, @Nullable View convertView, @NonNull ViewGroup parent){
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_mahasiswa, parent,false);
        }
        TextView tNama = convertView.findViewById(R.id.tnama);
        TextView tNim = convertView.findViewById(R.id.tnim);
        TextView tEmail = convertView.findViewById(R.id.temail);
        ImageView tFoto = convertView.findViewById(R.id.img);
        if(mahasiswas.get(position).getFoto() != null) {
            Picasso.with(context).load("http://192.168.43.172:8012/LaraSort/"+mahasiswas.get(position).getFoto()).resize(150, 150).placeholder(R.mipmap.ic_launcher)
                    .into(tFoto);
        }else {
          Picasso.with(context).load(R.mipmap.ic_launcher).resize(150, 150).into(tFoto);
        }
        tNama.setText(mahasiswas.get(position).getNama());
        tNim.setText(mahasiswas.get(position).getNim());
        tEmail.setText(mahasiswas.get(position).getEmail());

        return convertView;
    }
}
