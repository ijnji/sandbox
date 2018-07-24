CFLAGS= -f elf32
LFLAGS= -m elf_i386

all: hello_world

hello_world: hello_world.o
	ld $(LFLAGS) -o hello_world hello_world.o

hello_world.o: hello_world.asm
	nasm $(CFLAGS) -o hello_world.o hello_world.asm

clean:
	rm -f hello_world.o hello_world

.INTERMEDIATE: hello_world.o