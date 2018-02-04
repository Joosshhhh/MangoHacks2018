import java.util.TreeMap;

public class Menu {
    TreeMap<String, TreeMap<String, Meal>> menu = new TreeMap<>();

    public Menu(int time)
    {
        switch (time)
        {
            // daytime menu
            case 1:
                TreeMap<String, Meal> salads = new TreeMap<String, Meal>();
                salads.put("garden salad", new Meal("Garden Salad", 0.0, new String[]{"Choice of Ranch, 1,000 Island, Balsamic Vinaigrette, Blue Cheese", "Fat Free Honey Mustard Dressing"}));
                salads.put("caesar salad", new Meal("Caesar Salad", 0.0, new String[]{"House Made Dressing and Shaved Parmesan Cheese"}));
                menu.put("salads", salads);

                TreeMap<String, Meal> meals = new TreeMap<String, Meal>();
                meals.put("tuna salad", new Meal("Tuna Salad", 0.0, new String[]{"Your choice of White, Whole Wheat, Rye", "gluten free Bread"}));
                meals.put("roast turkey", new Meal("Roast Turkey", 0.0, new String[]{"Your choice of White, Whole Wheat, Rye", "gluten free Bread"}));
                meals.put("ham and cheese", new Meal("Ham and Cheese", 0.0, new String[]{"Your choice of White, Whole Wheat, Rye", "gluten free Bread"}));
                meals.put("peanut butter and jelly", new Meal("Peanut Butter and Jelly", 0.0, new String[]{"Your choice of White, Whole Wheat, Rye", "gluten free Bread"}));
                meals.put("bacon, lettuce and tomato", new Meal("Bacon, Lettuce and Tomato", 0.0, new String[]{"Your choice of White, Whole Wheat, Rye", "gluten free Bread"}));
                meals.put("grilled american cheese", new Meal("Grilled American Cheese", 0.0, new String[]{"Your choice of White, Whole Wheat, Rye", "gluten free Bread"}));
                meals.put("grilled reuben", new Meal("Grilled Reuben", 0.0, new String[]{"Your choice of White, Whole Wheat, Rye", "gluten free Bread"}));
                meals.put("chicken tenders", new Meal("Chicken Tenders", 12.99, null));
                meals.put("totally awesome wings", new Meal("Totally Awesome Wings", 12.99, null));
                meals.put("spicy fried firecracker shrimp", new Meal("Spicy Fried Firecracker Shrimp", 12.99, null));
                meals.put("killer chicken quesadilla", new Meal("Killer Chicken Quesadilla", 12.99, null));
                meals.put("authentic philly cheesesteak", new Meal("Authentic Philly Cheesesteak", 12.99, null));
                meals.put("pan pizza", new Meal("Pan Pizza", 12.99, null));
                menu.put("meals", meals);

                TreeMap<String, Meal> sides = new TreeMap<String, Meal>();


                TreeMap<String, Meal> deserts = new TreeMap<String, Meal>();
                deserts.put("new york cheesecake", new Meal("New York Cheesecake", 0.0, null));
                deserts.put("assorted cookies", new Meal("Assorted Cookies", 0.0, null));
                deserts.put("chocolate cake", new Meal("Chocolate Cake", 0.0, null));
                deserts.put("old fashioned banana split", new Meal("Old Fashioned Banana Split", 6.99, null));
                menu.put("desserts", deserts);

                TreeMap<String, Meal> drinks = new TreeMap<String, Meal>();

                menu.put("desserts", deserts);

                TreeMap<String, Meal> beers = new TreeMap<String, Meal>();

                menu.put("beers", beers);

                break;

            case 2:
                
        }
    }
}
