import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestForDeliveryCard {

    @Test
    void shouldDeliveryCard (){

        Calendar c = new GregorianCalendar();
        c.add(Calendar.DAY_OF_YEAR, 5);
        SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");
        String str = format1.format(c.getTime());

        String deleteDate = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;

        open("http://localhost:9999");
        $("[data-test-id=city] input").setValue("Ярославль");
        $("[data-test-id=date] input").setValue(deleteDate);
        $("[data-test-id=date] input").setValue(str);
        $("[data-test-id=name] input").setValue("Гурина Елена");
        $("[data-test-id=phone] input").setValue("+79519638383");
        $("[data-test-id=agreement]").click();
        $$("button").find(exactText("Забронировать")).click();
        $(withText("Успешно!")).waitUntil(visible, 15000);

    }
}
