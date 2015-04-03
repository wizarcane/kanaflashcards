package erik.lim.kanaflashcards.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import erik.lim.kanaflashcards.R;
import erik.lim.kanaflashcards.model.Kana;

/**
 * Created by erikgabriellim on 4/3/15.
 */
public class KanaFragment extends Fragment {

    private static final String KEY_SYLLABLE = "key_syllable";
    private Kana syllable;

    public static KanaFragment newInstance(Kana syllable) {
        KanaFragment f = new KanaFragment();
        f.setSyllable(syllable);
        return f;
    }

    public void setSyllable(Kana syllable) {
        this.syllable = syllable;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        TextView v  = (TextView)inflater.inflate(R.layout.fragment_kana, container, false);

        if (savedInstanceState != null)
            syllable = savedInstanceState.getParcelable(KEY_SYLLABLE);

        v.setText(syllable.syllable);
        v.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), syllable.romaji, Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(KEY_SYLLABLE, syllable);
    }
}
