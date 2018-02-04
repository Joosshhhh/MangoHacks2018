import java.util.ArrayList;
import java.util.TreeMap;

public class Menu {
    TreeMap<String, TreeMap<String, Meal>> menu = new TreeMap<>();

    public Menu(int time)
    {
        TreeMap<String, Meal> salads;
        TreeMap<String, Meal> meals;
        TreeMap<String, Meal> sides;
        TreeMap<String, Meal> drinks;
        TreeMap<String, Meal> beers;
        TreeMap<String, Meal> deserts;

        switch (time)
        {
            // daytime menu
            case 1:
                salads = new TreeMap<>();
                salads.put("garden salad", new Meal("Garden Salad", 0.0, new String[]{"Choice of Ranch, 1,000 Island, Balsamic Vinaigrette, Blue Cheese", "Fat Free Honey Mustard Dressing"}));
                salads.put("caesar salad", new Meal("Caesar Salad", 0.0, new String[]{"House Made Dressing and Shaved Parmesan Cheese"}));
                menu.put("salads", salads);

                meals = new TreeMap<>();
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

                sides = new TreeMap<>();
                sides.put("fries", new Meal("Fries", 0.0, null));
                sides.put("sweet potato fries", new Meal("Sweet Potato Fries", 0.0, null));
                menu.put("sides", sides);


                deserts = new TreeMap<>();
                deserts.put("new york cheesecake", new Meal("New York Cheesecake", 0.0, null));
                deserts.put("assorted cookies", new Meal("Assorted Cookies", 0.0, null));
                deserts.put("chocolate cake", new Meal("Chocolate Cake", 0.0, null));
                deserts.put("old fashioned banana split", new Meal("Old Fashioned Banana Split", 6.99, null));
                menu.put("deserts", deserts);

                drinks = new TreeMap<>();
                drinks.put("orange juice", new Meal("Orange Juice", 0.0, null));
                drinks.put("tomato juice", new Meal("Tomato Juice", 0.0, null));
                drinks.put("apple juice", new Meal("Apple Juice", 0.0, null));
                drinks.put("grapefruit juice", new Meal("Grapefruit Juice", 0.0, null));
                drinks.put("coffee", new Meal("Coffee", 0.0, null));
                drinks.put("decaf", new Meal("Decafinated Coffee", 0.0, null));
                drinks.put("hot tea", new Meal("Hot Tea", 0.0, null));
                drinks.put("iced tea", new Meal("Iced Tea", 0.0, null));
                drinks.put("hot chocolate", new Meal("Hot Chocolate", 0.0, null));
                drinks.put("chocolate milk", new Meal("Chocolate Milk", 0.0, null));
                drinks.put("milk", new Meal("Milk", 0.0, null));
                drinks.put("skim milk", new Meal("Skim Milk", 0.0, null));
                drinks.put("coke", new Meal("Coke", 0.0, null));
                drinks.put("diet coke", new Meal("Diet Coke", 0.0, null));
                drinks.put("club soda", new Meal("Club Soda", 0.0, null));
                drinks.put("ginger ale", new Meal("Ginger Ale", 0.0, null));
                drinks.put("root beer", new Meal("Root Beer", 0.0, null));
                drinks.put("tonic water", new Meal("Tonic Water", 0.0, null));
                menu.put("drinks", drinks);

                beers = new TreeMap<>();

                menu.put("beers", beers);
                break;

            case 2:
                salads = new TreeMap<>();
                salads.put("greek salad", new Meal("Greek Salad", 0.0, null));
                salads.put("chicken caesar salad", new Meal("Chicken Caesar Salad", 0.0, null));
                menu.put("salads", salads);

                meals = new TreeMap<>();
                meals.put("roast turkey wrap", new Meal("Roast Turkey Wrap", 0.0, null));
                menu.put("meals", meals);


        }
    }
}
