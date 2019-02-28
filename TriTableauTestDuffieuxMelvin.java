package test;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Assert;

import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class TriTableauTestDuffieuxMelvin {

    @BeforeEach
    void setUp() throws Exception {

    }
    
    @AfterEach
    void tearDown() throws Exception {
        
    }
    
    @ParameterizedTest()
    @MethodSource("croissant")
    void triCroissantTest(int tableau[], int resultatAttendu[]) {
        TriTableau.triCroissant(tableau);
        
        Assert.assertArrayEquals(resultatAttendu, tableau);
    }
    
    static Stream<Arguments> croissant() throws Throwable{
        int[] tableauTest1 = new int[] {3, 0, 1, 2, 4};
        int[] resultatTest1 = new int[] {0, 1, 2, 3, 4};
        
        int[] tableauTest2 = new int[] {0, 2, -1, -2, 1};
        int[] resultatTest2 = new int[] {-2, -1, 0, 1, 2};
        
        int[] tableauTest3 = new int[] {-3, -4, -1, -2, -5};
        int[] resultatTest3 = new int[] {-5, -4, -3, -2, -1};
        
        return Stream.of(Arguments.of(tableauTest1, resultatTest1), Arguments.of(tableauTest2, resultatTest2), Arguments.of(tableauTest3, resultatTest3));
    }
    
    @ParameterizedTest()
    @MethodSource("decroissant")
    void triDecroissantTest(int tableau[], int resultatAttendu[]) {
        TriTableau.triDecroissant(tableau);
        
        Assert.assertArrayEquals(resultatAttendu, tableau);
    }
    
    static Stream<Arguments> decroissant() throws Throwable{
        int[] tableauTest1 = new int[] {3, 0, 1, 2, 4};
        int[] resultatTest1 = new int[] {4, 3, 2, 1, 0};
        
        int[] tableauTest2 = new int[] {0, 2, -1, -2, 1};
        int[] resultatTest2 = new int[] {2, 1, 0, -1, -2};
        
        int[] tableauTest3 = new int[] {-3, -4, -1, -2, -5};
        int[] resultatTest3 = new int[] {-1, -2, -3, -4, -5};
        
        
        return Stream.of(Arguments.of(tableauTest1, resultatTest1), Arguments.of(tableauTest2, resultatTest2), Arguments.of(tableauTest3, resultatTest3));
    }
}
