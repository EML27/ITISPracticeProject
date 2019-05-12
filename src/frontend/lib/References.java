package frontend.lib;

public class References {

    public static final String CMD_GET_APPS_NAMES_COMMAND = "cmd /c start powershell.exe -Command Get-ItemProperty HKLM:\\Software\\Wow6432Node\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\* " +
            "| Select-Object DisplayName, DisplayVersion " +
            "| Format-Table -AutoSize > C:\\Users\\ПК\\Desktop\\JavaLessonsITIS\\java_itis\\ComFix\\apps-names.txt";

    public static final String CONFIX_SETTINGS_FILE_PATH = "src/frontend/bin/confix.properties";

    public static final String SETTINGS_PAGE_FXML_PATH = "/frontend/pages/settings_page.fxml";
    public static final String MAIN_PAGE_FXML_PATH = "/frontend/pages/main_page.fxml";
    public static final String RESET_PAGE_FXML_PATH = "/frontend/pages/reset_page.fxml";
    public static final String RESET_FIRSTTIME_PAGE_FXML_PATH = "/frontend/pages/reset_page_without_settings.fxml";
    public static final String SEARCHING_FILES_PAGE_FXML_PATH = "/frontend/pages/searching_files_page.fxml";
    public static final String INFO_PAGE_FXML_PATH = "/frontend/pages/info_page.fxml";

    public static final String SUPPORTED_PROGRAMS_PATH = "supported_programs.txt";
    public static final String FOUND_PROGRAMS_PATH = "supported_programs.txt";
    public static final String SUPPORT_DIRECTORY_PATH = "support";

}
