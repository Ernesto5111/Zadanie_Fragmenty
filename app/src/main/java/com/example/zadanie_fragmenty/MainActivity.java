package com.example.zadanie_fragmenty;

import androidx.appcompat.app.AppCompatActivity; // Lub FragmentActivity
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity { // Dziedziczy po AppCompatActivity
    private int cos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button_a = findViewById(R.id.button1);
        Button button_b = findViewById(R.id.button2);
        button_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadSimpleFragment(new SimpleInfoFragment1());
                cos=1;
            }
        });
        button_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadSimpleFragment(new SimpleInfoFragment2());
                cos=2;
            }
        });
        // Możesz załadować fragment od razu przy starcie, jeśli chcesz
        // Ale tylko jeśli savedInstanceState == null, aby uniknąć dodania
        // go wielokrotnie np. po obrocie ekranu.
        if (savedInstanceState == null) {
            // loadSimpleFragment(); // Odkomentuj, jeśli chcesz ładować od razu
        }
    }

    private void loadSimpleFragment(Fragment A) {
        // 1. Utwórz instancję fragmentu, który chcesz dodać
        Fragment simpleFragment =  A;

        // 2. Pobierz FragmentManager
        //    FragmentManager zarządza wszystkimi fragmentami w Aktywności.
        //    Używamy getSupportFragmentManager() dla kompatybilności wstecznej (z biblioteki AndroidX).
        FragmentManager fragmentManager = getSupportFragmentManager();

        // 3. Rozpocznij Transakcję
        //    Wszystkie operacje na fragmentach (dodanie, usunięcie, zamiana)
        //    muszą odbywać się w ramach transakcji.
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // 4. Wykonaj operację - np. zamień zawartość kontenera na nowy fragment
        //    - R.id.fragment_container_dynamic: ID kontenera z pliku XML.
        //    - simpleFragment: Obiekt fragmentu do wstawienia.
        //    Istnieje też metoda add(), która dodaje fragment bez usuwania poprzednich w tym kontenerze.
        //    Replace jest często używane do nawigacji między "ekranami" fragmentów.
        fragmentTransaction.replace(R.id.fragment_container_dynamic, simpleFragment);

        // 5. (Opcjonalnie) Dodaj transakcję do stosu Wstecz (Back Stack)
        //    Jeśli to zrobisz, użytkownik będzie mógł wrócić do poprzedniego stanu
        //    (np. pustego kontenera lub poprzedniego fragmentu) używając przycisku Wstecz.
        //    Jeśli nie dodasz do back stack, naciśnięcie Wstecz może zamknąć Aktywność.
        //    Przekazanie 'null' oznacza brak specjalnej nazwy dla tej transakcji na stosie.
        // fragmentTransaction.addToBackStack(null); // Odkomentuj, jeśli chcesz umożliwić cofanie

        // 6. Zatwierdź Transakcję
        //    Dopiero teraz zmiany zostaną zaplanowane do wykonania.
        fragmentTransaction.commit();
    }
}