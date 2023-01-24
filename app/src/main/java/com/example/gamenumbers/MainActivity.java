package com.example.gamenumbers;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Random;
import java.util.SplittableRandom;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    int difficult = 0;
    int[] array = new int[16];
    int counterOfCorrectClicks;

    ProgressBar mProgressBar;
    CountDownTimer mCountDownTimer;
    int k;
    int timeForGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonSelectDifficult(View view){

        if(difficult != 0){
            switch(view.getId()) {
                case R.id.button_easy:
                case R.id.button_hard:
                case R.id.button_medium:
                    findViewById(R.id.button_easy).setBackgroundColor(Color.LTGRAY);
                    findViewById(R.id.button_medium).setBackgroundColor(Color.LTGRAY);
                    findViewById(R.id.button_hard).setBackgroundColor(Color.LTGRAY);
                    difficult =0;
                    break;
            }
        }
        else{
            switch(view.getId()) {
                case R.id.button_easy:
                    findViewById(R.id.button_easy).setBackgroundColor(Color.GREEN);
                    difficult = 1;
                    findViewById(R.id.button_hard).setBackgroundColor(Color.LTGRAY);
                    findViewById(R.id.button_medium).setBackgroundColor(Color.LTGRAY);
                    break;
                case R.id.button_medium:
                    findViewById(R.id.button_medium).setBackgroundColor(Color.YELLOW);
                    difficult = 2;
                    findViewById(R.id.button_hard).setBackgroundColor(Color.LTGRAY);
                    findViewById(R.id.button_easy).setBackgroundColor(Color.LTGRAY);
                    break;
                case R.id.button_hard:
                    findViewById(R.id.button_hard).setBackgroundColor(Color.RED);
                    difficult = 3;
                    findViewById(R.id.button_easy).setBackgroundColor(Color.LTGRAY);
                    findViewById(R.id.button_medium).setBackgroundColor(Color.LTGRAY);
                    break;
            }
        }
    }


    public void start(View view){
        TextView tv = findViewById(R.id.text_1);
        if(difficult == 0){
            tv.setText("Выберите сложность для начала игры!");
            tv.setTextSize(15);
            return;
        }
        else {
            counterOfCorrectClicks = 0;

            Random r = new Random();
            int lowerBound = 1;
            int upperBound = 101;

            array[0] = r.nextInt(upperBound - lowerBound) + lowerBound;


            tv.setText("Время пошло!!!");

            if (difficult == 1) timeForGame = 60000;
            else if (difficult == 2) timeForGame = 40000;
            else timeForGame = 25000;

            mProgressBar = (ProgressBar) findViewById(R.id.progressBarHorizontal);
            k = 0;
            mProgressBar.setProgress(k);
            mProgressBar.setVisibility(View.VISIBLE);
            mCountDownTimer = new CountDownTimer(timeForGame, 1000) {

                @Override
                public void onTick(long millisUntilFinished) {
                    k++;
                    mProgressBar.setProgress((int) k * 100 / (timeForGame / 1000));
                }

                @Override
                public void onFinish() {
                    k++;
                    mProgressBar.setProgress(100);
                    if(counterOfCorrectClicks != 16){
                        tv.setText("Уупс, время вышло. Вы не справились с заданием :(");
                        tv.setTextSize(20);
                        mProgressBar.setVisibility(View.INVISIBLE);
                    }
                }
            };

            mCountDownTimer.start();

            for (int i = 1; i < 16; i++) {

                boolean repeatNumber = false;
                int b;

                do {
                    b = r.nextInt(upperBound - lowerBound) + lowerBound;
                    for (int z = 0; z < i; ) {
                        if (array[z] != b) {
                            z++;
                            repeatNumber = false;
                        } else {
                            repeatNumber = true;
                            break;
                        }
                    }
                } while (repeatNumber);
                array[i] = b;
            }
            Button btn1 = findViewById(R.id.button_1);
            btn1.setBackgroundColor(Color.rgb(133, 172, 87));
            btn1.setText(Integer.toString(array[0]));

            Button btn2 = findViewById(R.id.button_2);
            btn2.setBackgroundColor(Color.rgb(133, 172, 87));
            btn2.setText(Integer.toString(array[1]));

            Button btn3 = findViewById(R.id.button_3);
            btn3.setBackgroundColor(Color.rgb(133, 172, 87));
            btn3.setText(Integer.toString(array[2]));

            Button btn4 = findViewById(R.id.button_4);
            btn4.setBackgroundColor(Color.rgb(133, 172, 87));
            btn4.setText(Integer.toString(array[3]));

            Button btn5 = findViewById(R.id.button_5);
            btn5.setBackgroundColor(Color.rgb(133, 172, 87));
            btn5.setText(Integer.toString(array[4]));

            Button btn6 = findViewById(R.id.button_6);
            btn6.setBackgroundColor(Color.rgb(133, 172, 87));
            btn6.setText(Integer.toString(array[5]));

            Button btn7 = findViewById(R.id.button_7);
            btn7.setBackgroundColor(Color.rgb(133, 172, 87));
            btn7.setText(Integer.toString(array[6]));

            Button btn8 = findViewById(R.id.button_8);
            btn8.setBackgroundColor(Color.rgb(133, 172, 87));
            btn8.setText(Integer.toString(array[7]));

            Button btn9 = findViewById(R.id.button_9);
            btn9.setBackgroundColor(Color.rgb(133, 172, 87));
            btn9.setText(Integer.toString(array[8]));

            Button btn10 = findViewById(R.id.button_10);
            btn10.setBackgroundColor(Color.rgb(133, 172, 87));
            btn10.setText(Integer.toString(array[9]));

            Button btn11 = findViewById(R.id.button_11);
            btn11.setBackgroundColor(Color.rgb(133, 172, 87));
            btn11.setText(Integer.toString(array[10]));

            Button btn12 = findViewById(R.id.button_12);
            btn12.setBackgroundColor(Color.rgb(133, 172, 87));
            btn12.setText(Integer.toString(array[11]));

            Button btn13 = findViewById(R.id.button_13);
            btn13.setBackgroundColor(Color.rgb(133, 172, 87));
            btn13.setText(Integer.toString(array[12]));

            Button btn14 = findViewById(R.id.button_14);
            btn14.setBackgroundColor(Color.rgb(133, 172, 87));
            btn14.setText(Integer.toString(array[13]));

            Button btn15 = findViewById(R.id.button_15);
            btn15.setBackgroundColor(Color.rgb(133, 172, 87));
            btn15.setText(Integer.toString(array[14]));

            Button btn16 = findViewById(R.id.button_16);
            btn16.setBackgroundColor(Color.rgb(133, 172, 87));
            btn16.setText(Integer.toString(array[15]));

            Arrays.sort(array);
        }
    }

    public void buttonClick(View view) {

        TextView tv1 = findViewById(R.id.text_1);
        int pressedNumber;

        switch(view.getId()) {
            case R.id.button_1:
                Button btn1 = findViewById(R.id.button_1);
                pressedNumber = Integer.parseInt(btn1.getText().toString());
                    if(pressedNumber == array[counterOfCorrectClicks]){
                        counterOfCorrectClicks++;
                        btn1.setBackgroundColor(Color.WHITE);
                    }
                    else k++;
                    if(counterOfCorrectClicks == 16){
                        tv1.setText("Отлично. Вы выиграли!!! ");
                        tv1.setTextSize(30);
                        mProgressBar.setVisibility(View.INVISIBLE);
                        mCountDownTimer.cancel();
                    }
                break;
            case R.id.button_2:
                Button btn2 = findViewById(R.id.button_2);
                pressedNumber = Integer.parseInt(btn2.getText().toString());
                    if(pressedNumber == array[counterOfCorrectClicks]){
                        counterOfCorrectClicks++;
                        btn2.setBackgroundColor(Color.WHITE);
                    }
                    else k++;
                if(counterOfCorrectClicks == 16){
                    tv1.setText("Отлично. Вы выиграли!!! ");
                    tv1.setTextSize(30);
                    mProgressBar.setVisibility(View.INVISIBLE);
                    mCountDownTimer.cancel();
                }
                break;
            case R.id.button_3:
                Button btn3 = findViewById(R.id.button_3);
                pressedNumber = Integer.parseInt(btn3.getText().toString());
                   if(pressedNumber == array[counterOfCorrectClicks]){
                       counterOfCorrectClicks++;
                       btn3.setBackgroundColor(Color.WHITE);
                   }
                   else k++;
                if(counterOfCorrectClicks == 16){
                    tv1.setText("Отлично. Вы выиграли!!! ");
                    tv1.setTextSize(30);
                    mProgressBar.setVisibility(View.INVISIBLE);
                    mCountDownTimer.cancel();
                }
                break;
            case R.id.button_4:
                Button btn4 = findViewById(R.id.button_4);
                pressedNumber = Integer.parseInt(btn4.getText().toString());
                   if(pressedNumber == array[counterOfCorrectClicks]){
                       counterOfCorrectClicks++;
                       btn4.setBackgroundColor(Color.WHITE);
                   }
                   else k++;
                if(counterOfCorrectClicks == 16){
                    tv1.setText("Отлично. Вы выиграли!!! ");
                    tv1.setTextSize(30);
                    mProgressBar.setVisibility(View.INVISIBLE);
                    mCountDownTimer.cancel();
                }
                break;
            case R.id.button_5:
                Button btn5 = findViewById(R.id.button_5);
                pressedNumber = Integer.parseInt(btn5.getText().toString());
                   if(pressedNumber == array[counterOfCorrectClicks]){
                       counterOfCorrectClicks++;
                       btn5.setBackgroundColor(Color.WHITE);
                   }
                   else k++;
                if(counterOfCorrectClicks == 16){
                    tv1.setText("Отлично. Вы выиграли!!! ");
                    tv1.setTextSize(30);
                    mProgressBar.setVisibility(View.INVISIBLE);
                    mCountDownTimer.cancel();
                }
                break;
            case R.id.button_6:
                Button btn6 = findViewById(R.id.button_6);
                pressedNumber = Integer.parseInt(btn6.getText().toString());
                   if(pressedNumber == array[counterOfCorrectClicks]){
                       counterOfCorrectClicks++;
                       btn6.setBackgroundColor(Color.WHITE);
                   }
                   else k++;
                if(counterOfCorrectClicks == 16){
                    tv1.setText("Отлично. Вы выиграли!!! ");
                    tv1.setTextSize(30);
                    mProgressBar.setVisibility(View.INVISIBLE);
                    mCountDownTimer.cancel();
                }
                break;
            case R.id.button_7:
                Button btn7 = findViewById(R.id.button_7);
                pressedNumber = Integer.parseInt(btn7.getText().toString());
                   if(pressedNumber == array[counterOfCorrectClicks]){
                       counterOfCorrectClicks++;
                       btn7.setBackgroundColor(Color.WHITE);
                   }
                   else k++;
                if(counterOfCorrectClicks == 16){
                    tv1.setText("Отлично. Вы выиграли!!! ");
                    tv1.setTextSize(30);
                    mProgressBar.setVisibility(View.INVISIBLE);
                    mCountDownTimer.cancel();
                }
                break;
            case R.id.button_8:
                Button btn8 = findViewById(R.id.button_8);
                pressedNumber = Integer.parseInt(btn8.getText().toString());
                   if(pressedNumber == array[counterOfCorrectClicks]){
                       counterOfCorrectClicks++;
                       btn8.setBackgroundColor(Color.WHITE);
                   }
                   else k++;
                if(counterOfCorrectClicks == 16){
                    tv1.setText("Отлично. Вы выиграли!!! ");
                    tv1.setTextSize(30);
                    mProgressBar.setVisibility(View.INVISIBLE);
                    mCountDownTimer.cancel();
                }
                break;
            case R.id.button_9:
                Button btn9 = findViewById(R.id.button_9);
                pressedNumber = Integer.parseInt(btn9.getText().toString());
                    if(pressedNumber == array[counterOfCorrectClicks]){
                        counterOfCorrectClicks++;
                        btn9.setBackgroundColor(Color.WHITE);
                    }
                    else k++;
                if(counterOfCorrectClicks == 16){
                    tv1.setText("Отлично. Вы выиграли!!! ");
                    tv1.setTextSize(30);
                    mProgressBar.setVisibility(View.INVISIBLE);
                    mCountDownTimer.cancel();
                }
                    break;
            case R.id.button_10:
                            Button btn10 = findViewById(R.id.button_10);
                            pressedNumber = Integer.parseInt(btn10.getText().toString());
                                if(pressedNumber == array[counterOfCorrectClicks]){
                                    counterOfCorrectClicks++;
                                    btn10.setBackgroundColor(Color.WHITE);
                                }
                                else k++;
                            if(counterOfCorrectClicks == 16){
                                tv1.setText("Отлично. Вы выиграли!!! ");
                                tv1.setTextSize(30);
                                mProgressBar.setVisibility(View.INVISIBLE);
                                mCountDownTimer.cancel();
                            }
                            break;
                        case R.id.button_11:
                            Button btn11 = findViewById(R.id.button_11);
                            pressedNumber = Integer.parseInt(btn11.getText().toString());
                               if(pressedNumber == array[counterOfCorrectClicks]){
                                   counterOfCorrectClicks++;
                                   btn11.setBackgroundColor(Color.WHITE);
                               }
                               else k++;
                            if(counterOfCorrectClicks == 16){
                                tv1.setText("Отлично. Вы выиграли!!! ");
                                tv1.setTextSize(30);
                                mProgressBar.setVisibility(View.INVISIBLE);
                                mCountDownTimer.cancel();
                            }
                            break;
                        case R.id.button_12:
                            Button btn12 = findViewById(R.id.button_12);
                            pressedNumber = Integer.parseInt(btn12.getText().toString());
                               if(pressedNumber == array[counterOfCorrectClicks]){
                                   counterOfCorrectClicks++;
                                   btn12.setBackgroundColor(Color.WHITE);
                               }
                               else k++;
                            if(counterOfCorrectClicks == 16){
                                tv1.setText("Отлично. Вы выиграли!!! ");
                                tv1.setTextSize(30);
                                mProgressBar.setVisibility(View.INVISIBLE);
                                mCountDownTimer.cancel();
                            }
                            break;
                        case R.id.button_13:
                            Button btn13 = findViewById(R.id.button_13);
                            pressedNumber = Integer.parseInt(btn13.getText().toString());
                               if(pressedNumber == array[counterOfCorrectClicks]){
                                   counterOfCorrectClicks++;
                                   btn13.setBackgroundColor(Color.WHITE);
                               }
                               else k++;
                            if(counterOfCorrectClicks == 16){
                                tv1.setText("Отлично. Вы выиграли!!! ");
                                tv1.setTextSize(30);
                                mProgressBar.setVisibility(View.INVISIBLE);
                                mCountDownTimer.cancel();
                            }
                            break;
                        case R.id.button_14:
                            Button btn14 = findViewById(R.id.button_14);
                            pressedNumber = Integer.parseInt(btn14.getText().toString());
                               if(pressedNumber == array[counterOfCorrectClicks]){
                                   counterOfCorrectClicks++;
                                   btn14.setBackgroundColor(Color.WHITE);
                               }
                               else k++;
                            if(counterOfCorrectClicks == 16){
                                tv1.setText("Отлично. Вы выиграли!!! ");
                                tv1.setTextSize(30);
                                mProgressBar.setVisibility(View.INVISIBLE);
                                mCountDownTimer.cancel();
                            }
                            break;
                        case R.id.button_15:
                            Button btn15 = findViewById(R.id.button_15);
                            pressedNumber = Integer.parseInt(btn15.getText().toString());
                               if(pressedNumber == array[counterOfCorrectClicks]){
                                   counterOfCorrectClicks++;
                                   btn15.setBackgroundColor(Color.WHITE);
                               }
                               else k++;
                            if(counterOfCorrectClicks == 16){
                                tv1.setText("Отлично. Вы выиграли!!! ");
                                tv1.setTextSize(30);
                                mProgressBar.setVisibility(View.INVISIBLE);
                                mCountDownTimer.cancel();
                            }
                            break;
                        case R.id.button_16:
                            Button btn16 = findViewById(R.id.button_16);
                            pressedNumber = Integer.parseInt(btn16.getText().toString());
                               if(pressedNumber == array[counterOfCorrectClicks]){
                                   counterOfCorrectClicks++;
                                   btn16.setBackgroundColor(Color.WHITE);
                               }
                               else k++;
                            if(counterOfCorrectClicks == 16){
                                tv1.setText("Отлично. Вы выиграли!!! ");
                                tv1.setTextSize(30);
                                mProgressBar.setVisibility(View.INVISIBLE);
                                mCountDownTimer.cancel();
                            }
                            break;

        }
    }

}