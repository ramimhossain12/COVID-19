package com.ramim.covidrm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.faysal.coronaoutbreak.Corona;
import com.faysal.coronaoutbreak.models.Response;
import com.faysal.coronaoutbreak.utils.TotalOutbreakListener;


public class RealActivity extends AppCompatActivity {

    public static final String TAG="RealActivity";
    private static  int timeout =4000;
    Button getResultBtn;
    TextView resultView;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real);

        getResultBtn=findViewById(R.id.getResultBtn);
        resultView=findViewById(R.id.resultView);



        Animation animation = AnimationUtils.loadAnimation(RealActivity.this,R.anim.myanimation);

        getResultBtn.startAnimation(animation);
        resultView.startAnimation(animation);



        getResultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog=new ProgressDialog(RealActivity.this);
                dialog.setMessage("Please wait....");
                dialog.show();
                if (checkInternet()){
                    Corona.setTotalOutbreakListener(RealActivity.this,new TotalOutbreakListener() {
                        @Override
                        public void success(Response response) {
                            Log.d(TAG, "success: "+response.getMessage());
                            if (response.isSuccess()){
                                resultView.setText(
                                        "Coronavirus Cases : "+response.getOutbreak().getTotalCases()+"\n"+
                                                "Deaths : "+response.getOutbreak().getTotalDeaths()+"\n"+
                                                "Recovered : "+response.getOutbreak().getTotalRecovered()


                                );

                                Log.d(TAG, "success: ");

                                Log.d(TAG, "Coronavirus Cases : "+response.getOutbreak().getTotalCases());
                                Log.d(TAG,    "Deaths : "+response.getOutbreak().getTotalDeaths());
                                Log.d(TAG, "Recovered : "+response.getOutbreak().getTotalRecovered());
                            }

                            dialog.dismiss();
                        }

                        @Override
                        public void failed(String errorMessage) {
                            Log.d(TAG, "failed: "+errorMessage);
                            dialog.dismiss();
                        }



                    });
                }else {
                    Toast.makeText(RealActivity.this, "Internet Connection not available", Toast.LENGTH_SHORT).show();
                }
            }
        });





    }

    private boolean checkInternet(){
        ConnectivityManager mgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = mgr.getActiveNetworkInfo();

        if (netInfo != null) {
            if (netInfo.isConnected()) {
                return true;
            }else {
                return false;
            }
        } else {
            return false;
        }
    }


}


