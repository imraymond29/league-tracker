package imraymond29.leaguetracker;

import android.content.Context;
import android.os.Bundle;
import android.app.Activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by raymondlam on 2017-08-31.
 */

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MainView(this));

    }

    public class MainView extends RelativeLayout {
        ImageView logoImageView;
        Button loginButton;
        TextView userTextView;
        EditText userEditText;
        TextView passwordTextView;
        EditText passwordEditText;

        public MainView(Context context) {
            super(context);
            logoImageView = new ImageView(context);
            addView(logoImageView);

            loginButton = new Button(context);
            addView(loginButton);

            userTextView = new TextView(context);
            addView(userTextView);

            userEditText = new EditText(context);
            addView(userEditText);

            passwordTextView = new TextView(context);
            addView(passwordTextView);

            passwordEditText = new EditText(context);
            addView(passwordEditText);

        }
    }

}
