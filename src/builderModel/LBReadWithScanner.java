/*
 * 
 */
package builderModel;

import java.awt.Color;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import builderModel.PieceFactory;
import builderModel.PieceType;
import builderModel.Board;
import builderModel.BuilderRSet;
import builderModel.Square;

/** Assumes UTF-8 encoding. JDK 7+. */
public class LBReadWithScanner {
  
  /**
   Constructor.
   @param aFileName full name of an existing, readable file.
  */
  public LBReadWithScanner(String aFileName,LBModel kab){
    fFilePath = Paths.get(aFileName);
    this.kab = kab;
  }
  
  
  /** Template method that calls {@link #processLine(String)}.  */
  public LBModel processLineByLine() throws IOException {
    try (Scanner scanner =  new Scanner(fFilePath, ENCODING.name())){
      while (scanner.hasNextLine()){
        processLine(scanner.nextLine());
      }      
    }
    return this.kab;
  }

  /**
	 * Check lightning levels.
	 *
	 * @param levelNum
	 *            the level num
	 * @param lvlName
	 *            the lvl name
	 * @param txtName
	 *            the txt name
	 * @param txtValue
	 *            the txt value
	 */
  private void checkLightningLevels (int levelNum, String lvlName, String txtName, String txtValue){
	  if (txtName.trim().equals(lvlName)){
		  String[] ar=txtValue.trim().split(",");
		  Integer x = Integer.parseInt(ar[1]);
		  Level lLevel = new Level(levelNum, PieceType.LIGHTNING, new Bullpen(), x);
		  if (ar[0].trim().equals("")){
			  if(kab.llevels.get(kab.llevels.size() - 1).getStars() > 0)
				  lLevel.setUnlocked(true);
			  else
				  lLevel.setUnlocked(false);
			  lLevel.setStars(0);
		  }else if ((ar[0].trim().equals("0"))||(ar[0].trim().equals("1"))||(ar[0].trim().equals("2"))||(ar[0].trim().equals("3"))){
			  lLevel.setStars(Integer.parseInt(ar[0].trim()));
			  lLevel.setUnlocked(true);
		  }
		  this.kab.llevels.add(lLevel);
	  }
  }
  
  /**
	 * Check puzzle levels.
	 *
	 * @param levelNum
	 *            the level num
	 * @param lvlName
	 *            the lvl name
	 * @param txtName
	 *            the txt name
	 * @param txtValue
	 *            the txt value
	 */
  private void checkPuzzleLevels (int levelNum, String lvlName, String txtName, String txtValue){
	  if (txtName.trim().equals(lvlName)){
		  String[] ar=txtValue.trim().split(",");
		  Integer x = Integer.parseInt(ar[1]);
		  Level pLevel = new Level(levelNum, PieceType.PUZZLE, new Bullpen(), x);
		  if (ar[0].trim().equals("")){
			  if(kab.plevels.get(kab.plevels.size() - 1).getStars() > 0)
				  pLevel.setUnlocked(true);
			  else
				  pLevel.setUnlocked(false);
			  pLevel.setStars(0);
		  }else if ((ar[0].trim().equals("0"))||(ar[0].trim().equals("1"))||(ar[0].trim().equals("2"))||(ar[0].trim().equals("3"))){
			  pLevel.setStars(Integer.parseInt(ar[0].trim()));
			  pLevel.setUnlocked(true);
		  }
		  this.kab.plevels.add(pLevel);
	  }
  }
  
  /**
	 * Check release levels.
	 *
	 * @param levelNum
	 *            the level num
	 * @param lvlName
	 *            the lvl name
	 * @param txtName
	 *            the txt name
	 * @param txtValue
	 *            the txt value
	 */
  private void checkReleaseLevels (int levelNum, String lvlName, String txtName, String txtValue){
	  if (txtName.trim().equals(lvlName)){
		  String[] ar=txtValue.trim().split(",");
		  Level rLevel = new Level(levelNum, PieceType.RELEASE, new Bullpen());
		  if (ar[0].trim().equals("")){
			  if(kab.rlevels.get(kab.rlevels.size() - 1).getStars() > 0)
				  rLevel.setUnlocked(true);
			  else
				  rLevel.setUnlocked(false);
			  rLevel.setStars(0);
		  }else if ((ar[0].trim().equals("0"))||(ar[0].trim().equals("1"))||(ar[0].trim().equals("2"))||(ar[0].trim().equals("3"))){
			  rLevel.setStars(Integer.parseInt(ar[0].trim()));
			  rLevel.setUnlocked(true);
		  }
		  this.kab.rlevels.add(rLevel);
	  }
  }
  
  /**
	 * Check lightning pieces.
	 *
	 * @param levelNum
	 *            the level num
	 * @param lvlName
	 *            the lvl name
	 * @param pF
	 *            the p f
	 * @param txtName
	 *            the txt name
	 * @param txtValue
	 *            the txt value
	 */
  private void checkLightningPieces (int levelNum, String lvlName,PieceFactory pF, String txtName, String txtValue){
	  if (txtName.trim().equals(lvlName)){
		  String[] ar=txtValue.trim().split(",");
		  Bullpen bpen = new Bullpen();
		  this.kab.llevels.get(levelNum-1).setBullpen(bpen);
		  for (int i = 0; i < ar.length; i++) {
			  Integer x = Integer.parseInt(ar[i]);
			  Piece piece =  pF.makePiece(x); //XAVIER
			  this.kab.llevels.get(levelNum-1).getBullpen().getPieces().add(piece);//setPiece will depend on the factory pieces
		  }
	  }
  }
  
  /**
	 * Check puzzle pieces.
	 *
	 * @param levelNum
	 *            the level num
	 * @param lvlName
	 *            the lvl name
	 * @param pF
	 *            the p f
	 * @param txtName
	 *            the txt name
	 * @param txtValue
	 *            the txt value
	 */
  private void checkPuzzlePieces (int levelNum, String lvlName, PieceFactory pF, String txtName, String txtValue){
	  if (txtName.trim().equals(lvlName)){
		  String[] ar=txtValue.trim().split(",");
		  Bullpen bpen = new Bullpen();
		  this.kab.plevels.get(levelNum-1).setBullpen(bpen);
		  for (int i = 0; i < ar.length; i++) {
			  Integer x = Integer.parseInt(ar[i]);
			  Piece piece =  pF.makePiece(x);
			  this.kab.plevels.get(levelNum-1).getBullpen().getPieces().add(piece);//setPiece will depend on the factory pieces
		  }
	  }
  }
  
  /**
	 * Check release pieces.
	 *
	 * @param levelNum
	 *            the level num
	 * @param lvlName
	 *            the lvl name
	 * @param pF
	 *            the p f
	 * @param txtName
	 *            the txt name
	 * @param txtValue
	 *            the txt value
	 */
  private void checkReleasePieces (int levelNum, String lvlName, PieceFactory pF, String txtName, String txtValue){
	  if (txtName.trim().equals(lvlName)){
		  String[] ar=txtValue.trim().split(",");
		  Bullpen bpen = new Bullpen();
		  this.kab.rlevels.get(levelNum-1).setBullpen(bpen);
		  for (int i = 0; i < ar.length; i++) {
			  Integer x = Integer.parseInt(ar[i]);
			  Piece piece =  pF.makePiece(x);
			  this.kab.rlevels.get(levelNum-1).getBullpen().getPieces().add(piece);//setPiece will depend on the factory pieces
		  }
	  }
  }
  
  /**
	 * Check lightning board.
	 *
	 * @param levelNum
	 *            the level num
	 * @param lvlName
	 *            the lvl name
	 * @param txtName
	 *            the txt name
	 * @param txtValue
	 *            the txt value
	 */
  private void checkLightningBoard(int levelNum, String lvlName, String txtName, String txtValue){
	  if (txtName.trim().equals(lvlName)){
		  String[] ar=txtValue.trim().split(",");
		  Square[][] squares = new Square[12][12];
		  for (int i = 0; i < 12; i++) {
			  for(int j = 0; j < 12; j++){
				  Integer x = Integer.parseInt(ar[(i * 12) + j]);
				  if(x == 1){
					  squares[j][i] = new Square(j,i,PieceType.LIGHTNING,true,false);
				  }
				  else if(x == 2){
					  squares[j][i] = new Square(j,i,PieceType.LIGHTNING,true,false);
					  squares[j][i].setHint(true);
				  }else if(x == 0){
					  squares[j][i] = new Square(j,i,PieceType.LIGHTNING,false,false);
				  }
			  }
		  }
		  
		  Board board = new Board(squares, this.kab.llevels.get(levelNum-1).getBullpen(), PieceType.LIGHTNING);
		  this.kab.llevels.get(levelNum-1).setBoard(board);
	  }
  }
  
  /**
	 * Check puzzle board.
	 *
	 * @param levelNum
	 *            the level num
	 * @param lvlName
	 *            the lvl name
	 * @param txtName
	 *            the txt name
	 * @param txtValue
	 *            the txt value
	 */
  private void checkPuzzleBoard(int levelNum, String lvlName, String txtName, String txtValue){
	  if (txtName.trim().equals(lvlName)){
		  String[] ar=txtValue.trim().split(",");
		  Square[][] squares = new Square[12][12];
		  for (int i = 0; i < 12; i++) {
			  for(int j = 0; j < 12; j++){
				  Integer x = Integer.parseInt(ar[(i * 12) + j]);
				  if(x == 1){
					  squares[j][i] = new Square(j,i,PieceType.PUZZLE,true,false);
				  }
				  else if(x == 2){
					  squares[j][i] = new Square(j,i,PieceType.PUZZLE,true,false);
					  squares[j][i].setHint(true);
				  }else if(x == 0){
					  squares[j][i] = new Square(j,i,PieceType.PUZZLE,false,false);
				  }
			  }
		  }
		  
		  Board board = new Board(squares, this.kab.plevels.get(levelNum-1).getBullpen(),PieceType.PUZZLE);
		  this.kab.plevels.get(levelNum-1).setBoard(board);
	  }
  }
  
  /**
	 * Check release board.
	 *
	 * @param levelNum
	 *            the level num
	 * @param lvlName
	 *            the lvl name
	 * @param txtName
	 *            the txt name
	 * @param txtValue
	 *            the txt value
	 */
  private void checkReleaseBoard(int levelNum, String lvlName, String txtName, String txtValue){
	  if (txtName.trim().equals(lvlName)){
		  String[] ar=txtValue.trim().split(",");
		  Square[][] squares = new Square[12][12];
		  for (int i = 0; i < 12; i++) {
			  for(int j = 0; j < 12; j++){
				  Integer x = Integer.parseInt(ar[(i * 12) + j]);
				  if(x == 1){
					  squares[j][i] = new Square(j,i,PieceType.RELEASE,true,false);
				  }
				  else if(x == 2){
					  squares[j][i] = new Square(j,i,PieceType.RELEASE,true,false);
					  squares[j][i].setHint(true);
				  }else if(x == 0){
					  squares[j][i] = new Square(j,i,PieceType.RELEASE,false,false);
				  }
				  else if(x - 10 < 10){
					  squares[j][i] = new Square(j,i,PieceType.RELEASE,true,false);
					  squares[j][i].rs = new BuilderRSet(Color.RED, x - 10, true, false);
				  }
				  else if(x - 20 < 10){
					  squares[j][i] = new Square(j,i,PieceType.RELEASE,true,false);
					  squares[j][i].rs = new BuilderRSet(Color.BLUE, x - 20, true, false);
				  }
				  else if(x - 30 < 10){
					  squares[j][i] = new Square(j,i,PieceType.RELEASE,true,false);
					  squares[j][i].rs = new BuilderRSet(Color.GREEN, x - 30, true, false);
				  }
			  }
		  }
		  
		  Board board = new Board(squares, this.kab.rlevels.get(levelNum-1).getBullpen() ,this.kab.rlevels.get(levelNum-1).getType());
		  this.kab.rlevels.get(levelNum-1).setBoard(board);
	  }
  }
  
  /**
	 * Process line.
	 *
	 * @param aLine
	 *            the a line
	 */
  protected void processLine(String aLine){
    //use a second Scanner to parse the content of each line 
    Scanner scanner = new Scanner(aLine);
    scanner.useDelimiter("=");
    PieceFactory pFactory = new PieceFactory();
    if (scanner.hasNext()){
      //assumes the line has a certain structure
      String name = scanner.next();
      String value = scanner.next();
      
      //make lightning levels
      if(name.contains("LLEVEL") && ((!name.contains("PIECES") && !name.contains("BOARD"))))
    	  checkLightningLevels(kab.llevels.size() + 1, "LLEVEL" + (kab.llevels.size() + 1), name, value);
      else if(name.contains("LLEVEL") && name.contains("PIECES"))
    	  checkLightningPieces(kab.llevels.size(), "LLEVEL" + (kab.llevels.size()) + "_PIECES", pFactory, name, value);
      else if(name.contains("LLEVEL") && name.contains("BOARD"))
    	  checkLightningBoard(kab.llevels.size(), "LLEVEL" + (kab.llevels.size()) + "_BOARD", name, value);
      
      //make puzzle levels
      if(name.contains("PLEVEL") && ((!name.contains("PIECES") && !name.contains("BOARD"))))
    	  checkPuzzleLevels(kab.plevels.size() + 1, "PLEVEL" + (kab.plevels.size() + 1), name, value);
      else if(name.contains("PLEVEL") && name.contains("PIECES"))
    	  checkPuzzlePieces(kab.plevels.size(), "PLEVEL" + (kab.plevels.size()) + "_PIECES", pFactory, name, value);
      else if(name.contains("PLEVEL") && name.contains("BOARD"))
    	  checkPuzzleBoard(kab.plevels.size(), "PLEVEL" + (kab.plevels.size()) + "_BOARD", name, value);
      
      //make release levels
      if(name.contains("RLEVEL") && ((!name.contains("PIECES") && !name.contains("BOARD"))))
    	  checkReleaseLevels(kab.rlevels.size() + 1, "RLEVEL" + (kab.rlevels.size() + 1), name, value);
      else if(name.contains("RLEVEL") && name.contains("PIECES"))
    	  checkReleasePieces(kab.rlevels.size(), "RLEVEL" + (kab.rlevels.size()) + "_PIECES", pFactory, name, value);
      else if(name.contains("RLEVEL") && name.contains("BOARD"))
    	  checkReleaseBoard(kab.rlevels.size(), "RLEVEL" + (kab.rlevels.size()) + "_BOARD", name, value);
    }
    scanner.close();
  }
  
  /** The file path. */
  // PRIVATE 
  private final Path fFilePath;
  
  /** The Constant ENCODING. */
  private final static Charset ENCODING = StandardCharsets.UTF_8;  
  
  /** The kab. */
  private LBModel kab;
} 
