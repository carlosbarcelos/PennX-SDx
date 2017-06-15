package Assignments;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SquarelotronTest {
	Squarelotron s2;
	Squarelotron s3;

	@Before
	public void setUp() throws Exception {
		s2 = new Squarelotron(4);
		s3 = new Squarelotron(5);
	}
	
	@Test
	public void testBuildSquarelotron() {
		Squarelotron mockS2 = new Squarelotron(4); //test an even number of rings
		int[] mockS2Row1 = {1,2,3,4};
		int[] mockS2Row2 = {5,6,7,8};
		int[] mockS2Row3 = {9,10,11,12};
		int[] mockS2Row4 = {13,14,15,16};
		mockS2.squarelotron[0] = mockS2Row1;
		mockS2.squarelotron[1] = mockS2Row2;
		mockS2.squarelotron[2] = mockS2Row3;
		mockS2.squarelotron[3] = mockS2Row4;
		assertTrue(mockS2.equals(s2));
		
		Squarelotron mockS3 = new Squarelotron(5); //test an odd number of rings
		int[] mockS3Row1 = {1,2,3,4,5};
		int[] mockS3Row2 = {6,7,8,9,10};
		int[] mockS3Row3 = {11,12,13,14,15};
		int[] mockS3Row4 = {16,17,18,19,20};
		int[] mockS3Row5 = {21,22,23,24,25};
		mockS3.squarelotron[0] = mockS3Row1;
		mockS3.squarelotron[1] = mockS3Row2;
		mockS3.squarelotron[2] = mockS3Row3;
		mockS3.squarelotron[3] = mockS3Row4;
		mockS3.squarelotron[4] = mockS3Row5;
		assertTrue(mockS3.equals(s3));
	}
	
	@Test
	public void testUpsideDownFlip() {
		Squarelotron mockS2 = new Squarelotron(4); //test an even number of rings
		int[] mockS2Row1 = {13,14,15,16};
		int[] mockS2Row2 = { 9, 6, 7,12};
		int[] mockS2Row3 = { 5,10,11, 8};
		int[] mockS2Row4 = { 1, 2, 3, 4};
		mockS2.squarelotron[0] = mockS2Row1;
		mockS2.squarelotron[1] = mockS2Row2;
		mockS2.squarelotron[2] = mockS2Row3;
		mockS2.squarelotron[3] = mockS2Row4;
		assertTrue(mockS2.equals(s2.upsideDownFlip(1)));
		
		Squarelotron mockS3 = new Squarelotron(5); //test an odd number of rings
		int[] mockS3Row1 = { 1, 2, 3, 4, 5};
		int[] mockS3Row2 = { 6,17,18,19,10};
		int[] mockS3Row3 = {11,12,13,14,15};
		int[] mockS3Row4 = {16, 7, 8, 9,20};
		int[] mockS3Row5 = {21,22,23,24,25};
		mockS3.squarelotron[0] = mockS3Row1;
		mockS3.squarelotron[1] = mockS3Row2;
		mockS3.squarelotron[2] = mockS3Row3;
		mockS3.squarelotron[3] = mockS3Row4;
		mockS3.squarelotron[4] = mockS3Row5;
		assertTrue(mockS3.equals(s3.upsideDownFlip(2)));
	}

	@Test
	public void testMainDiagonalFlip() {
		Squarelotron mockS2 = new Squarelotron(4); //test an even number of rings
		int[] mockS2Row1 = { 1, 5, 9,13};
		int[] mockS2Row2 = { 2, 6, 7,14};
		int[] mockS2Row3 = { 3,10,11,15};
		int[] mockS2Row4 = { 4, 8,12,16};
		mockS2.squarelotron[0] = mockS2Row1;
		mockS2.squarelotron[1] = mockS2Row2;
		mockS2.squarelotron[2] = mockS2Row3;
		mockS2.squarelotron[3] = mockS2Row4;
		assertTrue(mockS2.equals(s2.mainDiagonalFlip(1)));
		
		Squarelotron mockS3 = new Squarelotron(5); //test an odd number of rings
		int[] mockS3Row1 = { 1, 2, 3, 4, 5};
		int[] mockS3Row2 = { 6, 7,12,17,10};
		int[] mockS3Row3 = {11, 8,13,18,15};
		int[] mockS3Row4 = {16, 9,14,19,20};
		int[] mockS3Row5 = {21,22,23,24,25};
		mockS3.squarelotron[0] = mockS3Row1;
		mockS3.squarelotron[1] = mockS3Row2;
		mockS3.squarelotron[2] = mockS3Row3;
		mockS3.squarelotron[3] = mockS3Row4;
		mockS3.squarelotron[4] = mockS3Row5;
		assertTrue(mockS3.equals(s3.mainDiagonalFlip(2)));
	}

	@Test
	public void testRotateRight() {
		Squarelotron mockS2 = new Squarelotron(4); //test an even number of rings
		int[] mockS2Row1 = {1,2,3,4};
		int[] mockS2Row2 = {5,6,7,8};
		int[] mockS2Row3 = {9,10,11,12};
		int[] mockS2Row4 = {13,14,15,16};
		mockS2.squarelotron[0] = mockS2Row1;
		mockS2.squarelotron[1] = mockS2Row2;
		mockS2.squarelotron[2] = mockS2Row3;
		mockS2.squarelotron[3] = mockS2Row4;
		
		Squarelotron rightS2 = new Squarelotron(4); //test an even number of rings
		int[] rightS2Row1 = {13,9,5,1};
		int[] rightS2Row2 = {14,10,6,2};
		int[] rightS2Row3 = {15,11,7,3};
		int[] rightS2Row4 = {16,12,8,4};
		rightS2.squarelotron[0] = rightS2Row1;
		rightS2.squarelotron[1] = rightS2Row2;
		rightS2.squarelotron[2] = rightS2Row3;
		rightS2.squarelotron[3] = rightS2Row4;
		
		Squarelotron mockS3 = new Squarelotron(5); //test an odd number of rings
		int[] mockS3Row1 = {1,2,3,4,5};
		int[] mockS3Row2 = {6,7,8,9,10};
		int[] mockS3Row3 = {11,12,13,14,15};
		int[] mockS3Row4 = {16,17,18,19,20};
		int[] mockS3Row5 = {21,22,23,24,25};
		mockS3.squarelotron[0] = mockS3Row1;
		mockS3.squarelotron[1] = mockS3Row2;
		mockS3.squarelotron[2] = mockS3Row3;
		mockS3.squarelotron[3] = mockS3Row4;
		mockS3.squarelotron[4] = mockS3Row5;
		//no rotation
		s2.rotateRight(0);
		assertTrue(mockS2.equals(s2));
		s2.rotateRight(4);
		assertTrue(mockS2.equals(s2));
		
		s3.rotateRight(0);
		assertTrue(mockS3.equals(s3));
		s3.rotateRight(4);
		assertTrue(mockS3.equals(s3));

		//rotation
		s2.rotateRight(1);
		assertTrue(rightS2.equals(s2));
		s2.rotateRight(-1);
		assertTrue(mockS2.equals(s2));
		
		s3.rotateRight(1);
		s3.rotateRight(-1);
		assertTrue(mockS3.equals(s3));
	}

}
