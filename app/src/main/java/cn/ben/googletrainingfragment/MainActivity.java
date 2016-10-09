package cn.ben.googletrainingfragment;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cn.ben.googletrainingfragment.fragment.ArticleFragment;

public class MainActivity extends AppCompatActivity implements ArticleFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_article);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
