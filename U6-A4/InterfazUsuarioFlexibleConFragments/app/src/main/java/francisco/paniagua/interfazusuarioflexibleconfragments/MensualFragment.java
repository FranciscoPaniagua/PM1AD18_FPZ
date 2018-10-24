package francisco.paniagua.interfazusuarioflexibleconfragments;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class MensualFragment extends Fragment {
   private OnSemanaCambiada activityObservadora;
    private Button btnsemana1_card,btnsemana2_card,btnsemana3_card,btnsemana4_card;
    public MensualFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_mensual, container, false);
        btnsemana1_card=(Button)view.findViewById(R.id.btnsemana1_card);
        btnsemana2_card=(Button)view.findViewById(R.id.btnsemana2_card);
        btnsemana3_card=(Button)view.findViewById(R.id.btnsemana3_card);
        btnsemana4_card=(Button)view.findViewById(R.id.btnsemana4_card);

        btnsemana1_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityObservadora.SemanaCambiado("Sem1");
            }
        });


        btnsemana2_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityObservadora.SemanaCambiado("Sem2");
            }
        });


        btnsemana3_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityObservadora.SemanaCambiado("Sem3");
            }
        });


        btnsemana4_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityObservadora.SemanaCambiado("Sem4");
            }
        });
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        activityObservadora=(OnSemanaCambiada)activity;
    }

    public interface OnSemanaCambiada{
        public void SemanaCambiado(String semana);
    }

}
