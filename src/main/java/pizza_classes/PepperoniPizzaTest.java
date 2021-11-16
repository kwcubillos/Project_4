package pizza_classes;

import org.junit.Assert;
import org.junit.Test;

/**
 * The test class for the PepperoniPizza price method
 * @author Ethan Chang and Kevin Cubillos
 */
public class PepperoniPizzaTest {
    PepperoniPizza pizza;
    private static final double DEFAULT_PIZZA = 8.99;
    private static final double TOPPINGS_DEFAULT_MEDIUM = 10.99;
    private static final double TOPPINGS__DEFAULT_LARGE = 12.99;
    private static final double TOPPINGS_LESS_THAN_DEFAULT = 8.99;
    private static final double TOPPINGS_LESS_THAN_DEFAULT_MEDIUM = 10.99;
    private static final double TOPPINGS_LESS_THAN_DEFAULT_LARGE = 12.99;
    private static final double TOPPINGS_ONE_MORE_THAN_DEFAULT = 10.48;
    private static final double TOPPINGS_ONE_MORE_THAN_DEFAULT_MEDIUM = 12.48;
    private static final double TOPPINGS_ONE_MORE_THAN_DEFAULT_LARGE = 14.48;
    private static final double TOPPINGS_TWO_MORE_THAN_DEFAULT = 11.97;
    private static final double TOPPINGS_TWO_MORE_THAN_DEFAULT_MEDIUM = 13.97;
    private static final double TOPPINGS_TWO_MORE_THAN_DEFAULT_LARGE = 15.97;
    private static final double TOPPINGS_THREE_MORE_THAN_DEFAULT = 13.46;
    private static final double TOPPINGS_THREE_MORE_THAN_DEFAULT_MEDIUM = 15.46;
    private static final double TOPPINGS_THREE_MORE_THAN_DEFAULT_LARGE = 17.46;
    private static final double TOPPINGS_FOUR_MORE_THAN_DEFAULT = 14.95;
    private static final double TOPPINGS_FOUR_MORE_THAN_DEFAULT_MEDIUM = 16.95;
    private static final double TOPPINGS_FOUR_MORE_THAN_DEFAULT_LARGE = 18.95;
    private static final double TOPPINGS_FIVE_MORE_THAN_DEFAULT = 16.44;
    private static final double TOPPINGS_FIVE_MORE_THAN_DEFAULT_MEDIUM = 18.44;
    private static final double TOPPINGS_FIVE_MORE_THAN_DEFAULT_LARGE = 20.44;
    private static final double TOPPINGS_MAX = 17.93;
    private static final double TOPPINGS_MAX_MEDIUM = 19.93;
    private static final double TOPPINGS_MAX_LARGE = 21.93;

    /**
     * This tests weather price is right for Default Pepperoni Pizza
     * Test Case #1
     */
    @Test
    public void price_default() {
        pizza = new PepperoniPizza();
        Assert.assertEquals(DEFAULT_PIZZA, pizza.price(), 0.001);
    }

    /**
     * This tests weather price is right for Medium Pepperoni Pizza
     * Test Case #2
     */
    @Test
    public void price_medium() {
        pizza = new PepperoniPizza();
        pizza.setSize(Size.MEDIUM);
        Assert.assertEquals(TOPPINGS_DEFAULT_MEDIUM, pizza.price(), 0.001);
    }

    /**
     * This tests weather price is right for Large Pepperoni Pizza
     * Test Case #3
     */
    @Test
    public void price_large() {
        pizza = new PepperoniPizza();
        pizza.setSize(Size.LARGE);
        Assert.assertEquals(TOPPINGS__DEFAULT_LARGE, pizza.price(), 0.001);
    }

    /**
     * This tests weather price is right for Pepperoni Pizza with less than default toppings
     * Test Case #4
     */
    @Test
    public void price_less_than_default() {
        pizza = new PepperoniPizza();
        Assert.assertEquals(TOPPINGS_LESS_THAN_DEFAULT, pizza.price(), 0.001);
    }

    /**
     * This tests weather price is right for Medium Pepperoni Pizza with less than default toppings
     * Test Case #5
     */
    @Test
    public void price_less_than_default_medium() {
        pizza = new PepperoniPizza();
        pizza.setSize(Size.MEDIUM);
        Assert.assertEquals(TOPPINGS_LESS_THAN_DEFAULT_MEDIUM, pizza.price(), 0.001);
    }

    /**
     * This tests weather price is right for Large Pepperoni Pizza with less than default toppings
     * Test Case #6
     */
    @Test
    public void price_less_than_default_large() {
        pizza = new PepperoniPizza();
        pizza.setSize(Size.LARGE);
        Assert.assertEquals(TOPPINGS_LESS_THAN_DEFAULT_LARGE, pizza.price(), 0.001);
    }

    /**
     * This tests weather price is right for Pepperoni Pizza with one more than default toppings
     * Test Case #7
     */
    @Test
    public void price_one_more_than_default() {
        pizza = new PepperoniPizza();
        pizza.addTopping(Topping.MUSHROOM);
        Assert.assertEquals(TOPPINGS_ONE_MORE_THAN_DEFAULT, pizza.price(), 0.001);
    }

    @Test
    public void price_one_more_than_default_medium() {
        pizza = new PepperoniPizza();
        pizza.setSize(Size.MEDIUM);
        pizza.addTopping(Topping.MUSHROOM);
        Assert.assertEquals(TOPPINGS_ONE_MORE_THAN_DEFAULT_MEDIUM, pizza.price(), 0.001);
    }

    @Test
    public void price_one_more_than_default_large() {
        pizza = new PepperoniPizza();
        pizza.setSize(Size.LARGE);
        pizza.addTopping(Topping.MUSHROOM);
        Assert.assertEquals(TOPPINGS_ONE_MORE_THAN_DEFAULT_LARGE, pizza.price(), 0.001);
    }

    /**
     * This tests weather price is right for Pepperoni Pizza with two more than default toppings
     * Test Case #8
     */
    @Test
    public void price_two_more_than_default() {
        pizza = new PepperoniPizza();
        pizza.addTopping(Topping.MUSHROOM);
        pizza.addTopping(Topping.ONION);
        Assert.assertEquals(TOPPINGS_TWO_MORE_THAN_DEFAULT, pizza.price(), 0.001);
    }

    /**
     * This tests weather price is right for Medium Pepperoni Pizza with two more than default toppings
     * Test Case #9
     */
    @Test
    public void price_two_more_than_default_medium() {
        pizza = new PepperoniPizza();
        pizza.setSize(Size.MEDIUM);
        pizza.addTopping(Topping.MUSHROOM);
        pizza.addTopping(Topping.ONION);
        Assert.assertEquals(TOPPINGS_TWO_MORE_THAN_DEFAULT_MEDIUM, pizza.price(), 0.001);
    }

    /**
     * This tests weather price is right for Large Pepperoni Pizza with two more than default toppings
     * Test Case #10
     */
    @Test
    public void price_two_more_than_default_large() {
        pizza = new PepperoniPizza();
        pizza.setSize(Size.LARGE);
        pizza.addTopping(Topping.MUSHROOM);
        pizza.addTopping(Topping.ONION);
        Assert.assertEquals(TOPPINGS_TWO_MORE_THAN_DEFAULT_LARGE, pizza.price(), 0.001);
    }

    /**
     * This tests weather price is right for Pepperoni Pizza with three more than default toppings
     * Test Case #11
     */
    @Test
    public void price_three_more_than_default() {
        pizza = new PepperoniPizza();
        pizza.addTopping(Topping.MUSHROOM);
        pizza.addTopping(Topping.ONION);
        pizza.addTopping(Topping.HAM);
        Assert.assertEquals(TOPPINGS_THREE_MORE_THAN_DEFAULT, pizza.price(), 0.001);
    }

    /**
     * This tests weather price is right for Medium Pepperoni Pizza with three more than default toppings
     * Test Case #12
     */
    @Test
    public void price_three_more_than_default_medium() {
        pizza = new PepperoniPizza();
        pizza.setSize(Size.MEDIUM);
        pizza.addTopping(Topping.MUSHROOM);
        pizza.addTopping(Topping.ONION);
        pizza.addTopping(Topping.HAM);
        Assert.assertEquals(TOPPINGS_THREE_MORE_THAN_DEFAULT_MEDIUM, pizza.price(), 0.001);
    }

    /**
     * This tests weather price is right for Large Pepperoni Pizza with three more than default toppings
     * Test Case #13
     */
    @Test
    public void price_three_more_than_default_large() {
        pizza = new PepperoniPizza();
        pizza.setSize(Size.LARGE);
        pizza.addTopping(Topping.MUSHROOM);
        pizza.addTopping(Topping.ONION);
        pizza.addTopping(Topping.HAM);
        Assert.assertEquals(TOPPINGS_THREE_MORE_THAN_DEFAULT_LARGE, pizza.price(), 0.001);
    }

    /**
     * This tests weather price is right for Pepperoni Pizza with four more than default toppings
     * Test Case #14
     */
    @Test
    public void price_four_more_than_default() {
        pizza = new PepperoniPizza();
        pizza.addTopping(Topping.MUSHROOM);
        pizza.addTopping(Topping.ONION);
        pizza.addTopping(Topping.HAM);
        pizza.addTopping(Topping.PINEAPPLE);
        Assert.assertEquals(TOPPINGS_FOUR_MORE_THAN_DEFAULT, pizza.price(), 0.001);
    }

    /**
     * This tests weather price is right for Medium Pepperoni Pizza with four more than default toppings
     * Test Case #15
     */
    @Test
    public void price_four_more_than_default_medium() {
        pizza = new PepperoniPizza();
        pizza.setSize(Size.MEDIUM);
        pizza.addTopping(Topping.MUSHROOM);
        pizza.addTopping(Topping.ONION);
        pizza.addTopping(Topping.HAM);
        pizza.addTopping(Topping.PINEAPPLE);
        Assert.assertEquals(TOPPINGS_FOUR_MORE_THAN_DEFAULT_MEDIUM, pizza.price(), 0.001);
    }

    /**
     * This tests weather price is right for Large Pepperoni Pizza with four more than default toppings
     * Test Case #16
     */
    @Test
    public void price_four_more_than_default_large() {
        pizza = new PepperoniPizza();
        pizza.setSize(Size.LARGE);
        pizza.addTopping(Topping.MUSHROOM);
        pizza.addTopping(Topping.ONION);
        pizza.addTopping(Topping.HAM);
        pizza.addTopping(Topping.PINEAPPLE);
        Assert.assertEquals(TOPPINGS_FOUR_MORE_THAN_DEFAULT_LARGE, pizza.price(), 0.001);
    }

    /**
     * This tests weather price is right for Pepperoni Pizza with five more than default toppings
     * Test Case #17
     */
    @Test
    public void price_five_more_than_default() {
        pizza = new PepperoniPizza();
        pizza.addTopping(Topping.MUSHROOM);
        pizza.addTopping(Topping.ONION);
        pizza.addTopping(Topping.HAM);
        pizza.addTopping(Topping.PINEAPPLE);
        pizza.addTopping(Topping.JALAPENO);
        Assert.assertEquals(TOPPINGS_FIVE_MORE_THAN_DEFAULT, pizza.price(), 0.001);
    }

    /**
     * This tests weather price is right for Medium Pepperoni Pizza with five more than default toppings
     * Test Case #18
     */
    @Test
    public void price_five_more_than_default_medium() {
        pizza = new PepperoniPizza();
        pizza.setSize(Size.MEDIUM);
        pizza.addTopping(Topping.MUSHROOM);
        pizza.addTopping(Topping.ONION);
        pizza.addTopping(Topping.HAM);
        pizza.addTopping(Topping.PINEAPPLE);
        pizza.addTopping(Topping.JALAPENO);
        Assert.assertEquals(TOPPINGS_FIVE_MORE_THAN_DEFAULT_MEDIUM, pizza.price(), 0.001);
    }

    /**
     * This tests weather price is right for Large Pepperoni Pizza with five more than default toppings
     * Test Case #19
     */
    @Test
    public void price_five_more_than_default_large() {
        pizza = new PepperoniPizza();
        pizza.setSize(Size.LARGE);
        pizza.addTopping(Topping.MUSHROOM);
        pizza.addTopping(Topping.ONION);
        pizza.addTopping(Topping.HAM);
        pizza.addTopping(Topping.PINEAPPLE);
        pizza.addTopping(Topping.JALAPENO);
        Assert.assertEquals(TOPPINGS_FIVE_MORE_THAN_DEFAULT_LARGE, pizza.price(), 0.001);
    }

    /**
     * This tests weather price is right for Pepperoni Pizza with six more than default toppings
     * Test Case #20
     */
    @Test
    public void price_max_toppings() {
        pizza = new PepperoniPizza();
        pizza.addTopping(Topping.MUSHROOM);
        pizza.addTopping(Topping.ONION);
        pizza.addTopping(Topping.HAM);
        pizza.addTopping(Topping.PINEAPPLE);
        pizza.addTopping(Topping.JALAPENO);
        pizza.addTopping(Topping.SHRIMP);
        Assert.assertEquals(TOPPINGS_MAX, pizza.price(), 0.001);
    }

    /**
     * This tests weather price is right for Medium Pepperoni Pizza with six more than default toppings
     * Test Case #21
     */
    @Test
    public void price_max_toppings_medium() {
        pizza = new PepperoniPizza();
        pizza.setSize(Size.MEDIUM);
        pizza.addTopping(Topping.MUSHROOM);
        pizza.addTopping(Topping.ONION);
        pizza.addTopping(Topping.HAM);
        pizza.addTopping(Topping.PINEAPPLE);
        pizza.addTopping(Topping.JALAPENO);
        pizza.addTopping(Topping.SHRIMP);
        Assert.assertEquals(TOPPINGS_MAX_MEDIUM, pizza.price(), 0.001);
    }

    /**
     * This tests weather price is right for Large Pepperoni Pizza with six more than default toppings
     * Test Case #22
     */
    @Test
    public void price_max_toppings_large() {
        pizza = new PepperoniPizza();
        pizza.setSize(Size.LARGE);
        pizza.addTopping(Topping.MUSHROOM);
        pizza.addTopping(Topping.ONION);
        pizza.addTopping(Topping.HAM);
        pizza.addTopping(Topping.PINEAPPLE);
        pizza.addTopping(Topping.JALAPENO);
        pizza.addTopping(Topping.SHRIMP);
        Assert.assertEquals(TOPPINGS_MAX_LARGE, pizza.price(), 0.001);
    }
}
