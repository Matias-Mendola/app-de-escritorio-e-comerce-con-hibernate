
package model;

public class LoginResult {
    private boolean result;
    private String mensaje;

    public LoginResult(boolean result, String mensaje) {
        this.result = result;
        this.mensaje = mensaje;
    }

    public LoginResult() {
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
}
