package org.LSNTest;

import java.util.HashSet;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please provide number of connections:");
        int connectionsSize = 1;
        try{
            connectionsSize = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e){
            e.printStackTrace();
        }

        IntPair[] vertices = new IntPair[connectionsSize];
        HashSet<Integer> distinctVertices = new HashSet<Integer>();
        System.out.println("Please input connections:");
        for (int i = 0; i < connectionsSize; i++) {
            String[] splitInput = scanner.nextLine().split(" ");

            vertices[i] = new IntPair(Integer.parseInt(splitInput[0]), Integer.parseInt(splitInput[1]));

            distinctVertices.add(Integer.parseInt(splitInput[0]));
            distinctVertices.add(Integer.parseInt(splitInput[1]));
        }

        UnionFind unionFind = new UnionFind(distinctVertices.stream().mapToInt(Integer::intValue).toArray());
        for (int i=0; i<vertices.length; i++){
            unionFind.Union(vertices[i].A, vertices[i].B);
        }

        System.out.println("Number of separated graphs: " + unionFind.GetSubSetsCount());
    }
}
