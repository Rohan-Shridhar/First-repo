import java.util.Scanner;
public class Trion {
    public static Scanner sc=new Scanner(System.in);
    public static int x=0,y=0,z=0;
    public static void winner(int l,int a,int b,int c){
        if (l==a) {
            System.out.println("Alice won");
        }
        else if (l==b) {
            System.out.println("Bob won");
        } else {
            System.out.println("Charlie won");
        }
    }
    public static void maximum(int a,int b,int c){
        int large=a>b&&a>c?a:b>c?b:c;
        winner(large,a,b,c);
    }
    public static void draw(int a,int b,int c){
        if (a==b&&a>c) {
            System.out.println("Alice and Bob won");
            System.exit(0);
        }
        if (c==b&&a<c) {
            System.out.println("Bob and Charlie won");
            System.exit(0);
        }
        if (a==c&&a>b) {
            System.out.println("Alice and Charlie won");
            System.exit(0);
        }
    }
    public static void tie(int a,int b,int c){
        if(a==b&&a==c){
            System.out.println("Its a tie!!");
            System.exit(0);
        }
    }
    public static void score(int a,int b,int c){
        if(a==b&&b==c){
            if(a==1){
                x+=3;
                y+=3;
                z+=3;
            }
            if (a==0) {
                x+=1;
                y+=1;
                z+=1;           
            }
        }else if (a==b&&a!=c) {
            z+=5;
        }else if (a==c&&a!=b) {
            y+=5;
        }else if (c==b&&a!=c) {
            x+=5;
        }
    }
    public static void display(){
        System.out.println("Alice: "+x);
        System.out.println("Bob: "+y);
        System.out.println("Charlie: "+z);
    }
    public static void main(String[] args){
        int Alice,Bob,Charlie;
        int r=1;
        r=2;
        for(int i=0;i<r;i++)
        {
            System.err.println("ROUND "+(i+1));
        System.out.println("Alice choice");
        while(true){
            Alice=sc.nextInt();
            if (Alice==0 || Alice==1)
                break;
            }
        
        System.out.println("Bob choice");
        while(true){
            Bob=sc.nextInt();
            if (Bob==0 || Bob==1)
                break;
            }
        System.out.println("Charlie choice");
        while(true){
            Charlie=sc.nextInt();
            if (Charlie==0 || Charlie==1)
                break;
            }
        score(Alice, Bob, Charlie);
        }
        display();
        draw(x, y, z);
        tie(x,y,z);
        maximum(x, y, z);
    }
    }