package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest 
{
    IIntArrayImp testImplement;
    IIntArrayImp emptyTestImplement;

    @BeforeEach
    public void initTest(){
        int[] testArr = {1, 2, 2, 4, 5, 5, 6, 1, 4, 10};
        testImplement = new IIntArrayImp(testArr);
        int[] emptyTestArr = {};
        emptyTestImplement = new IIntArrayImp(emptyTestArr);
    }

    @AfterEach
    public void closeTest(){
        testImplement = null;
        emptyTestImplement = null;
    }

    @Test
    public void testGetAverage()
    {
        assertEquals(4, testImplement.getAverage());
    }

    @Test
    public void testGetAverageOnEmptyArray()
    {
        assertEquals(emptyTestImplement.getAverage(), 0);
    }

    @Test
    public void testfindPositions()
    {
        int[] positionTestArr = new int[]{4,5};
        assertArrayEquals(positionTestArr, testImplement.findPositions(5));
    }

    @Test
    public void testfindPositionsOnNonExistingInteger()
    {
        int[] positionTestArr = new int[]{};
        assertArrayEquals(positionTestArr, testImplement.findPositions(888));
    }

    @Test
    public void testAppendLast(){
        int[] resultExpected = {1,2,2,4,5,5,6,1,4,10,5};
        testImplement.appendLast(5);
        assertArrayEquals(resultExpected, testImplement.getIntArr());
    }

    @Test
    public void testAppendLastOnEmptyArr(){
        int[] resultExpected = {2};
        emptyTestImplement.appendLast(2);
        assertArrayEquals(resultExpected, emptyTestImplement.getIntArr());
    }

    @Test
    public void testinsertAt(){
        int[] resultExpected = {1,2,2,4,6,5,5,6,1,4,10};
        testImplement.insertAt(4,6);
        assertArrayEquals(resultExpected, testImplement.getIntArr());
    }

    @Test
    public void testinsertAtEmptyPosition(){
        assertThrows(NullPointerException.class, () -> emptyTestImplement.insertAt(999,999));
    }

    @Test
    public void testGetAt(){
        assertEquals(5, testImplement.getAt(4));
        assertEquals(4, testImplement.getAt(8));
    }

    @Test
    public void testGetAtNonExistingIndex(){
        assertThrows(NullPointerException.class, () -> emptyTestImplement.getAt(99));
    }

    @Test
    public void testSetAt(){
        testImplement.setAt(6, 6);
        assertEquals(6, testImplement.getAt(6));
    }

    @Test
    public void testSetAtNonExistingIndex(){
        assertThrows(NullPointerException.class, () -> emptyTestImplement.setAt(99,99));
    }

    @Test
    public void testDeleteAt(){
        int[] testArr = {1, 2, 2, 4, 5, 6, 1, 4, 10};
        assertEquals(testImplement.deleteAt(5), 5);
        assertArrayEquals(testArr, testImplement.getIntArr());
    }

    @Test
    public void testDeleteAtNonExistingPosition(){
        assertThrows(NullPointerException.class, () -> emptyTestImplement.deleteAt(99));
    }
}
