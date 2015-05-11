package chapter1.tests;

import org.junit.Test;

import chapter1.*;
import static org.junit.Assert.*;

public class ArraysNStringsTest {
	@Test
	public void testHasUniqueChars() {
		assertEquals(ArraysNStrings.hasUniqueChars("hola"),true);
		assertEquals(ArraysNStrings.hasUniqueChars("holaa"),false);
		assertEquals(ArraysNStrings.hasUniqueChars("aholaa"),false);
		assertEquals(ArraysNStrings.hasUniqueChars(""),true);
		assertEquals(ArraysNStrings.hasUniqueChars(null),true);
	}
	
	@Test
	public void testHasUniqueChars2() {
		assertEquals(ArraysNStrings.hasUniqueChars2("hola"),true);
		assertEquals(ArraysNStrings.hasUniqueChars2("holaa"),false);
		assertEquals(ArraysNStrings.hasUniqueChars2("aholaa"),false);
		assertEquals(ArraysNStrings.hasUniqueChars2(""),true);
		assertEquals(ArraysNStrings.hasUniqueChars2(null),true);
	}
	
	@Test
	public void testIsPermutation() {
		assertEquals(ArraysNStrings.isPermutation("aa", "aa"),true);
		assertEquals(ArraysNStrings.isPermutation("aa", "ab"),false);
		assertEquals(ArraysNStrings.isPermutation("ba", "ab"),true);
		assertEquals(ArraysNStrings.isPermutation("abc", "bca"),true);
		assertEquals(ArraysNStrings.isPermutation("abc", "bcaa"),false);
		assertEquals(ArraysNStrings.isPermutation("abc", "aba"),false);
		assertEquals(ArraysNStrings.isPermutation("abbbbbbc", "abcbbbbb"),true);
		assertEquals(ArraysNStrings.isPermutation("abc", "a"),false);
		assertEquals(ArraysNStrings.isPermutation(null, "a"),false);
		assertEquals(ArraysNStrings.isPermutation("a",null),false);
		assertEquals(ArraysNStrings.isPermutation(null, null),true);
	}
	
	@Test
	public void testCompress() {
		assertEquals(ArraysNStrings.compress(null),null);
		assertEquals(ArraysNStrings.compress(""),"");
		assertEquals(ArraysNStrings.compress("aabcccccaaa"),"a2b1c5a3");
		assertEquals(ArraysNStrings.compress("aab     aaa"),"a2b1 5a3");
		assertEquals(ArraysNStrings.compress("a"),"a");
		assertEquals(ArraysNStrings.compress("ab"),"ab");
		assertEquals(ArraysNStrings.compress("abcccccccccc"),"a1b1c10");
	}
	
	@Test
	public void testRotate() {
		assertArrayEquals(ArraysNStrings.rotate(
				new int[][]{{1}}),
				new int[][]{{1}});
		assertArrayEquals(ArraysNStrings.rotate(
				new int[][]{{1,2},{4,3}}),
				new int[][]{{4,1},{3,2}});
		assertArrayEquals(ArraysNStrings.rotate(
				new int[][]{{1,2,3},{8,9,4},{7,6,5}}),
				new int[][]{{7, 8, 1}, {6, 9, 2}, {5, 4, 3}});
		assertArrayEquals(ArraysNStrings.rotate(
				new int[][]{{1,2,3,4},{12,13,14,5},{11,16,15,6},{10,9,8,7}}),
				new int[][]{{10, 11, 12, 1}, {9, 16, 13, 2}, {8, 15, 14, 3}, {7, 6, 5, 4}});
		assertArrayEquals(ArraysNStrings.rotate(
				new int[][]{{1,2,3,4,5},{16,17,18,19,6},{15,24,25,20,7},{14,23,22,21,8},{13,12,11,10,9}}),
				new int[][]{{13, 14, 15, 16, 1}, {12, 23, 24, 17, 2}, {11, 22, 25, 18, 3}, {10, 21, 20, 19, 4}, {9, 8, 7, 6, 5}});
	}
	
	@Test
	public void testZeroeMatrix() {
		assertArrayEquals(ArraysNStrings.rotate(
				new int[][]{{1}}),
				new int[][]{{1}});
		assertArrayEquals(ArraysNStrings.rotate(
				new int[][]{{0}}),
				new int[][]{{0}});
		assertArrayEquals(ArraysNStrings.rotate(
				new int[][]{{0,1}}),
				new int[][]{{0,0}});
		assertArrayEquals(ArraysNStrings.rotate(
				new int[][]{{0,2},{3,4}}),
				new int[][]{{0,0},{0,4}});
		assertArrayEquals(ArraysNStrings.rotate(
				new int[][]{{0,2},{3,4}}),
				new int[][]{{0,0},{0,4}});
		assertArrayEquals(ArraysNStrings.rotate(
				new int[][]{{0,2,3},{4,5,6},{7,8,0}}),
				new int[][]{{0,0,0},{0,5,0},{0,0,0}});
	}
	
	@Test
	public void testIsRotated() {
		assertFalse(ArraysNStrings.isRotated("a", null));
		assertFalse(ArraysNStrings.isRotated(null,"a"));
		assertFalse(ArraysNStrings.isRotated("a", "ab"));
		assertTrue(ArraysNStrings.isRotated("a", "a"));
		assertTrue(ArraysNStrings.isRotated("aa", "aa"));
		assertTrue(ArraysNStrings.isRotated("ab", "ba"));
		assertTrue(ArraysNStrings.isRotated("hola", "olah"));
		assertTrue(ArraysNStrings.isRotated("hola", "laho"));
		assertTrue(ArraysNStrings.isRotated("hola", "ahol"));
		assertTrue(ArraysNStrings.isRotated("lalo", "lola"));
		assertFalse(ArraysNStrings.isRotated("hola", "holo"));
		assertFalse(ArraysNStrings.isRotated("lllo", "llla"));
	}
}
