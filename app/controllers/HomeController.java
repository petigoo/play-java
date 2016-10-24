package controllers;

import org.bson.Document;
import org.joda.time.DateTime;

import com.google.inject.Inject;
import com.mongodb.client.MongoCollection;

import model.Countdown;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class HomeController extends Controller {

    @Inject
    private MongoCollection<Document> collection;

    public Result index() {
        return ok(index.render(new Countdown(DateTime.parse("2016-10-07T17:10:00"), "to PUBlin-IRAland")));
    }

    public Result getNumberOfDocuments() {
        return ok(String.valueOf(collection.count()));
    }

}
