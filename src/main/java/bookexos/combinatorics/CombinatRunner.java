package bookexos.combinatorics;

public class CombinatRunner {

    public static void main(String[] args) throws Exception {

        CombinatExamples combinatExamples = new CombinatExamples();

        int[][] t = {{1, 2, 3},
                {1, 3, 1},
                {3, 1, 2},
                {2, 1, 3},
                {2, 3, 1},
                {3, 2, 1}};

        int[][] tab = combinatExamples.allPermutations(4);

        for (int i = 0; i < tab.length; i++) {
            String output = "";
            for (int j = 0; j < tab[i].length; j++) {
                output = output + " " + tab[i][j];
            }
            System.out.println("line permutation  : " + output);
        }
    }
}
