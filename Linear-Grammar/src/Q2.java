import java.util.ArrayList;
import java.util.Scanner;

public class Q2 {

    static int statesCount1 , alphabetCount1;
    static ArrayList<Integer> finalStates1  = new ArrayList<>();
    static ArrayList<yaal> yaals1 = new ArrayList<>();

    static int statesCount2 , alphabetCount2;
    static ArrayList<Integer> finalStates2 = new ArrayList<>();
    static ArrayList<yaal> yaals2 = new ArrayList<>();

    static ArrayList<states> queue = new ArrayList<>();
    static ArrayList<states> checked = new ArrayList<>();

    public static void main(String[] args){
        Scanner getter = new Scanner(System.in);
        String temp;
        int numCount = 0, numPointer = 0;


        temp = getter.nextLine();
        numCount = 0;
        numPointer = 0;
        for (int j = 0; j < temp.length(); j++) {
            if (temp.charAt(j) == ' ' || temp.length() - 1 == j) {
                switch (numCount) {
                    case 0:
                        statesCount1 = Integer.parseInt(temp.substring(0, j));
                        break;
                    case 1:
                        for (int i = 0; true; i++) {
                            try {
                                alphabetCount1 = Integer.parseInt(temp.substring(numPointer + 1, j + 1 -i));
                                break;
                            } catch (Exception e){
                            }
                        }

                        break;
                }
                numPointer = j;
                numCount++;
            }
        }

//        System.out.println(statesCount1 + " - "+ alphabetCount1);


        temp = getter.nextLine();
        numCount = 0;
        numPointer = 0;
        for (int j = 0; j < temp.length(); j++) {
            if (temp.charAt(j) == ' ' || temp.length() - 1 == j) {
                switch (numCount) {
                    case 0:

                        if (temp.length() - 1 == j) {
                            for (int i = 0; true; i++) {
                                try {
                                    finalStates1.add(Integer.parseInt(temp.substring(0, j + 1-i)));
                                    break;
                                } catch (Exception e){
                                }
                            }

                        } else {
                            finalStates1.add(Integer.parseInt(temp.substring(0, j)));
                        }
                        break;
                    default:
                        if (temp.length() - 1 == j) {
                            for (int i = 0; true; i++) {
                                try {
                                    finalStates1.add(Integer.parseInt(temp.substring(numPointer + 1, j + 1-i)));
                                    break;
                                } catch (Exception e){
                                }
                            }
                        } else {
                            finalStates1.add(Integer.parseInt(temp.substring(numPointer + 1, j)));
                        }
                }
                numPointer = j;
                numCount++;

            }
        }

//        for (int i = 0; i < finalStates1.size(); i++)
//            System.out.println(finalStates1.get(i));

        statesGetter(getter, statesCount1, yaals1);

//        System.out.println("___________");
//        for (int i = 0; i < yaals1.size(); i++)
//            System.out.println(yaals1.get(i).from + " --"+yaals1.get(i).alphabet + "--> "+yaals1.get(i).to);
//        System.out.println("___________");

//___________________________________________________________________________


        temp = getter.nextLine();
        numCount = 0;
        numPointer = 0;
        for (int j = 0; j < temp.length(); j++) {
            if (temp.charAt(j) == ' ' || temp.length() - 1 == j) {
                switch (numCount) {
                    case 0:
                        statesCount2 = Integer.parseInt(temp.substring(0, j));
                        break;
                    case 1:
                        for (int i = 0; true; i++) {
                            try {
                                alphabetCount2 = Integer.parseInt(temp.substring(numPointer + 1, j + 1 -i));
                                break;
                            } catch (Exception e){
                            }
                        }
                        break;
                }
                numPointer = j;
                numCount++;
            }
        }

//        System.out.println(statesCount2 + " - "+ alphabetCount2);

        temp = getter.nextLine();
        numCount = 0;
        numPointer = 0;
        for (int j = 0; j < temp.length(); j++) {
            if (temp.charAt(j) == ' ' || temp.length() - 1 == j) {
                switch (numCount) {
                    case 0:

                        if (temp.length() - 1 == j) {
                            for (int i = 0; true; i++) {
                                try {
                                    finalStates2.add(Integer.parseInt(temp.substring(0, j + 1-i)));
                                    break;
                                } catch (Exception e){
                                }
                            }
                        } else {
                            finalStates2.add(Integer.parseInt(temp.substring(0, j)));
                        }
                        break;
                    default:
                        if (temp.length() - 1 == j) {
                            for (int i = 0;true; i++) {
                                try {
                                    finalStates2.add(Integer.parseInt(temp.substring(numPointer + 1, j + 1-i)));
                                    break;
                                } catch (Exception e){
                                }
                            }
                        } else {
                            finalStates2.add(Integer.parseInt(temp.substring(numPointer + 1, j)));
                        }
                }
                numPointer = j;
                numCount++;
            }
        }

//        for (int i = 0; i < finalStates2.size(); i++)
//            System.out.println(finalStates2.get(i));

        statesGetter(getter, statesCount2, yaals2);





//        System.out.println("___________");
//        for (int i = 0; i < yaals2.size(); i++)
//            System.out.println(yaals2.get(i).from + " --"+yaals2.get(i).alphabet + "--> "+yaals2.get(i).to);
//        System.out.println("___________");

        if (finalStates1.contains(1) != finalStates2.contains(1)) {
            System.out.println("no");
            return;
        }

        for (int i = 0; i < finalStates1.size(); i++)
            for (int j = 0; j < finalStates2.size(); j++) {
                queue.add(new states(finalStates1.get(i), finalStates2.get(j)));
            }


        while (queue.size() != 0) {

            int state1 = queue.get(0).state1;
            int state2 = queue.get(0).state2;
            checked.add(queue.get(0));
            queue.remove(0);

            for (int i = 0; i < yaals1.size(); i++)
                for (int j = 0; j < yaals2.size(); j++)
                    for (int k = 0; k < alphabetCount1; k++)
                        for (int l = 0; l < alphabetCount2; l++)
                            if (k == l && yaals1.get(i).getFrom() == state1 && yaals1.get(i).getAlphabet() == k
                                    && yaals2.get(j).getFrom() == state2 && yaals2.get(j).getAlphabet() == l) {
                                int to1 = yaals1.get(i).getTo();
                                int to2 = yaals2.get(j).getTo();


                                if ((finalStates1.contains(to1) && !finalStates2.contains(to2))
                                        || (!finalStates1.contains(to1) && finalStates2.contains(to2))) {
                                    System.out.println("no");
                                    return;
                                } else {

                                    boolean add = true;
                                    for (int p = 0; p < queue.size(); p++)
                                        if (queue.get(p).state1 == to1 && queue.get(p).state2 == to2) {
                                            add = false;
                                            break;
                                        }

                                    if (add)
                                        for (int p = 0; p < checked.size(); p++)
                                            if (checked.get(p).state1 == to1 && checked.get(p).state2 == to2) {
                                                add = false;
                                                break;
                                            }

                                    if (add)
                                        queue.add(new states(to1, to2));


                                }
                            }
        }

        System.out.println("yes");

    }

    private static void statesGetter(Scanner getter, int statesCount1, ArrayList<yaal> yaals1) {
        String temp;
        int numCount;
        int numPointer;
        for (int i = 1; i < statesCount1 +1; i++) {
            temp = getter.nextLine();
            numCount = 0;
            numPointer = 0;
            for (int j = 0; j < temp.length(); j++) {
                if (temp.charAt(j) == ' ' || temp.length() - 1 == j) {
                    switch (numCount) {
                        case 0:
                            if (temp.length() - 1 == j) {
                                for (int o = 0; true; o++) {
                                    try {
                                        yaals1.add(new yaal(i, numCount+1, Integer.parseInt(temp.substring(0, j+1-o))));
                                        break;
                                    } catch (Exception e){
                                    }
                                }
                            } else {
                                yaals1.add(new yaal(i, numCount+1, Integer.parseInt(temp.substring(0, j))));
                            }

                            break;
                        default:
                            if (temp.length() - 1 == j) {
                                for (int o = 0; true; o++) {
                                    try {
                                        yaals1.add(new yaal(i, numCount+1, Integer.parseInt(temp.substring(numPointer + 1, j + 1-o))));
                                        break;
                                    } catch (Exception e){
                                    }
                                }

                            } else {
                                yaals1.add(new yaal(i, numCount+1, Integer.parseInt(temp.substring(numPointer + 1, j))));
                            }
                    }
                    numPointer = j;
                    numCount++;
                }
            }
        }
    }

    static class yaal {
        int from ;
        int alphabet;
        int to;

        public yaal(int from, int alphabet, int to) {
            this.from = from;
            this.alphabet = alphabet;
            this.to = to;
        }

        public void setFrom(int from){
            this.from = from;
        }
        public void setAlphabet(int alphabet){
            this.alphabet = alphabet;
        }
        public void setTo(int to){
            this.to = to;
        }

        public  int getFrom(){
            return from;
        }
        public  int getAlphabet(){
            return alphabet;
        }
        public  int getTo(){
            return to;
        }

    }

    static class states {
        int state1 ;
        int state2;

        public states(int state1, int state2) {
            this.state1 = state1;
            this.state2 = state2;
        }

        public int getState1() {
            return state1;
        }

        public void setState1(int state1) {
            this.state1 = state1;
        }

        public int getState2() {
            return state2;
        }

        public void setState2(int state2) {
            this.state2 = state2;
        }
    }
}
