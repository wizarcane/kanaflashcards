package erik.lim.kanaflashcards.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import erik.lim.kanaflashcards.R;
import erik.lim.kanaflashcards.database.DatabaseHelper;
import erik.lim.kanaflashcards.fragments.KanaFragment;
import erik.lim.kanaflashcards.model.Kana;


public class MainActivity extends ActionBarActivity {

    private ViewPager viewpager;
    private KanaFragmentStatePagerAdapter syllableAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewpager       =   (ViewPager) findViewById(R.id.viewpager);
        syllableAdapter =   new KanaFragmentStatePagerAdapter(getSupportFragmentManager());
        syllableAdapter.setSyllableArrayResource(DatabaseHelper.getInstance(this).getKana());
        viewpager.setAdapter(syllableAdapter);

    }

    class KanaFragmentStatePagerAdapter extends FragmentStatePagerAdapter {

        private List<Kana> syllableArray = new ArrayList<Kana>();

        public KanaFragmentStatePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void setSyllableArrayResource(List<Kana> kanaList) {
            this.syllableArray = kanaList;
            Collections.shuffle(syllableArray);
            notifyDataSetChanged();
        }

        @Override
        public Fragment getItem(int i) {
            return KanaFragment.newInstance(syllableArray.get(i));
        }

        @Override
        public int getCount() {
            return syllableArray.size();
        }
    }
}
