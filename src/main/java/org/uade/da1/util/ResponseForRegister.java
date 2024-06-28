package org.uade.da1.util;

public class ResponseForRegister extends Response {
    private int valorDeError;

    public ResponseForRegister(String message, int valorDeError) {
        super(message);
        this.valorDeError = valorDeError;
    }

    public int getValorDeError() {
        return valorDeError;
    }

    public void setValorDeError(int valorDeError) {
        this.valorDeError = valorDeError;
    }

}
