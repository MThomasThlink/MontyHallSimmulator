package com.thlink.montyhallsimmulator;

import java.util.Date;

public class GameResult 
{
    private Date dataHora;
    private int numOptions, premio, usu1, apres, usu2;
    private boolean change, result;

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public int getNumOptions() {
        return numOptions;
    }

    public void setNumOptions(int numOptions) {
        this.numOptions = numOptions;
    }

    public boolean isChange() {
        return change;
    }

    public void setChange(boolean change) {
        this.change = change;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public int getUsu1() {
        return usu1;
    }

    public void setUsu1(int usu1) {
        this.usu1 = usu1;
    }

    public int getApres() {
        return apres;
    }

    public void setApres(int apres) {
        this.apres = apres;
    }

    public int getUsu2() {
        return usu2;
    }

    public void setUsu2(int usu2) {
        this.usu2 = usu2;
    }

    public int getPremio() {
        return premio;
    }

    public void setPremio(int premio) {
        this.premio = premio;
    }
    
    
}
