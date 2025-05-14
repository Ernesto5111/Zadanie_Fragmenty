package com.example.zadanie_fragmenty;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment; // WAŻNE: Import z androidx.fragment.app

public class SimpleInfoFragment2 extends Fragment { // Dziedziczymy po androidx.fragment.app.Fragment

    public SimpleInfoFragment2() {
        // Publiczny, pusty konstruktor jest wymagany!
        // System może potrzebować go odtworzyć np. po zmianie konfiguracji.
    }

    @Nullable // Metoda może zwrócić null, choć zazwyczaj zwraca widok
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Ta metoda jest wywoływana, gdy system potrzebuje stworzyć widok dla fragmentu.

        // 1. "Napompuj" (inflate) layout XML do obiektu View:
        //    - inflater: Obiekt, który potrafi zamienić XML na obiekty View.
        //    - R.layout.fragment_simple_info: ID naszego pliku layoutu.
        //    - container: Rodzic, do którego ten widok zostanie potencjalnie dołączony (tutaj używany do wyliczenia LayoutParams).
        //    - false: Mówimy inflaterowi, żeby na razie *nie* dołączał widoku do 'container' - system zrobi to sam.
        View view = inflater.inflate(R.layout.fragment2, container, false);

        // 2. (Opcjonalnie) Tutaj możesz znaleźć elementy widoku i dodać logikę
        //    np. TextView myText = view.findViewById(R.id.moj_tekst_id);
        //    myText.setText("Inny tekst");

        // 3. Zwróć stworzony widok.
        return view;
    }

    // Istnieją inne metody cyklu życia (onViewCreated, onStart, onResume, etc.),
    // ale onCreateView jest kluczowa do stworzenia interfejsu.
}