package francisco.paniagua.interfazusuarioflexibleconfragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class MensualFragment extends Fragment {


    public MensualFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mensual, container, false);
    }

    public interface OnSemanaCambiada{
        public void SemanaCambiado(String semana);
    }

}
