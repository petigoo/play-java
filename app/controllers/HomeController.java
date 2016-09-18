package controllers;

import model.HelloWorld;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.myIndex;

public class HomeController extends Controller {

    public Result index() {
        return ok(myIndex.render(new HelloWorld()));
    }

}
