/*PROBLEM:
You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly 
one island (i.e., one or more connected land cells).

The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side 
length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

Example:
Input:
[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Output: 16

Explanation: The perimeter is the 16 yellow stripes in the image below:
https://assets.leetcode.com/uploads/2018/10/12/island.png
*/

class Solution {
    static int waterSides(int[][] grid, int i, int j){
        int sides=0;
        if(i==0) sides++;
        if(i==grid.length-1) sides++;
        if(j==0) sides++;
        if(j==grid[0].length-1) sides++;
        if(i>0 && grid[i-1][j]==0) sides++;
        if(i<grid.length-1 && grid[i+1][j]==0) sides++;
        if(j>0 && grid[i][j-1]==0) sides++;
        if(j<grid[0].length-1 && grid[i][j+1]==0) sides++;
        return sides;
    }
    public int islandPerimeter(int[][] grid) {
        int count=0;
        for(int i=0; i<grid.length; i++)
            for(int j=0; j<grid[0].length; j++)
                if(grid[i][j]==1)
                    count+=waterSides(grid, i, j);
        return count;       
    }
}
