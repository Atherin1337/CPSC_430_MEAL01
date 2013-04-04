/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mealplan;

/**
 *
 * @author Angie Headley
 */
public class MealPlan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //enterRecipe = new EnterRecipe();
        //enterRecipe.setVisible(true);

        welcome = new Welcome();
        welcome.setVisible(true);

        
    }


    public static Version sqlquer;
    public static ViewMealPlan mealplan;
    public static Welcome welcome;
    public static AddIngredientsII ingredient;
    public static EnterRecipe enterRecipe;
    public static ShoppingListTXT shoplist;
    //public static fileprinting print;
}
