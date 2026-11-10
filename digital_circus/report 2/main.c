#include <inttypes.h>
#include <stdint.h>
#include <stdio.h>

typedef uint64_t u64;
typedef  int64_t i64;

typedef uint32_t u32;

int main()
{
    {
        u32 myStudentID = 25122026;
        printf("My Student ID=%u (0x%x)\n", myStudentID, myStudentID);
    }

    {
        u64 minU64 = 0;
        u64 maxU64 = UINT64_MAX;    // 18446744073709551615

        printf("uint64_t_min=%" PRIu64 ",uint64_t_max=%" PRIu64 "\n", minU64, maxU64);
    }

    {
        i64 minI64 = INT64_MIN;     // -9223372036854775808
        i64 maxI64 = INT64_MAX;     // 9223372036854775807

        printf("int64_t_min=%" PRId64 ",int64_t_max=%" PRId64 "\n", minI64, maxI64);
    }
    
    return 0;
}