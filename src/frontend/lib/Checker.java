package frontend.lib;

public class Checker implements IChecker {

    private static Checker checker;

    public static Checker getInstance() {
        if(checker == null) {
            checker = new Checker();
        }
        return checker;
    }

    private Checker(){}

    @Override
    public boolean checkFirstTime() {
        String propertyName = "first-time";
        try {
            return PropertiesHandler.getInstance().get(propertyName).equals("true");
        } catch (NullPointerException e) {
            throw new IllegalArgumentAlert("Property " + propertyName + " was not found");
        }
    }

    @Override
    public boolean checkOpenSettings() {
        String propertyName = "open-settings";
        try {
            return PropertiesHandler.getInstance().get(propertyName).equals("true");
        } catch (NullPointerException e) {
            throw new IllegalArgumentAlert("Property " + propertyName + " was not found");
        }
    }

    @Override
    public boolean checkSearchingFiles() {
        String propertyName = "searching-completed";
        try {
            return PropertiesHandler.getInstance().get(propertyName).equals("true");
        } catch (NullPointerException e) {
            throw new IllegalArgumentAlert("Property " + propertyName + " was not found");
        }
    }
}
