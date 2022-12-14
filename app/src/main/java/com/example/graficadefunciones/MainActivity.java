package com.example.graficadefunciones;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Graficas funciones = new Graficas (this);
        setContentView(funciones);
    }

    class Graficas extends View {
        public Graficas (Context context){
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas){
            super.onDraw(canvas);
            Paint pintura = new Paint();
            pintura.setColor(Color.LTGRAY);
            canvas.drawPaint(pintura);

            int ancho = canvas.getWidth();
            int alto = canvas.getHeight();

            pintura.setColor(Color.RED);
            pintura.setTextSize(30);
            pintura.setStrokeWidth(10);
            pintura.setStrokeWidth(10);
            canvas.drawText("ancho = " + ancho + " altura = " + alto, 50, 50, pintura);

            pintura.setStrokeWidth(3);
            for(int n=0; n<alto; n+=50){
                canvas.drawLine(0, n, ancho, n, pintura);
                canvas.drawText(""+ n, ancho-120, n, pintura);
            }

            canvas.translate(50, 300);
            //canvas.save();

            pintura.setColor(Color.BLACK);
            pintura.setStrokeWidth(8);
            canvas.drawLine(0, 0, ancho-170, 0, pintura);
            canvas.drawLine(0, -300, 0, 200, pintura);
            Path path1 = new Path();
            float x=0;
            float t=0;
            float f= (float) 3/(ancho-170);
            path1.moveTo(t,x);

            for(t=0; t<ancho-170; t++){
                x=(float) Math.sin(2*3.1416*f*t)*(-150f);
                path1.lineTo(t,x);
            }
            pintura.setColor(Color.BLUE);
            pintura.setStyle(Paint.Style.STROKE);
            canvas.drawPath(path1, pintura);
            canvas.save();

            canvas.translate(0, 600);
            pintura.setColor(Color.BLACK);
            canvas.drawLine(0, 0, ancho-170, 0, pintura);
            canvas.drawLine(0, -300, 0, 200, pintura);

            //float[] intervalos={30, 20};
            float[] intervalos={30, 15, 7, 15};
            DashPathEffect dash = new DashPathEffect(intervalos, 0);
            pintura.setPathEffect(dash);

            //canvas.rotate(90, 0, 0);

            pintura.setColor(Color.BLUE);
            canvas.drawPath(path1, pintura);

            canvas.restore();
        }
    }
}