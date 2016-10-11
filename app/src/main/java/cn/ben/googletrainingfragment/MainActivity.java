package cn.ben.googletrainingfragment;

import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import cn.ben.googletrainingfragment.fragment.ArticleFragment;
import cn.ben.googletrainingfragment.fragment.HeadlinesFragment;

public class MainActivity extends AppCompatActivity implements ArticleFragment.OnFragmentInteractionListener, HeadlinesFragment.OnFragmentInteractionListener {

    @SuppressWarnings("FieldCanBeLocal")
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_articles);

        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        if (findViewById(R.id.fragment_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Create a new Fragment to be placed in the activity layout
            HeadlinesFragment firstFragment = new HeadlinesFragment();

            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            firstFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, firstFragment).commit();
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void replace(@SuppressWarnings("UnusedParameters") View view) {
        // Create fragment and give it an argument specifying the article it should show
        ArticleFragment newFragment = new ArticleFragment();
        Bundle args = new Bundle();
        position = 1;
        args.putInt(ArticleFragment.ARG_POSITION, position);
        newFragment.setArguments(args);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        transaction.replace(R.id.fragment_container, newFragment);
        transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();
    }
}
