/* 011. Container With Most Water */
/* Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). */
/* n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). */
/* Find two lines, which together with x-axis forms a container, such that the container contains the most water. */
#include <math.h>
#include <stdlib.h>
#include <stdio.h>


int get_area(int ax, int ay, int bx, int by)
{
    int area_size;
    area_size = ay > by ? abs(ax - bx) * by : abs(ax-bx) * ay;

    printf("area: %d\n", area_size);
    return area_size;
}
int maxArea(int* height, int heightSize)
{
    int max = 0, current_area;
    int right, left;

    right = 0;
    left = heightSize - 1;

    while (right < left) {
        current_area = get_area(right, height[right], left, height[left]);
        if (max < current_area) {
            max = current_area;
        }

        if (height[right] > height[left]) {
            left --;
        } else {
            right ++;
        }
    }


    return max;
}



int main(int argc, char const* argv[])
{
    int heightSize = 2;
    int height[2] = {1,2};

   printf("max: %d\n", maxArea(height, heightSize));




    return 0;
}
