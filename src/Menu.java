import java.util.ArrayList;
import java.util.TreeMap;

public class Menu {
    ArrayList<TreeMap<String, Meal>> menu = new ArrayList<>();

    public Menu(int time)
    {
        switch (time)
        {
            // daytime menu
            case 1:
                TreeMap<String, Meal> somethinglight = new TreeMap<String, Meal>();
                somethinglight.put("garden salad", new Meal("Garden Salad", 8.99, new String[]{"Choice of Ranch, 1,000 Island, Balsamic Vinaigrette, Blue Cheese", "Fat Free Honey Mustard Dressing"}));
                somethinglight.put("caesar salad", new Meal("Caesar Salad", 8.99, new String[]{"House Made Dressing and Shaved Parmesan Cheese"}));
                menu.add(somethinglight);

                TreeMap<String, Meal> justwhatyouordered = new TreeMap<String, Meal>();
                justwhatyouordered.put("tuna salad", new Meal("Tuna Salad", 12.99, new String[]{"Your choice of White, Whole Wheat, Rye", "gluten free Bread"}));
                justwhatyouordered.put("roast turkey", new Meal("Roast Turkey", 12.99, new String[]{"Your choice of White, Whole Wheat, Rye", "gluten free Bread"}));
                justwhatyouordered.put("ham and cheese", new Meal("Ham and Cheese", 12.99, new String[]{"Your choice of White, Whole Wheat, Rye", "gluten free Bread"}));
                justwhatyouordered.put("peanut butter and jelly", new Meal("Peanut Butter and Jelly", 12.99, new String[]{"Your choice of White, Whole Wheat, Rye", "gluten free Bread"}));
                justwhatyouordered.put("bacon, lettuce and tomato", new Meal("Bacon, Lettuce and Tomato", 12.99, new String[]{"Your choice of White, Whole Wheat, Rye", "gluten free Bread"}));
                justwhatyouordered.put("grilled american cheese", new Meal("Grilled American Cheese", 12.99, new String[]{"Your choice of White, Whole Wheat, Rye", "gluten free Bread"}));
                justwhatyouordered.put("grilled reuben", new Meal("Grilled Reuben", 12.99, new String[]{"Your choice of White, Whole Wheat, Rye", "gluten free Bread"}));
                menu.add(justwhatyouordered);

                TreeMap<String, Meal> sweettooth = new TreeMap<String, Meal>();
                sweettooth.put("new york cheesecake", new Meal("New York Cheesecake", 6.99, null));

                break;
        }
    }
}
