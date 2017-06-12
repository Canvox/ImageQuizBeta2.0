package net.dusktech.com.imagequizbeta20;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private ImageActivity mQuestionLibrary = new ImageActivity();

    private TextView mScoreView;
    private TextView mQuestionView;
    private ImageView mImageView;

    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button mButtonChoice4;

    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScoreView = (TextView)findViewById(R.id.questionNumberTextView);
        mQuestionView = (TextView)findViewById(R.id.questionTextView);

        mImageView = (ImageView)findViewById(R.id.imageView);

        mButtonChoice1 = (Button)findViewById(R.id.button);
        mButtonChoice2 = (Button)findViewById(R.id.button2);
        mButtonChoice3 = (Button)findViewById(R.id.button3);
        mButtonChoice4 = (Button)findViewById(R.id.button4);

        updateQuestion();

        mButtonChoice1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                if (mButtonChoice1.getText() == mAnswer){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(MainActivity.this, "Wrong", Toast.LENGTH_SHORT).show();
                }
                //Check before Update Question
                if(!check()){
                    updateQuestion();
                    updateImage();
                }

            }
        });

        mButtonChoice2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                if (mButtonChoice2.getText() == mAnswer){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(MainActivity.this, "Wrong", Toast.LENGTH_SHORT).show();
                }
                if(!check()){
                    updateQuestion();
                    updateImage();
                }
            }
        });

        mButtonChoice3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                if (mButtonChoice3.getText() == mAnswer){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(MainActivity.this, "Wrong", Toast.LENGTH_SHORT).show();
                }
                if(!check()){
                    updateQuestion();
                    updateImage();
                }
            }
        });

        mButtonChoice4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                if (mButtonChoice4.getText() == mAnswer){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(MainActivity.this, "Wrong", Toast.LENGTH_SHORT).show();
                }
                if(!check()){
                    updateQuestion();
                    updateImage();
                }
            }
        });
    }


    private boolean check(){
        boolean op = true;
        if (mScore == (mQuestionLibrary.mQuestions.length-1)){
            win();
        }
        op = false;
        return op;
    }

    private void updateQuestion(){

        mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
        mButtonChoice1.setText(mQuestionLibrary.getChoice1(mQuestionNumber));
        mButtonChoice2.setText(mQuestionLibrary.getChoice2(mQuestionNumber));
        mButtonChoice3.setText(mQuestionLibrary.getChoice3(mQuestionNumber));
        mButtonChoice4.setText(mQuestionLibrary.getChoice4(mQuestionNumber));

        mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
        mQuestionNumber++;
        /*if (mQuestionNumber >= mQuestionLibrary.mQuestions.length-1){
            gameOver();
        }*/
    }

    private void updateScore(int point) {
        mScoreView.setText("" + mScore);
    }

    public void updateImage(){

        Drawable test;
        switch (mScore){
            case 1:
                test = getResources().getDrawable(R.drawable.ico_android);
                mImageView.setImageDrawable(test);
                break;
            case 2:
                test = getResources().getDrawable(R.drawable.pokemon);
                mImageView.setImageDrawable(test);
                break;
            case 3:
                test = getResources().getDrawable(R.drawable.ico_android);
                mImageView.setImageDrawable(test);
                break;
            case 4:
                test = getResources().getDrawable(R.drawable.pokemon);
                mImageView.setImageDrawable(test);
                break;
            case 5:
                test = getResources().getDrawable(R.drawable.ico_android);
                mImageView.setImageDrawable(test);
                break;
        }
    }

    private void win(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder
                .setMessage("Victory! Your score is " + mScore + "points")
                .setCancelable(false)
                .setPositiveButton("New Game",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                finish();
                            }
                        })
                .setNegativeButton("Exit",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }

    private void gameOver(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder
                .setMessage("Game Over! Your score is " + mScore + "points" + (mQuestionLibrary.mQuestions.length-1))
                .setCancelable(false)
                .setPositiveButton("New Game",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                finish();
                            }
                        })
                .setNegativeButton("Exit",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }
}
