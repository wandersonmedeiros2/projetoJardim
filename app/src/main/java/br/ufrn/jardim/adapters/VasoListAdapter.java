package br.ufrn.jardim.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.ufrn.jardim.appjardim.R;
import br.ufrn.jardim.modelo.Vaso;

/**
 * Created by wanderson on 21/04/15.
 */
public class VasoListAdapter extends ArrayAdapter<Vaso> {

    private Context context;
    private List<Vaso> values;

    public VasoListAdapter(Context context, List<Vaso> vasos) {
        super(context, R.layout.vaso_adapter_layout, vasos);

        this.context = context;
        this.values = vasos;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View linhaVasoAdapter = inflater.inflate(R.layout.vaso_adapter_layout,parent,false);

        ImageView imagemPlanta   = (ImageView) linhaVasoAdapter.findViewById(R.id.iconeAlerta);
        ImageView imagemUmidAr   = (ImageView) linhaVasoAdapter.findViewById(R.id.imagemUmidAr);
        ImageView imagemUmidSolo = (ImageView) linhaVasoAdapter.findViewById(R.id.imagemUmidSolo);
        ImageView imagemTemp     = (ImageView) linhaVasoAdapter.findViewById(R.id.imageTemp);
        ImageView imagemLuz      = (ImageView) linhaVasoAdapter.findViewById(R.id.imageLuz);

        TextView lbDescrcao = (TextView) linhaVasoAdapter.findViewById(R.id.labelDescricao);
        TextView lbUmidAr   = (TextView) linhaVasoAdapter.findViewById(R.id.labelumidadear);
        TextView lbUmidSolo = (TextView) linhaVasoAdapter.findViewById(R.id.labelUmidadeSolo);
        TextView lbTemp     = (TextView) linhaVasoAdapter.findViewById(R.id.labelTemp);
        TextView lbLuz      = (TextView) linhaVasoAdapter.findViewById(R.id.labelLuz);

        imagemUmidAr.setImageResource(R.drawable.umid_ar);
        imagemUmidSolo.setImageResource(R.drawable.umid_solo);
        imagemTemp.setImageResource(R.drawable.temp);
        imagemLuz.setImageResource(R.drawable.sol);


        Vaso vaso = this.values.get(position);

        if(vaso.getImagem() == ""){
            imagemPlanta.setImageResource(R.drawable.jardim);
        }
        else
            imagemPlanta.setImageResource(R.drawable.jardim);

        lbDescrcao.setText(vaso.getDescricao());
        lbUmidAr.setText(String.valueOf(vaso.getUmidadeAr()));
        lbUmidSolo.setText(String.valueOf(vaso.getUmidadeSolo()));
        lbTemp.setText(String.valueOf(vaso.getTemperatura()));
        lbLuz.setText(String.valueOf(vaso.getLuminosidade()));

        return linhaVasoAdapter;

    }
}
