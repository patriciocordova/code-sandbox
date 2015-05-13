package code.tests;

import org.junit.Test;

import code.Chapter1;
import static org.junit.Assert.*;

public class Chapter1Test {
	@Test
	public void testHasUniqueChars() {
		assertEquals(Chapter1.hasUniqueChars("hola"),true);
		assertEquals(Chapter1.hasUniqueChars("holaa"),false);
		assertEquals(Chapter1.hasUniqueChars("aholaa"),false);
		assertEquals(Chapter1.hasUniqueChars(""),true);
		assertEquals(Chapter1.hasUniqueChars(null),true);
	}
	
	@Test
	public void testHasUniqueChars2() {
		assertEquals(Chapter1.hasUniqueChars2("hola"),true);
		assertEquals(Chapter1.hasUniqueChars2("holaa"),false);
		assertEquals(Chapter1.hasUniqueChars2("aholaa"),false);
		assertEquals(Chapter1.hasUniqueChars2(""),true);
		assertEquals(Chapter1.hasUniqueChars2(null),true);
	}
	
	@Test
	public void testIsPermutation() {
		assertEquals(Chapter1.isPermutation("aa", "aa"),true);
		assertEquals(Chapter1.isPermutation("aa", "ab"),false);
		assertEquals(Chapter1.isPermutation("ba", "ab"),true);
		assertEquals(Chapter1.isPermutation("abc", "bca"),true);
		assertEquals(Chapter1.isPermutation("abc", "bcaa"),false);
		assertEquals(Chapter1.isPermutation("abc", "aba"),false);
		assertEquals(Chapter1.isPermutation("abbbbbbc", "abcbbbbb"),true);
		assertEquals(Chapter1.isPermutation("abc", "a"),false);
		assertEquals(Chapter1.isPermutation(null, "a"),false);
		assertEquals(Chapter1.isPermutation("a",null),false);
		assertEquals(Chapter1.isPermutation(null, null),true);
	}
	
	@Test
	public void testCompress() {
		assertEquals(Chapter1.compress(null),null);
		assertEquals(Chapter1.compress(""),"");
		assertEquals(Chapter1.compress("aabcccccaaa"),"a2b1c5a3");
		assertEquals(Chapter1.compress("aab     aaa"),"a2b1 5a3");
		assertEquals(Chapter1.compress("a"),"a");
		assertEquals(Chapter1.compress("ab"),"ab");
		assertEquals(Chapter1.compress("abcccccccccc"),"a1b1c10");
	}
	
	@Test
	public void testRotate() {
		assertArrayEquals(Chapter1.rotate(
				new int[][]{{1}}),
				new int[][]{{1}});
		assertArrayEquals(Chapter1.rotate(
				new int[][]{{1,2},{4,3}}),
				new int[][]{{4,1},{3,2}});
		assertArrayEquals(Chapter1.rotate(
				new int[][]{{1,2,3},{8,9,4},{7,6,5}}),
				new int[][]{{7, 8, 1}, {6, 9, 2}, {5, 4, 3}});
		assertArrayEquals(Chapter1.rotate(
				new int[][]{{1,2,3,4},{12,13,14,5},{11,16,15,6},{10,9,8,7}}),
				new int[][]{{10, 11, 12, 1}, {9, 16, 13, 2}, {8, 15, 14, 3}, {7, 6, 5, 4}});
		assertArrayEquals(Chapter1.rotate(
				new int[][]{{1,2,3,4,5},{16,17,18,19,6},{15,24,25,20,7},{14,23,22,21,8},{13,12,11,10,9}}),
				new int[][]{{13, 14, 15, 16, 1}, {12, 23, 24, 17, 2}, {11, 22, 25, 18, 3}, {10, 21, 20, 19, 4}, {9, 8, 7, 6, 5}});
	}
	
	@Test
	public void testZeroeMatrix() {
		assertArrayEquals(Chapter1.zeroeMatrix(
				new int[][]{{1}}),
				new int[][]{{1}});
		assertArrayEquals(Chapter1.zeroeMatrix(
				new int[][]{{0}}),
				new int[][]{{0}});
		assertArrayEquals(Chapter1.zeroeMatrix(
				new int[][]{{0,2},{3,4}}),
				new int[][]{{0,0},{0,4}});
		assertArrayEquals(Chapter1.zeroeMatrix(
				new int[][]{{0,2},{3,4}}),
				new int[][]{{0,0},{0,4}});
		assertArrayEquals(Chapter1.zeroeMatrix(
				new int[][]{{0,2,3},{4,5,6},{7,8,0}}),
				new int[][]{{0,0,0},{0,5,0},{0,0,0}});
	}
	
	@Test
	public void testIsRotated() {
		assertFalse(Chapter1.isRotated("a", null));
		assertFalse(Chapter1.isRotated(null,"a"));
		assertFalse(Chapter1.isRotated("a", "ab"));
		assertTrue(Chapter1.isRotated("a", "a"));
		assertTrue(Chapter1.isRotated("aa", "aa"));
		assertTrue(Chapter1.isRotated("ab", "ba"));
		assertTrue(Chapter1.isRotated("hola", "olah"));
		assertTrue(Chapter1.isRotated("hola", "laho"));
		assertTrue(Chapter1.isRotated("hola", "ahol"));
		assertTrue(Chapter1.isRotated("lalo", "lola"));
		assertFalse(Chapter1.isRotated("hola", "holo"));
		assertFalse(Chapter1.isRotated("lllo", "llla"));
	}
}
