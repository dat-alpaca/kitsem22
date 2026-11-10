#include <stdio.h>
#include <stdint.h>

typedef uint32_t u32;

#define ARBITRARY_CONSTANT 0x1234567

int main()
{
    u32 myStudentID = 25122026;
    printf("id=%u,0x%07x\n", myStudentID, myStudentID);
    
    u32 result = myStudentID | ARBITRARY_CONSTANT;
    printf("id|0x%07x=%07x\n", ARBITRARY_CONSTANT, result);

    result = myStudentID & ARBITRARY_CONSTANT;
    printf("id&0x%07x=%07x\n", ARBITRARY_CONSTANT, result);

    result = myStudentID ^ ARBITRARY_CONSTANT;
    printf("id^0x%07x=%07x\n", ARBITRARY_CONSTANT, result);

    return 0;
}