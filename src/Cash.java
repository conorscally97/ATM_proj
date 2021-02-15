public class Cash
{
    private final static int INITIAL_COUNT_50 = 10;
    private final static int INITIAL_COUNT_20 = 30;
    private final static int INITIAL_COUNT_10 = 30;
    private final static int INITIAL_COUNT_5 = 20;
    private int fifty_count;
    private int twenty_count;
    private int ten_count;
    private int five_count;
    public int total_count;
    public boolean overdraw_fail = false;

    int fifties_wanted;
    int twenties_wanted;
    int tens_wanted;
    int fives_wanted;


    public Cash(int total_count)
    {
        this.total_count = total_count;
        fifty_count = INITIAL_COUNT_50;
        twenty_count = INITIAL_COUNT_20;
        ten_count = INITIAL_COUNT_10;
        five_count = INITIAL_COUNT_5;
    }

    public void depositCash(int amount){
        //Did not think of depositing cash, should have used array to record number of notes.
    }

    public void withdrawCash(int amount)
    {

        if (amount > total_count){
            System.out.println("Sorry, insufficient cash in machine!");
            overdraw_fail = true;
        } else{
            int withdrawal = amount;
            if (amount >= 50){
                fifties_wanted = amount/50;
                if(fifties_wanted <= fifty_count ) {
                    amount %= 50;

                }
                else{
                    fifties_wanted = fifty_count;
                    amount -= (fifties_wanted*50);
                }
                fifty_count -= fifties_wanted;
            } else{
                fifties_wanted = 0;
            }


            if (amount>=20){
                twenties_wanted = amount/20;
                if(twenties_wanted <= twenty_count ) {
                    amount %= 20;
                }
                else{
                    twenties_wanted = twenty_count;
                    amount -= (twenties_wanted*50);
                }
                twenty_count -= twenties_wanted;
            }else{
                twenties_wanted = 0;
            }


            if (amount>=10){
                tens_wanted = amount/10;
                if(tens_wanted <= ten_count ) {
                    amount %= 10;

                }
                else{
                    tens_wanted = ten_count;
                    amount -= (tens_wanted*50);
                }
                ten_count -= tens_wanted;
            }else{
                tens_wanted = 0;
            }


            if (amount>=5){
                fives_wanted = amount/5;
                if(fives_wanted <= five_count ) {
                    amount %= 5;
                    five_count -= fives_wanted;
                } else {
                    System.out.println("Sorry, insufficient cash in machine!");
                    overdraw_fail = true;
                    System.exit(0);
                }
            }
            else{
                fives_wanted = 0;
            }

            System.out.printf("Here is €%d in %d €50 notes, %d €20 notes, %d €10 notes, %d €5 notes\n", withdrawal, fifties_wanted, twenties_wanted, tens_wanted, fives_wanted);
            total_count -= withdrawal;
            System.out.println("Cash left in ATM: " + total_count +"\n");
        }

    }
}