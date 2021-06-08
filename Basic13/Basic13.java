import java.util.ArrayList;

public class Basic13{

    // public void print1to255(){
    //     int i = 1;
    //     while(i < 256){
    //         System.out.println(i);
    //         i++;
    //     }
    // }

    // public void printOdd(){
    //     for(int i = 1; i <= 255; i++){
    //         if(i %2 == 1){
    //             System.out.println(i);
    //         }
    //     }
    // }

    // public void sumNums(){
    //     int sum = 0;
    //     for(int i =0; i<= 255; i++){
    //         sum+=i;
    //         System.out.println("New Number: " + i +" " + "Sum: " + sum);
    //     }
    // }


// public void iterArr(int[] myArr){
//     for(int i=0; i < myArr.length; i++){
//         System.out.println(myArr[i]);
//     }
// }

// public int findMax(int[] myArr){
//     int max = 0;
//     for(int i =0; i < myArr.length; i++){
//         if(myArr[i] > max){
//             max = myArr[i];
//         }
//     }
//     return max;
// }

// public int findAvg(int[] myArr){
//     int sum =0;
//     int avg =0;
//     for(int i =0; i < myArr.length; i++){
//         sum += myArr[i];
//         avg = sum/ myArr.length;
//     }
//     return avg;
// }

public ArrayList oddArray(){
    ArrayList<Object> y = new ArrayList<Object>();

    for(int i = 1; i<= 255; i++ ){
        if( i %2 == 1){
            y.add(i);
        }
    }
    return y;
}


public ArrayList findSquares(int[] myArr){
    ArrayList<Integer> newArray = new ArrayList<Integer>();
    for(int i =0; i < myArr.length; i++){
        int square = myArr[i]*myArr[i];
        newArray.add(square);
    }
    return newArray;
}


public ArrayList noNegs(int[] myArr){
    ArrayList<Integer> newArray = new ArrayList<Integer>();
    for(int i = 0; i < myArr.length; i++){
        if(myArr[i] < 0){
            newArray.add(0);
        }else{newArray.add(myArr[i]);
        }
    }
    return newArray;
}



public ArrayList minMaxAvg(int[] myArr){
    ArrayList<Object> newArray = new ArrayList<Object>();
    int minimum = myArr[0];
    int maximum = myArr[0];
    int sum = 0;
    double avg = 0;

    for (int i=0; i<myArr.length; i++) {
        sum += myArr[i];
        // find the minimum of myArr
        if (minimum > myArr[i]) {
            minimum = myArr[i];
        }

        //find the maximum in myArr
        if (maximum < myArr[i]) {
            maximum = myArr[i];
        }
    }
    // find the average and casting sum to a double
    avg = (double) sum / myArr.length;
    
    newArray.add(minimum);
    newArray.add(maximum);
    newArray.add(avg);

    return newArray;

}


public void shiftValues(int[] myArr){
    int temp = myArr[myArr.length-1];
    for(int i = 0; i < myArr.length-1; i ++){
        myArr[i] = myArr[i+1];
        myArr[i] = temp;
    }
}




}