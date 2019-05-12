package progFinder.insideChek.searchRealisation;

import progFinder.insideChek.searchRealisation.IntellijIIDEA.IntellijIDEA201822;
import progFinder.insideChek.searchRealisation.minecraft.MgeWorld;
import progFinder.insideChek.searchRealisation.telegram_desktop.TelegramDesktop;

public class GetSearchRealisation {
    /**
     * в зависимости от имени программы возвращает тип осуществляемого поиска
     * @return
     */
    public static I_TypeOfSearch getSearch(String name){
        switch(name){
            case "telegram-desktop":
                return new TelegramDesktop();
            case "Intellij IDEA 2018.2.2":
                return new IntellijIDEA201822();
            case ".mge-world":
                return new MgeWorld();
        }
        return null;
    }
}
