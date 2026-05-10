package com.example.jnidemo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Déclaration des méthodes natives
    public native String helloFromJNI();
    public native int    factorial(int n);
    public native String reverseString(String s);
    public native int    sumArray(int[] values);

    // Chargement de la bibliothèque .so au démarrage de la classe
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvHello   = findViewById(R.id.tvHello);
        TextView tvFact    = findViewById(R.id.tvFact);
        TextView tvReverse = findViewById(R.id.tvReverse);
        TextView tvArray   = findViewById(R.id.tvArray);

        // Appel 1 : Hello World natif
        tvHello.setText(helloFromJNI());

        // Appel 2 : Factoriel
        int fact10 = factorial(10);
        tvFact.setText(fact10 >= 0
                ? "Factoriel de 10 = " + fact10
                : "Erreur factoriel, code = " + fact10);

        // Appel 3 : Inversion de chaîne
        tvReverse.setText("Texte inversé : " + reverseString("JNI is powerful!"));

        // Appel 4 : Somme de tableau
        int[] numbers = {10, 20, 30, 40, 50};
        tvArray.setText("Somme du tableau = " + sumArray(numbers));
    }
}