package dev.lpa;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int [][] array2 = new int[4][4];
        System.out.println(Arrays.toString(array2));
        System.out.println("array2.length = " + array2.length);

        for(int[] outer: array2){
            System.out.println(Arrays.toString(outer));
        }

        for(int i = 0; i < array2.length; i++){
            //Here, we assign each element to a variable in the loop. We use var so Java can infer the type of elements.
            var innerArray = array2[i];
            //Below, we loop through each of the elements that are in each of these nested arrays:
            //for loop for inner array:
            for(int j = 0; j < innerArray.length; j++){
                //System.out.println(array2[i][j] + " ");
                array2[i][j] = (i * 10) + (j + 1);
            }
            System.out.println();
        }

        //When we access a one dimensional array element, we do it with square brackets, and an index value.

        //To access elements in a two-dimensional array, we use two indices (twoDArray [0][0] = 50).

        for(var outer : array2){
            for(var element : outer){
                System.out.print(element + " ");
            }
        }
        System.out.println();
        System.out.println(Arrays.deepToString(array2));

        //We can assign any array of integer to one of the outer array's elements, seen below:

        //We are assigning array 2's second element to a new int array containing 3 elements:

        array2[1] = new int[]{10,20,30};
        System.out.println(Arrays.deepToString(array2));
        //When we run the code above, we still have the other assigned values from the nested for loops- but we
        //manually insert the values 10, 20, and 30 into the 2nd "array element"- or the second array in the multi
        //dimensional array.

        //Two Dimensional Array:

        //When we declare multi-dimensional arrays, the declared type can itself can be an array, and this is how Java
        //supports two-dimensional arrays:

        //int [][] myArray = new int[3][];  <-- Declares and instantiates an array of 3 integer arrays, whose sizes are
        //not specified.

        //Dog [][] myDogs = new Dog[3][]; <-- Declares and instantiates an array of 3 arrays, which will have Dog elements
        //, again, the sizes of the inner arrays aren't specified.

        //Type and length of array                  Possible Element Values(each element is an array and can be any length)

        //int[3][]                                      [5, 7, 9, 10]
        //                                              [3, 6]
        //                                              [11, 21, 31]
        //------------------------------------------------------------
        //Dog[3][]                                      [pug, rottweiler]
        //                                              [germanShephard, poodle, cavapoo]
        //                                              [beagle, boxer, bulldog, yorkie]

        //We can take that even further, the outer array can have references to any kind of array itself.

        //In the example below, we have an outer array with three elements:

        //Object[] multiArray = new Object[3];
        //multiArray[0] = new Dog[3];           The first element is itself a single dimension array.
        //multiArray[1] = new Dog[3][];         The second element is a two-dimensional array.
        //multiArray[3] = new Dog[3][][];       The third element is a three-dimensional array.

        Object[] anyArray = new Object[3];      //Here, we are creating an array of 3 objects in this statement.
        System.out.println(Arrays.toString(anyArray));

        anyArray[0] = new String[]{"a", "b", "c"};  //Here, we assign our first element of our array at index 0 to a
        System.out.println(Arrays.deepToString(anyArray));  //String array which has 3 elements.
        //Running the above code, we can see that we now have a nested array, and we've nested the "abc" String array
        //in our outer array.

        anyArray[1] = new String [][]{
                {"1", "2"},
                {"3", "4", "5"},
                {"6", "7", "8", "9"}
        };
        System.out.println(Arrays.deepToString(anyArray));
        //Above we are setting element 2 as a two-dimensional array.
        //We are saying the 2nd element of our outermost array is a two-dimensional String array, and we're using an
        //array creation expression with an array initializer.

        anyArray[2] = new int[2][2][2];
        System.out.println(Arrays.deepToString(anyArray));
        //Above we are saying element 3 is now a 3 dimensional array with 2 elements each.

        for(Object element: anyArray){
            System.out.println("Element type = " + element.getClass().getSimpleName());
            System.out.println("Element toString() = " + element);
            System.out.println(Arrays.deepToString((Object[])element));
        }
        //In the above for each loop, we're using Object as the type of our variable element in the loop declaration.

        //First, we print out the class name of each element in this array.

        //Second, we print out the toString() representation of each array element.

        //And then we print out each element contained in this multi-dimensional array.

        //We know that each element is an array, but the compiler doesn't know that.

        //The Arrays.deepToString method takes an array, so we need to cast our element to an array of Object before
        //we pass it to this method.

        //If we were to assign this to something other than an array, it would break the code, but we cast it.
        }

    }



//Java's nested arrays:

//An array element can actually be an array. It's known as a nested array, or an array assigned to another outer array's
//element.

//This is how Java supports two and three-dimensional arrays, of varying dimensions.

//A two-dimensional array can be thought of as a table or matrix of values, with rows and columns.

//You can use an array initializer for this, as seen below:

//Array initializer over multiple lines:

//int [][] array = {

//                          {1, 2, 3},
//                          {11, 12, 13},
//                          {21, 22, 23},
//                          {31, 32, 33},
//                          };

//Array initializer declared on one line:

//int [][] array = {{1,2,3}, {11,12,13}, {21,22,23}, {31,32,33}};

//Using the double brackets tells Java we want two-dimensional array of integers.

//In the above examples, the arrays are in a uniform matrix. This does not need to be the case, however.

//See the example below:

//int [][] array = {

//                        {1, 2},
//                        {11, 12, 13},
//                        {21, 22, 23, 24, 25}
//                        };

//Above, we have 3 elements. Each element is an array of integers (A nested array). Each nested array is a different length.

//You can initialize a two-dimensional array, and define the size of the nested arrays, as shown below:

//int [][] array = new int [3][3];

//The above says we have an array of 3 nested arrays, and each nested array will have 3 ints.

//This would initialize a 3x3 matrix of ints, and the default values of 0.

//You can also initialize a two-dimensional array without specifying the size of the nested arrays:

//int [][] array = new int [3][];

//Above, we are specifying only the outer array size, by specifying the length, only in the first set of square brackets.

//We've left the second set of square brackets empty.

//The result of this initialization is an array of 3 null elements.

//We are limited to assigning integer arrays to these elements, but they can be any length.

//There are many ways to declare a two-dimensional array.

//The most common, and arguably the clearest way, is to stack the square brackets (int[][] myDoubleArray;)

//You can also split up the brackets (int[] myDoubleArray[];)