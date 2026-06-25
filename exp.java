public class exp {
    private static int NUM = 100, RND = 1000, EFFORT = 90, LUCK = 100 - EFFORT;
    private static int[] effort = new int[NUM];
    private static int[] luck = new int[NUM];
    private static float[] score = new float[NUM];
    private static int[] wins = new int[NUM];

    private static int randomNumber(int min, int max){
        int randomIndex ;
        do{
            randomIndex = (int) (Math.random() * max);
        }while (randomIndex < min);
        return randomIndex;
    }

    private static void randomMise(int i, int j){
        if(i == 1){
            NUM = randomNumber(15, 30);
        }
        if(j == 1){
            RND = randomNumber(50, 75);
        }
    }

    private static int random0or1(){
        int x = (int)(Math.random() * 1000);
        if(x<=500){
            return 1;
        }
        return 0;
    }

    private static int effort(int effort){
        int x;
        if(effort == 1){
            x = randomNumber(80, 100);
        }else{
            x = randomNumber(50, 80);
        }
        return x;
    }

    private static int luck(int luck){
        int x;
        if(luck == 1){
            x = randomNumber(90, 100);
        }else{
            x = randomNumber(70, 90);
        }
        return x;
    }

    private static void set(){
        for(int i = 0; i<NUM; i++){
            int effortYes = random0or1();
            int luckYes = random0or1();
            effort[i] = effort(effortYes);
            luck[i] = luck(luckYes);
        }
    }
    private static void calculateScore(){
        for(int i = 0; i< NUM; i++){
            score[i] = Math.round(((float) effort[i])*(EFFORT*0.01) + ((float) luck[i])* (LUCK * 0.01));
        }
    }
    private static int calculateThreshld(){
        int threshold = randomNumber(85,100);
        return threshold;
    }
    private static void round(int roundNumber){
        int threshold = calculateThreshld();
        System.out.println("Round " + (roundNumber + 1) + " Threshold: " + threshold);
        for(int i = 0; i < NUM; i++){
            if(score[i] >= threshold){
                wins[i]++;
                System.out.println("DEV "+(i+1) + " wins this round!");
            }
        }
    }
    private static void display(){
        System.out.println("Effort: " + EFFORT + "\t Luck: "+ LUCK);
        System.out.println("Players: " + NUM + "\t Rounds: "+ RND);
        System.out.println("Name\tEffort\tLuck\tScore\tWins");
        for(int i = 0; i < NUM; i++){
            System.out.println("DEV "+(i+1) + "\t" + effort[i] + "\t" + luck[i] + "\t" + score[i] + "\t" + wins[i]);
        }
    }
    public static void main(String[] args) {
        randomMise(1, 0);
        set();
        calculateScore();
        for(int i =0; i<RND; i++){
            round(i);
            System.out.println();
        }
        display();
    }
}