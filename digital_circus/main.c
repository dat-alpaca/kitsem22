#include <assert.h>
#include <stdio.h>
#include <time.h>

#include "defines.h"

typedef struct
{
    time_t timer;
    struct tm* date;
} context_t;

static void initialize_timer(context_t* context)
{
    assert(context);

    context->timer = time(NULL);
    context->date = localtime(&context->timer);
}

int main()
{
    context_t context = { };
    {
        initialize_timer(&context);
        printf("Execution Date & Time: %s\n", asctime(context.date));
    }

    u8 AU = 64;
    u8 BU = (u8)-64;

    i8 A = 64;
    i8 B = -64;

    printf("Variables:\n");
    printf("AU      = %4d | A       = %4d | BU      = %4d | B       = %4d\n", AU, A, BU, B);
    printf("AU      = 0x%02x | A       = 0x%02x | BU      = 0x%02x | B       = 0x%02x\n", AU, A & 0xff, BU, B & 0xff);

    printf("\nShifted:\n");
    {
        u8 AUS = AU << 1;
        u8 BUS = BU << 1;
        i8 AS  = A << 1;
        i8 BS  = B << 1;

        printf("AU << 1 = %4d | A << 1  = %4d | BU << 1 = %4d | B << 1  = %4d\n", AUS, AS, BUS, BS);
        printf("AU << 1 = 0x%02x | A << 1  = 0x%02x | BU << 1 = 0x%02x | B << 1  = 0x%02x\n", AUS, AS & 0xff, BUS, BS & 0xff);
    }

    return 0;
}