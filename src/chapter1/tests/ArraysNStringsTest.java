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
}
