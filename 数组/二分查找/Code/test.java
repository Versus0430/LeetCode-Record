import java.util.Arrays;

class Solutions {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int startIndex = 0;
        int endIndex = n - 1;
        int number = 0;
        while(startIndex <= endIndex) {
            for(int i = startIndex; i <= endIndex; i++) {
                ++number;
                res[startIndex][i] = number;
                res[i][endIndex] = number + endIndex - startIndex;
            }
            int temp = res[startIndex][startIndex];
            for(int j = endIndex; j >= startIndex; j--) {
                res[endIndex][j] = number + endIndex - startIndex;
                res[j][startIndex] = number + 2*(endIndex - startIndex);
            }
            res[startIndex][startIndex] = temp;
            number = res[startIndex][startIndex + 1];
            startIndex++;
            endIndex--;
            if(startIndex > endIndex) {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int n=3;
        Solutions s = new Solutions();
        System.out.println(Arrays.deepToString(s.generateMatrix(n)));
    }
}
