package Constants;

public class Constants {
    public static final int FAQ_LENGTH = 8;
    public static final int RENTAL_OPTIONS = 7;
    public static final String TEST_URL_MAIN = "https://qa-scooter.praktikum-services.ru/";
    public static final String TEST_URL_TRACK = TEST_URL_MAIN + "track?t=";
    public static final String TEST_URL_ORDER = TEST_URL_MAIN + "order/";

    // Т.к. у нас нет доступа к БД и возможности зарезервировать трек-номер для целей тестирования, тестировать будем на пустой строке
    public static final String NON_EXIST_TRACK = "";
}
