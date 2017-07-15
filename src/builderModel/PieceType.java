/*
 * 
 */
package builderModel;

/**
 * @author Jetro
 *
 */
public enum PieceType {
	
	/** The puzzle. */
	PUZZLE("PUZZLE", "P"), /** The lightning. */
 LIGHTNING("LIGHTNING", "L"), /** The release. */
 RELEASE("RELEASE", "R"), /** The rset. */
 RSET("RSet", "RS");
	
	/** The printable name. */
	private final String printableName;
	
	/**
	 * Instantiates a new piece type.
	 *
	 * @param printableName
	 *            the printable name
	 * @param symbol
	 *            the symbol
	 */
	private PieceType(String printableName, String symbol){
		this.printableName = printableName;
	}

	/**
	 * @return
	 */
	public String getName(){return printableName;}
}