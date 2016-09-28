package controllers;

import model.Countdown;
import org.joda.time.DateTime;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class HomeController extends Controller {

    public Result index() {
        return ok(index.render(new Countdown(DateTime.parse("2016-10-07T17:10:00"), "to PUBlin-IRAland")));
    }

}
