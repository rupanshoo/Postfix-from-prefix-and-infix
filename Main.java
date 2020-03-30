//package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int search(int in[], int x, int n)
    {
        for (int i = 0; i < n; i++)
            if (in[i] == x)
                return i;
        return -1;
    }

    /*static int search(int arr[], int l, int h, int x){

        if(l>h)
            return -1;
        else{
            int m = (l+h)/2;
            if(arr[m] == x)
                return m;
            else if(arr[m] > x)
                return search(arr, l,m-1,x);
            else if (arr[m]<x)
                return search(arr,m+1,h,x);
            return -1;
        }
    }*/


    static void PostOrder(int in[], int pre[], int n){
        int root = search(in, pre[0], n);
        //int root = search(in, 0, n-1, pre[0]); // to search for the root as 1st element in preorder is always the root.
        // we are locating the root i.e. pre[0] in the inorder array so as to identify the left and right subtree.

        if(root != 0) //if left subtree != 0, printing it.
            PostOrder(in, Arrays.copyOfRange(pre,1,n), root);  // copyOfRange function will create a copy of the array pre from it's 1st index to nth index.

        if(root != n-1)  // if right subtree != 0, printing it.
            PostOrder(Arrays.copyOfRange(in, root+1,n),Arrays.copyOfRange(pre,1+root,n),n-root-1);  //copyOfRange function will create a copy of the array specified from it's starting index to its ending index which have been specified.
        System.out.println(pre[0] + " ");
    }
    static int checkAscending(int arr[], int n){  // to check for BST
        if (n==1 || n==0)
                return 1;
        if(arr[n-1] < arr[n-2])
            return 0;
        return checkAscending(arr, n-1);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int noOfNodes = scan.nextInt();
        int[] inorder = new int[noOfNodes];
        int[] preorder = new int[noOfNodes];

        for(int i =0; i<noOfNodes; i++){  //input preorder
            preorder[i] = scan.nextInt();
        }
        for(int j=0;j<noOfNodes;j++){  //input inorder
            inorder[j] = scan.nextInt();
        }

       PostOrder(inorder,preorder,noOfNodes);

        if(checkAscending(inorder, noOfNodes) != 0)    // since in-order in a BST is in ascending order.
            System.out.println("YES");
        else
            System.out.println("NO");

    }
}
