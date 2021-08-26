import java.util.ArrayList;
import java.util.Scanner;

public class Q1 {
    static int n,t,m;
    static String temp = "";
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        n = Integer.parseInt(input.nextLine());
        t = Integer.parseInt(input.nextLine());
        m = Integer.parseInt(input.nextLine());


        ArrayList<Integer> prime = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>();
        ArrayList<String> string = new ArrayList<>();

        ArrayList<Integer> newPrime = new ArrayList<>();
        ArrayList<Integer> newSecond = new ArrayList<>();
        ArrayList<String> newString = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            temp = input.nextLine();
            int numCount = 0, numPointer = 0;
            for (int j = 0; j < temp.length(); j++) {
                if (temp.charAt(j) == ' ' || temp.length()-1==j) {
                    switch (numCount) {
                        case 0:
                            prime.add(Integer.parseInt(temp.substring(0, j)));
                            break;
                        case 1:
                            second.add(Integer.parseInt(temp.substring(numPointer+1, j)));
                            break;
                        case 2:
                            string.add(temp.substring(numPointer+1, j+1));
                            break;
                    }
                    numPointer = j;
                    numCount++;
                }
            }
        }

        prime.add(0, n+1);
        second.add(0,t);
        string.add(0,"-");

        for (int i = 0; i < m+1; i++) {
            if (prime.get(i) != n+1 && second.get(i) == 0){
                newPrime.add(n+1);
                newSecond.add(prime.get(i));
                newString.add(string.get(i));
            }else if (prime.get(i) != n+1 && second.get(i) != 0 ){
                newPrime.add(second.get(i));
                newSecond.add(prime.get(i));
                newString.add(string.get(i));
            }else if (prime.get(i) == n+1 && second.get(i) != 0 ){
                newPrime.add(second.get(i));
                newSecond.add(0);
                newString.add(string.get(i));
            }else{
                newPrime.add(prime.get(i));
                newSecond.add(second.get(i));
                newString.add(string.get(i));
            }
        }

        System.out.println(n+1);
        System.out.println(n+1);
        System.out.println(m+1);

        for (int i = 0; i < m+1; i++)
            System.out.println(newPrime.get(i) + " "+ newSecond.get(i)+" "+newString.get(i));

    }
}
