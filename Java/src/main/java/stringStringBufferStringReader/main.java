package stringStringBufferStringReader;

import java.lang.classfile.instruction.StackInstruction;
import java.util.stream.IntStream;

public class main {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        IntStream.range(0,200).map((a)->1).parallel().forEach(builder::append);
        StringBuffer buffer = new StringBuffer();
        IntStream.range(0,200).map((a)->1).parallel().forEach(buffer::append);
        System.out.println("buffer "+buffer.length());
        System.out.println("builder "+builder.length());

        String s1 = new String("abc");
        String s4 = new String("abc");
        String s2 = "abc";
        String s3 = "abc";
        System.out.println(s1 == s2);
        System.out.println(s2 == s3);
        System.out.println(s1 == s4);


//        Use String when you need immutable sequences of characters
//        Use StringBuilder for mutable sequences of characters in a single-threaded context
//        Use StringBuffer for mutable sequences of characters in a multithreaded context.

        buffer = new StringBuffer();
        buffer.append("Hello");
        StringBuffer buffer2 = new StringBuffer();
        buffer2.append("Hello");
        System.out.println(buffer == buffer2);
        System.out.println(buffer.compareTo(buffer2) == 0);

        builder = new StringBuilder();
        builder.append("Hello");
        StringBuilder builder2 = new StringBuilder();
        builder2.append("Hello");
        System.out.println(builder == builder2);
        System.out.println(builder.compareTo(builder2) == 0);
    }
}
