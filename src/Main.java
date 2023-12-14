public class Main {
    public static void main(String[] args) {

        STATS s1;
        s1 = new STATS();


        /* s1.ShowAllStableStats(); - WORKS */
        /* s1.ShowUserStatedStats(); - WORKS */
        /* s1.ShowPlayerStats(); - WORKS */

        /* ChangeLine(); - WORKS */
        /* ShowNames(); - WORKS */
        /* PrintNames(...); - WORKS */

        /* InnerStatCheck(...) - WORKS */
        /* ValueViability(...) - WORKS */

        //All other functions seem to work


        //PROBLEM - when user inputs invalid value, stats are shown, when they should not (it should appear a message saying CHANGE VALUE and nothing else)
        // (also if multiple wrong values are shown, they should all be shown to be changed)

        //s1.Input_Armor_Stats("ArmorName",-60,-7,300,6,2);
        //s1.Input_Sword_Stats("SwordName",400,50,67,89);
        //s1.ShowUserStatedStats();

        //s1.ShowPlayerStats();


        //System.out.println(s1.K);
        //s1.ValueViability(s1.Base_Armor_Hp);

        //s1.ShowUserStatedStats();
        }
    }