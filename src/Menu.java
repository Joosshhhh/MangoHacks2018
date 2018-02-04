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

                TreeMap<String, Meal> sides = new TreeMap<String, Meal>();

                sides = new TreeMap<>();
                sides.put("fries", new Meal("Fries", 0.0, null));
                sides.put("sweet potato fries", new Meal("Sweet Potato Fries", 0.0, null));
                menu.put("sides", sides);

                TreeMap<String, Meal> desserts = new TreeMap<String, Meal>();
                desserts.put("new york cheesecake", new Meal("New York Cheesecake", 0.0, null));
                desserts.put("assorted cookies", new Meal("Assorted Cookies", 0.0, null));
                desserts.put("chocolate cake", new Meal("Chocolate Cake", 0.0, null));
                desserts.put("old fashioned banana split", new Meal("Old Fashioned Banana Split", 6.99, null));
                menu.put("desserts", desserts);

                TreeMap<String, Meal> drinks = new TreeMap<String, Meal>();
                drinks.put("orange juice", new Meal("Orange Juice", 1.20, null));
                drinks.put("tomato juice", new Meal("Tomato Juice", 1.20, null));
                drinks.put("apple juice", new Meal("Apple Juice", 1.20, null));
                drinks.put("grapefruit juice", new Meal("Grapefruit Juice", 1.20, null));
                drinks.put("coffee", new Meal("Coffee", 3.50, null));
                drinks.put("decaf", new Meal("Decafinated Coffee", 3.50, null));
                drinks.put("hot tea", new Meal("Hot Tea", 1.20, null));
                drinks.put("iced tea", new Meal("Iced Tea", 1.20, null));
                drinks.put("hot chocolate", new Meal("Hot Chocolate", 1.20, null));
                drinks.put("chocolate milk", new Meal("Chocolate Milk", 1.20, null));
                drinks.put("milk", new Meal("Milk", 1.00, null));
                drinks.put("skim milk", new Meal("Skim Milk", 1.20, null));
                drinks.put("coke", new Meal("Coke", 0.0, null));
                drinks.put("diet coke", new Meal("Diet Coke", 0.0, null));
                drinks.put("club soda", new Meal("Club Soda", 0.0, null));
                drinks.put("ginger ale", new Meal("Ginger Ale", 0.0, null));
                drinks.put("root beer", new Meal("Root Beer", 0.0, null));
                drinks.put("tonic water", new Meal("Tonic Water", 0.0, null));
                menu.put("drinks", drinks);

                TreeMap<String, Meal> beers = new TreeMap<String, Meal>();
                beers.put("budweiser", new Meal("Budweiser", 5.50, null));
                beers.put("bud light", new Meal("Bud Light", 5.50, null));
                beers.put("miller light", new Meal("Miller Light", 5.50, null));
                beers.put("coors light", new Meal("Coors Light", 5.50, null));
                beers.put("samuel adams", new Meal("Samuel Adams", 5.50, null));
                beers.put("heineken", new Meal("Heineken", 5.50, null));
                beers.put("corona", new Meal("Corona", 5.50, null));
                beers.put("pilsner urquell", new Meal("Pilsner Urquell", 5.50, null));
                menu.put("beers", beers);

                break;

            case 2:
                salads = new TreeMap<>();
                salads.put("greek salad", new Meal("Greek Salad", 8.99, null));
                salads.put("chicken caesar salad", new Meal("Chicken Caesar Salad", 8.99, null));
                menu.put("salads", salads);

                meals = new TreeMap<>();
                meals.put("totally awesome wings", new Meal("Totalle Awesome Wings", 12.99, null));
                meals.put("chicken tenders", new Meal("Chicken Tenders", 12.99, null));
                meals.put("spicy fried firecracker shrimp", new Meal("Spicy Fried Firecracker Shrimp", 12.99, null));
                meals.put("portabella and veggie bun", new Meal("Portabella and Veggie Bun", 12.99, null));
                meals.put("killer chicken quesadilla", new Meal("Killer Chicken Quesadilla", 12.99, null));
                meals.put("grilled cheese, bacon and tomato sandwich", new Meal("Grilled Cheese, Bacon and Tomato Sandwich", 12.99, null));
                meals.put("authentic philly cheesesteak", new Meal("Authentic Philly Cheesesteak", 12.99, null));
                meals.put("roast turkey wrap", new Meal("Roast Turkey Wrap", 12.99, null));
                meals.put("pan pizza", new Meal("Pan Pizza", 12.99, null));
                meals.put("omelette and french fries", new Meal("Omelette and French Fries", 12.99, null));
                menu.put("meals", meals);

                break;
        }
    }
}
