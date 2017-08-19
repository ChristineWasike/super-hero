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

            String heron = request.queryParams("heroname"); //retrieves the hero's name from my form
            int heroa = Integer.parseInt(request.queryParams("heroage")); //retrieves the hero's age from my form
            String herop = request.queryParams("heropower"); //retrieves the hero's power from my form
            String herow = request.queryParams("heroweakness"); //retrieves the hero's weakness from my form
            Hero newHero = new Hero(heron, heroa, herop, herow); 
            heros.add(newHero); //instance of a hero created here.

            model.put("template", "templates/success.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

    }
}
