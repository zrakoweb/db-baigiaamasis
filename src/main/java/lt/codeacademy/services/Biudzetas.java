package lt.codeacademy.services;

import lt.codeacademy.entities.IslaiduIrasas;
import lt.codeacademy.entities.PajamuIrasas;

import java.util.ArrayList;

public class Biudzetas {

    private ArrayList<PajamuIrasas> pajamos;
    private ArrayList<IslaiduIrasas> islaidos;


    public Biudzetas() {

        pajamos = new ArrayList<>();
        islaidos = new ArrayList<>();
    }

    public void pridetiPajamuIsrasa(PajamuIrasas pajamuIrasas) {
        pajamos.add(pajamuIrasas);
    }

    public void pridetislaiduIsrasa(IslaiduIrasas islaiduIrasas) {
        islaidos.add(islaiduIrasas);
    }

    public float gautiBalansa() {
        float balansas = 0f;
        int islaiduSuma = gautiIslaiduSuma();
        int pajamuSuma = gautiPajamuSuma();
        balansas = (float) pajamuSuma - (float) islaiduSuma;
        return balansas;
    }

    public int gautiPajamuSuma() {
        int pajamuSuma = 0;
        for (PajamuIrasas pajamuIrasas : pajamos) {
            pajamuSuma += pajamuIrasas.getSuma();
        }
        return pajamuSuma;
    }

    public int gautiIslaiduSuma() {
        int islaiduSuma = 0;
        for (IslaiduIrasas islaiduIrasas : islaidos) {
            islaiduSuma += islaiduIrasas.getSuma();
        }
        return islaiduSuma;
    }

    public ArrayList<PajamuIrasas> gautiPajamuIrasa() {
        return pajamos;
    }

    public ArrayList<IslaiduIrasas> gautiIslaiduIrasa() {
        return islaidos;
    }

}
