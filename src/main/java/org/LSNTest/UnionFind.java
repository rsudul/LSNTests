package org.LSNTest;

import java.util.HashMap;
import java.util.Map;

public class UnionFind{
    private Map<Integer, Integer> Parents; // key - vertex, value - its parent (representative)
    private Map<Integer, Integer> NodesSizes; // key - vertex, value - size
    private int SubSetsCount;

    public UnionFind(int[] nums){
        Parents = new HashMap<>();
        NodesSizes = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            Parents.put(nums[i], nums[i]);
            NodesSizes.put(nums[i], 1);
        }

        SubSetsCount = nums.length;
    }

    private int Find(int x){
        if (Parents.get(x) == x){
            return x;
        } else{
            int result = Find(Parents.get(x));
            Parents.put(x, result);
            return result;
        }
    }

    public void Union(int x, int y){
        int xRep = Find(x);
        int yRep = Find(y);

        if (xRep == yRep){
            return;
        }

        int xSize = NodesSizes.get(xRep);
        int ySize = NodesSizes.get(yRep);

        if (xSize < ySize){
            Parents.put(xRep, yRep);
            NodesSizes.put(yRep, NodesSizes.get(yRep) + NodesSizes.get(xRep));
        } else{
            Parents.put(yRep, xRep);
            NodesSizes.put(xRep, NodesSizes.get(xRep) + NodesSizes.get(yRep));
        }

        SubSetsCount--;
    }

    public int GetSubSetsCount(){
        return SubSetsCount;
    }
}
