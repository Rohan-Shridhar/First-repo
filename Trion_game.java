import Players.Decision;
import Players.Name;
import Players.Rayon;
import java.util.Scanner;
public class Trion_game {
    public static Scanner sc=new Scanner(System.in);
    public static String Alice,Bob,Charlie;
    public static int[] score={0,0,0};
    public static int rounds=getRounds();
    public static int[][] choices=new int[3][Trion_game.rounds];
    public static int getRounds() {
        System.out.print("Number of rounds:");
        int r=sc.nextInt();
        Alice="Player 1 "+Name.One_for_even_man;
        Bob="Player 2 "+ Name.One_for_even_man;
        Charlie="Player 3 "+Name.Rayon;
        return r;
    }
    public static void input(int round){
        choices[0][round]=Decision.One_for_even_man(round);
        choices[1][round]=Decision.One_for_even_man(round);
        choices[2][round]=Rayon.decision(round, choices, 2, score);
    }
    public static void scoring(int round){
        if(choices[0][round]==choices[1][round]&&choices[1][round]==choices[2][round]){
            if(choices[0][round]==1){
                score[0]+=3;
                score[1]+=3;
                score[2]+=3;
            }
            if (choices[0][round]==0) {
                score[0]+=1;
                score[1]+=1;
                score[2]+=1;           
            }
        }else if (choices[0][round]==choices[1][round]&&choices[0][round]!=choices[2][round]) {
            score[2]+=5;
        }else if (choices[0][round]==choices[2][round]&&choices[0][round]!=choices[1][round]) {
            score[1]+=5;
        }else if (choices[2][round]==choices[1][round]&&choices[0][round]!=choices[2][round]) {
            score[0]+=5;
        }
    }
    public static void draw(){
        boolean flag=false;
        if (score[0]==score[1]&&score[0]>score[2]) {
            System.out.println(Alice+" and "+Bob+" equal");
            flag=true;
        }
        if (score[2]==score[1]&&score[0]<score[2]) {
            System.out.println(Bob+" and "+Charlie+" equal");
            flag=true;
        }
        if (score[0]==score[2]&&score[0]>score[1]) {
            System.out.println(Alice+" and "+Charlie+" equal");
            flag=true;
        }
        if(flag){
            choices_display();
        }
    }
    public static void tie(){
        boolean flag=false;
        if(score[0]==score[1]&&score[0]==score[2]){
            System.out.println("Its a tie!!");
            flag=true;
        }
        if(flag){
            choices_display();
        }
    }
    public static void winner(int l){
        System.out.println((l==score[0]?Alice:l==score[1]?Bob:Charlie)+" won");
        choices_display();
    }
    public static void maximum(){
        int large=score[0]>score[1]&&score[0]>score[2]?score[0]:score[1]>score[2]?score[1]:score[2];
        winner(large);
    }
    public static void display(){
        System.out.print("Scores: ");
        for(int i=0;i<3;i++){
        if(i==0){
        System.out.print("[");}
        System.out.print(score[i]);
        if(i==2){
        System.out.println("]");}
        else{
        System.out.print(" , ");}}
    }
    public static void choices_display(){
        System.out.println("Want choices?");
        int x;
        x=sc.nextInt();
        if(x==1){
            for(int i=0;i<rounds;i++){
                for(int j=0;j<3;j++){
                    if(j==0){
                        System.out.print("[");}
                        System.out.print(choices[j][i]);
                    if(j==2){
                        System.out.println("]");}
                    else{
                        System.out.print(" , ");}}
            }
        }
        System.exit(0);
    }
    public static void main(String[] args) {
        System.out.print("Playing ");
        for(int i=0;i<4;i++){
            System.out.print(". ");
        }
        System.out.println();
        for(int i=0;i<rounds;i++){
            input(i);
            scoring(i);
        }
        display();
        draw();
        tie();
        maximum();
    }
}
