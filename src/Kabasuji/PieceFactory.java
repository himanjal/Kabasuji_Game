/*
 * 
 */
package Kabasuji;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import model.Piece;

/**
 * @author Xavier
 *
 */
public class PieceFactory {
	
	/** The pieces. */
	Piece[] pieces;
	
	/** The place. */
	private Map<Integer, boolean[][]> place;
	
	/**
	 * 
	 */
	public PieceFactory(){
		setPlace(new HashMap<Integer, boolean[][]>(1000));
		
		boolean[][] zero = new boolean[6][6];
		
		boolean[][] one = new boolean[6][6];
		one[2][0] = true;
		one[2][1] = true;
		one[2][2] = true;
		one[2][3] = true;
		one[2][4] = true;
		one[2][5] = true;
		
		boolean[][] two = new boolean[6][6];
		two[3][1] = true;
		two[2][1] = true;
		two[2][2] = true;
		two[2][3] = true;
		two[2][4] = true;
		two[2][5] = true;
		
		boolean[][] three = new boolean[6][6];
		three[3][2] = true;
		three[2][1] = true;
		three[2][2] = true;
		three[2][3] = true;
		three[2][4] = true;
		three[2][5] = true;
		
		boolean[][] four = new boolean[6][6];
		four[3][3] = true;
		four[2][1] = true;
		four[2][2] = true;
		four[2][3] = true;
		four[2][4] = true;
		four[2][5] = true;
		
		boolean[][] five = new boolean[6][6];
		five[3][1] = true;
		five[3][2] = true;
		five[2][2] = true;
		five[2][3] = true;
		five[2][4] = true;
		five[2][5] = true;
		
		boolean[][] six = new boolean[6][6];
		six[3][2] = true;
		six[3][3] = true;
		six[2][2] = true;
		six[2][3] = true;
		six[2][4] = true;
		six[2][5] = true;
		
		boolean[][] seven = new boolean[6][6];
		seven[3][2] = true;
		seven[3][4] = true;
		seven[2][2] = true;
		seven[2][3] = true;
		seven[2][4] = true;
		seven[2][5] = true;
		
		boolean[][] eight = new boolean[6][6];
		eight[3][2] = true;
		eight[3][5] = true;
		eight[2][2] = true;
		eight[2][3] = true;
		eight[2][4] = true;
		eight[2][5] = true;
		
		boolean[][] nine = new boolean[6][6];
		nine[3][3] = true;
		nine[3][4] = true;
		nine[2][2] = true;
		nine[2][3] = true;
		nine[2][4] = true;
		nine[2][5] = true;
		
		boolean[][] ten = new boolean[6][6];
		ten[4][2] = true;
		ten[3][2] = true;
		ten[2][2] = true;
		ten[2][3] = true;
		ten[2][4] = true;
		ten[2][5] = true;
		
		boolean[][] eleven = new boolean[6][6];
		eleven[4][3] = true;
		eleven[3][3] = true;
		eleven[2][2] = true;
		eleven[2][3] = true;
		eleven[2][4] = true;
		eleven[2][5] = true;
		
		boolean[][] twelve = new boolean[6][6];
		twelve[1][2] = true;
		twelve[3][2] = true;
		twelve[2][2] = true;
		twelve[2][3] = true;
		twelve[2][4] = true;
		twelve[2][5] = true;
		
		boolean[][] thirteen = new boolean[6][6];
		thirteen[1][3] = true;
		thirteen[3][2] = true;
		thirteen[2][2] = true;
		thirteen[2][3] = true;
		thirteen[2][4] = true;
		thirteen[2][5] = true;
		

		boolean[][] fourteen = new boolean[6][6];
		fourteen[1][4] = true;
		fourteen[3][2] = true;
		fourteen[2][2] = true;
		fourteen[2][3] = true;
		fourteen[2][4] = true;
		fourteen[2][5] = true;
		
		boolean[][] fifteen = new boolean[6][6];
		fifteen[1][5] = true;
		fifteen[3][2] = true;
		fifteen[2][2] = true;
		fifteen[2][3] = true;
		fifteen[2][4] = true;
		fifteen[2][5] = true;
		
		boolean[][] sixteen = new boolean[6][6];
		sixteen[1][4] = true;
		sixteen[3][3] = true;
		sixteen[2][2] = true;
		sixteen[2][3] = true;
		sixteen[2][4] = true;
		sixteen[2][5] = true;
		
		boolean[][] seventeen = new boolean[6][6];
		seventeen[1][3] = true;
		seventeen[3][3] = true;
		seventeen[2][2] = true;
		seventeen[2][3] = true;
		seventeen[2][4] = true;
		seventeen[2][5] = true;
		
		boolean[][] eighteen = new boolean[6][6];
		eighteen[4][3] = true;
		eighteen[3][2] = true;
		eighteen[3][3] = true;
		eighteen[2][3] = true;
		eighteen[2][4] = true;
		eighteen[2][5] = true;
		
		boolean[][] nineteen = new boolean[6][6];
		nineteen[3][5] = true;
		nineteen[3][2] = true;
		nineteen[3][3] = true;
		nineteen[2][3] = true;
		nineteen[2][4] = true;
		nineteen[2][5] = true;
		
		
		boolean[][] twenty = new boolean[6][6];
		twenty[3][1] = true;
		twenty[3][2] = true;
		twenty[3][3] = true;
		twenty[2][3] = true;
		twenty[2][4] = true;
		twenty[2][5] = true;
		
		
		
		boolean[][] twentyOne = new boolean[6][6];
		twentyOne[3][3] = true;
		twentyOne[3][2] = true;
		twentyOne[3][4] = true;
		twentyOne[2][3] = true;
		twentyOne[2][4] = true;
		twentyOne[2][5] = true;
		
		boolean[][] twentyTwo = new boolean[6][6];
		twentyTwo[3][3] = true;
		twentyTwo[3][4] = true;
		twentyTwo[3][5] = true;
		twentyTwo[2][3] = true;
		twentyTwo[2][4] = true;
		twentyTwo[2][5] = true;
		
		boolean[][] twentyThree = new boolean[6][6];
		twentyThree[1][3] = true;
		twentyThree[3][2] = true;
		twentyThree[3][3] = true;
		twentyThree[2][3] = true;
		twentyThree[2][4] = true;
		twentyThree[2][5] = true;
		
		
		boolean[][] twentyFour = new boolean[6][6];
		twentyFour[1][3] = true;
		twentyFour[3][4] = true;
		twentyFour[3][3] = true;
		twentyFour[2][3] = true;
		twentyFour[2][4] = true;
		twentyFour[2][5] = true;
		
		boolean[][] twentyFive = new boolean[6][6];
		twentyFive[1][4] = true;
		twentyFive[3][2] = true;
		twentyFive[3][3] = true;
		twentyFive[2][3] = true;
		twentyFive[2][4] = true;
		twentyFive[2][5] = true;
		
		boolean[][] twentySix = new boolean[6][6];
		twentySix[4][3] = true;
		twentySix[4][2] = true;
		twentySix[3][3] = true;
		twentySix[2][3] = true;
		twentySix[2][4] = true;
		twentySix[2][5] = true;
		
		boolean[][] twentySeven = new boolean[6][6];
		twentySeven[4][2] = true;
		twentySeven[3][2] = true;
		twentySeven[3][3] = true;
		twentySeven[2][3] = true;
		twentySeven[2][4] = true;
		twentySeven[2][5] = true;
		
		boolean[][] twentyEight = new boolean[6][6];
		twentyEight[4][3] = true;
		twentyEight[4][4] = true;
		twentyEight[3][3] = true;
		twentyEight[2][3] = true;
		twentyEight[2][4] = true;
		twentyEight[2][5] = true;
		
		boolean[][] twentyNine = new boolean[6][6];
		twentyNine[4][3] = true;
		twentyNine[3][4] = true;
		twentyNine[4][4] = true;
		twentyNine[2][3] = true;
		twentyNine[2][4] = true;
		twentyNine[2][5] = true;
		
		boolean[][] thirty = new boolean[6][6];
		thirty[3][4] = true;
		thirty[1][3] = true;
		thirty[3][3] = true;
		thirty[1][4] = true;
		thirty[2][4] = true;
		thirty[2][5] = true;
		
		boolean[][] thirtyOne = new boolean[6][6];
		thirtyOne[4][2] = true;
		thirtyOne[3][2] = true;
		thirtyOne[3][3] = true;
		thirtyOne[3][4] = true;
		thirtyOne[2][4] = true;
		thirtyOne[2][5] = true;
		
		boolean[][] thirtyTwo = new boolean[6][6];
		thirtyTwo[4][5] = true;
		thirtyTwo[3][5] = true;
		thirtyTwo[3][4] = true;
		thirtyTwo[2][3] = true;
		thirtyTwo[2][4] = true;
		thirtyTwo[2][5] = true;
		
		
		boolean[][] thirtyThree = new boolean[6][6];
		thirtyThree[4][4] = true;
		thirtyThree[3][5] = true;
		thirtyThree[3][3] = true;
		thirtyThree[3][4] = true;
		thirtyThree[2][4] = true;
		thirtyThree[2][5] = true;
		
		boolean[][] thirtyFour = new boolean[6][6];
		thirtyFour[4][4] = true;
		thirtyFour[3][5] = true;
		thirtyFour[4][3] = true;
		thirtyFour[3][4] = true;
		thirtyFour[2][4] = true;
		thirtyFour[2][5] = true;
		
		
		boolean[][] thirtyFive = new boolean[6][6];
		thirtyFive[4][2] = true;
		thirtyFive[4][3] = true;
		thirtyFive[3][3] = true;
		thirtyFive[3][4] = true;
		thirtyFive[2][4] = true;
		thirtyFive[2][5] = true;
		
		//getPlace().put(0,zero);
		getPlace().put(1, one);
		getPlace().put(2, two);
		getPlace().put(3, three);
		getPlace().put(4, four);
		getPlace().put(5, five);
		getPlace().put(6, six);
		getPlace().put(7, seven);
		getPlace().put(8, eight);
		getPlace().put(9, nine);
		getPlace().put(10, ten);
		getPlace().put(11, eleven);
		getPlace().put(12, twelve);
		getPlace().put(13, thirteen);
		getPlace().put(14, fourteen);
		getPlace().put(15, fifteen);
		getPlace().put(16, sixteen);
		getPlace().put(17, seventeen);
		getPlace().put(18, eighteen);
		getPlace().put(19, nineteen);
		getPlace().put(20, twenty);
		getPlace().put(21, twentyOne);
		getPlace().put(22, twentyTwo);
		getPlace().put(23, twentyThree);
		getPlace().put(24, twentyFour);
		getPlace().put(25, twentyFive);
		getPlace().put(26, twentySix);
		getPlace().put(27, twentySeven);
		getPlace().put(28, twentyEight);
		getPlace().put(29, twentyNine);
		getPlace().put(30, thirty);
		getPlace().put(31, thirtyOne);
		getPlace().put(32, thirtyTwo);
		getPlace().put(33, thirtyThree);
		getPlace().put(34, thirtyFour);
		getPlace().put(35, thirtyFive);
		getPlace().put(100, zero);
	}
	
	
	/**
	 * @param i
	 * @return
	 */
	public Piece makePiece(int i){
		
//		Random random = new Random();
//		final float hue = random.nextFloat();
//		// Saturation between 0.1 and 0.3
//		final float saturation = (random.nextInt(4000) + 1000) / 10000f;
//		final float luminance = 0.7f;
//		final Color color = Color.getHSBColor(hue, saturation, luminance);
		Color color = new Color(((int)(Math.random() * 200) + 30), ((int)(Math.random() * 200) + 30), ((int)(Math.random() * 200) + 30));
		if (i == 0 ) i = 1;
		return new Piece(color, getPlace().get(i), i);
	}


	/**
	 * Gets the place.
	 *
	 * @return the place
	 */
	public Map<Integer, boolean[][]> getPlace() {
		return place;
	}


	/**
	 * Sets the place.
	 *
	 * @param place
	 *            the place
	 */
	public void setPlace(Map<Integer, boolean[][]> place) {
		this.place = place;
	}

}
