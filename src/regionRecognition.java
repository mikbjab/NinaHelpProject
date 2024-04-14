import java.util.ArrayList;
import java.util.List;

public class regionRecognition {
    private static int checkNeighbour(int[][] array,List<int[]> currentRegion, int[] currentPixel, int row,int column){
        int newRow=currentPixel[0]+row;
        int newColumn=currentPixel[1]+column;
        if(newColumn<0 || newRow<0 || newRow>=array.length || newColumn>= array[0].length){
            return 0;
        }
        if(array[newRow][newColumn]>0){
            currentRegion.add(new int[]{newRow,newColumn});
            array[newRow][newColumn]=0;
            return 1;
        }
        return 0;
    }

    public static void main(String[] args){
        int[][] input= {{1,1,0,1},{1,1,0,0},{0,2,0,0}}; //input[i][j] -> i-th row, j-th column
        int[][] neighbours={{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
        List<Integer> regionSizes=new ArrayList<>();

        for(int i=0; i<input.length;i++){
            for (int j = 0; j < input[0].length; j++) {

                if(input[i][j]>0){
                    List<int[]> region=new ArrayList<>();
                    region.add(new int[]{i, j});
                    int tempSize=1;
                    while(!region.isEmpty()){
                        int[] temp=region.remove(0);
                        input[temp[0]][temp[1]]=0;
                        for (int[] pair : neighbours) {
                            tempSize+=checkNeighbour(input,region,temp,pair[0],pair[1]);
                        }
                    }
                    regionSizes.add(tempSize);
                }
            }
        }

        System.out.println(regionSizes);
        System.out.println(regionSizes.size());


    }
}
