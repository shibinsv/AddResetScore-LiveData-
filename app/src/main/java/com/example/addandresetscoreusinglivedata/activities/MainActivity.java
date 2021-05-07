package com.example.addandresetscoreusinglivedata.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.example.addandresetscoreusinglivedata.R;
import com.example.addandresetscoreusinglivedata.activities.BaseActivity;
import com.example.addandresetscoreusinglivedata.models.ScoreViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.displayScore)
    TextView displayScore;

    @BindView(R.id.addScore)
    Button addScore;

    @BindView(R.id.resetScore)
    Button resetScore;

    ScoreViewModel scoreViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        scoreViewModel = new ViewModelProvider(this).get(ScoreViewModel.class);
        scoreViewModel.getScore().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                displayScore.setText(String.valueOf(integer));
            }
        });
    }

    @OnClick({R.id.addScore,R.id.resetScore})
    public void onViewClicked(View view){
        switch (view.getId()){
            case  R.id.addScore:
                scoreViewModel.addScore();
                break;
            case R.id.resetScore :
                scoreViewModel.resetScore();
                break;
        }
    }


}