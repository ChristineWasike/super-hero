import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        String layout = "templates/layout.vtl";

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();

            model.put("heros", request.session().attribute("heros"));
            model.put("template", "templates/index.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        post("/heros", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<Hero> heros = request.session().attribute("heros");
            if (heros == null) {
                heros = new ArrayList<Hero>();
                request.session().attribute("heros", heros);
            }

            String heron = request.queryParams("heroname");
            int heroa = Integer.parseInt(request.queryParams("heroage"));
            String herop = request.queryParams("heropower");
            String herow = request.queryParams("heroweakness");
            Hero newHero = new Hero(heron, heroa, herop, herow);
            heros.add(newHero); //instance of a hero created here.

            model.put("template", "templates/success.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

    }
}
