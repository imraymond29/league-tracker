package imraymond29.leaguetracker;

import android.content.Context;
import android.os.Bundle;
import android.app.Activity;

import android.view.View;

/**
 * Created by raymondlam on 2017-08-31.
 */

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MainView(this));

    }

    public class MainView extends View {
        public MainView(Context context) {
            super(context);

        }
    }

}
