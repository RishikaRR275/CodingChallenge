import java.util.ArrayList;
import java.io.*;

class LargestSum{
  static boolean isValidIndex(int i , int j, int numOfEleInRow){
    if(i<0 || j<0 || j>= numOfEleInRow)
      return false;

    return true;
  }
  static public int getLargestSum (int[][] triangle, int n){
    int largestSum = triangle[0][0];
    int[][] intermediateSum = new int[n][n];

    intermediateSum[0][0] = triangle[0][0];

    for(int i = 1; i< n ; i++){
      for(int j = 0 ; j<=i ; j++){
        int maxSum = Integer.MIN_VALUE;
        if(isValidIndex(i-1 , j , i)){
          maxSum = Math.max(maxSum, intermediateSum[i-1][j]+ triangle[i][j]);
        }

        if(isValidIndex(i-1 , j-1 , i)){
          maxSum = Math.max(maxSum, intermediateSum[i-1][j-1]+ triangle[i][j]);
        }

        if(isValidIndex(i-1 , j+1 , i)){
          maxSum = Math.max(maxSum, intermediateSum[i-1][j+1]+ triangle[i][j]);
        }
        intermediateSum[i][j] = maxSum;

        if(largestSum < maxSum)
        largestSum = maxSum;
      }
    }

    return largestSum;
  }
  public static void main(String[] args) throws IOException{
    File file = new File("/home/user/CodingChallenge/LargestSumInput.txt");
    BufferedReader br = new BufferedReader(new FileReader(file));
    ArrayList<String> input = new ArrayList<>();
    String st;
    while ((st = br.readLine()) != null)
      input.add(st);

    int numOfRows = input.size();
    int[][] triangle = new int[numOfRows][numOfRows];
    for(int i = 0 ; i< numOfRows ; i++){
      String[] inputRow = input.get(i).split(" ");
      for(int j = 0; j< inputRow.length ; j++){
        triangle[i][j] = Integer.parseInt(inputRow[j]);
      }
    }

    System.out.println(getLargestSum(triangle , numOfRows));

  }
}
