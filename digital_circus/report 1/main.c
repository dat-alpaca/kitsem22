#include <stdio.h>
#include <stdint.h>

typedef uint32_t u32;
typedef  int32_t i32;

int main()
{
    {
        u32 myStudentID = 25122026;
        printf("My Student ID=%u (0x%x)\n", myStudentID, myStudentID);
    }

    {
        u32 minU32 = 0;
        u32 maxU32 = UINT32_MAX;    // 4294967295U

        printf("uint32_t_min=%u,uint32_t_max=%u\n", minU32, maxU32);
    }

    {
        i32 minI32 = INT32_MIN;     // -2147483647-1
        i32 maxI32 = INT32_MAX;     // 2147483647

        printf("int32_t_min=%d,int32_t_max=%d\n", minI32, maxI32);
    }
    
    return 0;
}