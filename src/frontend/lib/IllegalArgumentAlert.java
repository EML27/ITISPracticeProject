package frontend.lib;

public class IllegalArgumentAlert extends RuntimeException implements IIllegalArgumentAlert{

    public IllegalArgumentAlert(Exception e) {
        showError(e);
    }

    public IllegalArgumentAlert(String s) {
        Exception e = new Exception(s);
        showError(e);
    }

}
