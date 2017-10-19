package imraymond29.leaguetracker;

import android.content.Context;
import android.os.Bundle;
import android.app.Activity;

import android.support.v4.view.GestureDetectorCompat;
import android.graphics.Color;
import android.text.InputType;
import android.view.GestureDetector;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.util.DisplayMetrics;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by raymondlam on 2017-08-31.
 */

public class MainActivity extends Activity {

    private ImageView backgroundImageView;
    private ImageView logoImageView;
    private Button loginButton;
    private Button signUpButton;
    private EditText userEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MainView(this));

        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                
            }
        });
    }

    public class MainView extends RelativeLayout {
        public MainView(Context context) {
            super(context);

            setClickable(true);
            setFocusableInTouchMode(true);

            DisplayMetrics metrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(metrics);
            int height = metrics.heightPixels;
            int width = metrics.widthPixels;
            int itemGap = 10;
            int fieldHeight = 125;
            int centerScreen = (height - (fieldHeight*5 + itemGap*6))/2;

            backgroundImageView = new ImageView(context);
            backgroundImageView.setImageResource(R.drawable.league_of_legends_background_02);
            backgroundImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            backgroundImageView.setAlpha((float) 0.65);
            LayoutParams paramsBackgroundImageView =  new LayoutParams(width, height);
            paramsBackgroundImageView.topMargin = 0;
            paramsBackgroundImageView.leftMargin = 0;
            addView(backgroundImageView, paramsBackgroundImageView);

            logoImageView = new ImageView(context);
            LayoutParams paramsLogoImageView = new LayoutParams(width-200, fieldHeight*2);
            paramsLogoImageView.topMargin = centerScreen + 0;
            paramsLogoImageView.leftMargin = 100;
            logoImageView.setImageResource(R.drawable.league_of_legends_logo);
            addView(logoImageView, paramsLogoImageView);

            userEditText = new EditText(context);
            userEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (!hasFocus) {
                        hideKeyboard(v);
                    }
                }
            });
            userEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            userEditText.setHint("Username");
            LayoutParams paramsUserEditText = new LayoutParams(600,fieldHeight);
            paramsUserEditText.topMargin = paramsLogoImageView.height + paramsLogoImageView.topMargin + itemGap*6;
            paramsUserEditText.leftMargin = width/2 - paramsUserEditText.width/2;
            addView(userEditText,paramsUserEditText);

            passwordEditText = new EditText(context);
            passwordEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (!hasFocus) {
                        hideKeyboard(v);
                    }
                }
            });
            passwordEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            passwordEditText.setHint("Password");
            LayoutParams paramsPasswordEditText = new LayoutParams(600,fieldHeight);
            paramsPasswordEditText.topMargin = paramsUserEditText.height + paramsUserEditText.topMargin + itemGap*3;
            paramsPasswordEditText.leftMargin = width/2 - paramsPasswordEditText.width/2;
            addView(passwordEditText, paramsPasswordEditText);

            signUpButton = new Button(context);
            signUpButton.setText("SIGN UP");
            LayoutParams paramsSkipButton = new LayoutParams(width, fieldHeight);
            paramsSkipButton.bottomMargin = 0;
            paramsSkipButton.topMargin = height - paramsSkipButton.height;
            paramsSkipButton.leftMargin = width/2 - paramsSkipButton.width/2;
            addView(signUpButton, paramsSkipButton);


            loginButton = new Button(context);
            loginButton.setText("LOGIN");
            LayoutParams paramsLoginButton = new LayoutParams(width,fieldHeight);
            paramsLoginButton.bottomMargin = 0;
            paramsLoginButton.topMargin = height - paramsSkipButton.height - paramsLoginButton.height;
            paramsLoginButton.leftMargin = width/2 - paramsLoginButton.width/2;
            addView(loginButton, paramsLoginButton);
        }

        public void hideKeyboard(View view) {
            InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
