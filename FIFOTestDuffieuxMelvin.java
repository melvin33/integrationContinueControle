package test;

import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

public class FIFOTestDuffieuxMelvin {

    @BeforeEach
    void setUp() throws Exception {

    }
    
    @AfterEach
    void tearDown() throws Exception {
        
    }
    
    @ParameterizedTest()
    @MethodSource("add")
    void addFifo(int nombre, int resultatAttendu) {
        FIFO maFifo = new FIFO();
        maFifo.add(nombre);
        
        int firstElement = maFifo.first();
        
        assertEquals(resultatAttendu, firstElement);
    }
    
    static Stream<Arguments> add() throws Throwable{
        return Stream.of(Arguments.of(0, 0), Arguments.of(-1, -1), Arguments.of(1, 1));
    }
    
    @ParameterizedTest()
    @MethodSource("first")
    void firstFifo(int nombre, int resultatAttendu) {
        FIFO maFifo = new FIFO();
        maFifo.add(nombre);
        
        int firstElement = maFifo.first();
        
        assertEquals(resultatAttendu, firstElement);
    }
    
    static Stream<Arguments> first() throws Throwable{
        return Stream.of(Arguments.of(0, 0), Arguments.of(-1, -1), Arguments.of(1, 1));
    }
    
    @ParameterizedTest()
    @MethodSource("empty")
    void emptyFifo() {
        FIFO maFifo = new FIFO();
        
        assertTrue(maFifo.isEmpty());
    }
    
    static Stream<Arguments> empty() throws Throwable{
        return Stream.of(Arguments.of(), Arguments.of(), Arguments.of());
    }
    
    @ParameterizedTest()
    @MethodSource("remove")
    void removeFifo(int nombre1, int nombre2, int resultatAttendu) {
        FIFO maFifo = new FIFO();
        
        maFifo.add(nombre1);
        maFifo.add(nombre2);
        
        maFifo.removeFirst();
        
        int firstElement = maFifo.first();
        
        assertEquals(resultatAttendu, firstElement);
    }

    static Stream<Arguments> remove() throws Throwable{
        return Stream.of(Arguments.of(1, 0, 0), Arguments.of(-1, -2, -2), Arguments.of(1, 2, 2));
    }
    
    @ParameterizedTest()
    @MethodSource("size")
    void sizeFifo(int nombres[], int resultatAttendu) {
        FIFO maFifo = new FIFO();
        
        for(int nombre : nombres) {
            maFifo.add(nombre);
        }
        
        int firstElement = maFifo.size();
        
        assertEquals(resultatAttendu, firstElement);
    }
    
    static Stream<Arguments> size() throws Throwable{
        int[] tableau0 = new int[] {};
        int[] tableau1 = new int[] {0};
        int[] tableau2 = new int[] {1, 5};
        int[] tableau3 = new int[] {4, 5, 4};
        
        return Stream.of(Arguments.of(tableau0, 0), Arguments.of(tableau1, 1), Arguments.of(tableau2, 2), Arguments.of(tableau3, 3));
    }
}