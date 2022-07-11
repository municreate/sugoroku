package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import board.Board;
import display.DisplayManager;

public class Game {

	DisplayManager disp = new DisplayManager();
	Scanner scanner = new Scanner(System.in);
	Random rand = new Random();
	private List<Player> player = new ArrayList<>();

	private Board board;

	private Dice dice;

	String[] boardDate;

	public void setBoard(Board board) {
		this.board = board;
	}

	public void addPlayer(Player player) {
		this.player.add(player);
	}

	public void setDice(Dice dice) {
		this.dice = dice;
	}

	public void start() {

		boardDate = board.getBoardData();

		for (Player player : player) {
			disp.joinPlayer(player);
		}

		disp.showStart();
		scanner.nextLine();

		while (true) {
			int goal = board.getBoardData().length;
			int location = 0;

			for (Player player : player) {
				location = player.getNowLocation();

				disp.showPlayer(player);

				int remainingLocation = goal - location;

				showGoalSquare(remainingLocation);
				pressEnter();
				showDiceNumber(player);
				
				location += dice.getDiceNumber();
				if (goal < location) {
					int orverLocation = location - goal;
					disp.overSquere(orverLocation);
					location -= orverLocation * 2;
				} else if (goal == location) {
					disp.showGoal(player.getName());
					drawMap(goal,location);
					break;
				}
				location += moveLocation(location);

				player.setNowLocation(location);

				int goalLocation = goal - location;
				
				disp.showGoalSquare(goalLocation);
				
				drawMap(goal,location);
			}
			if (goal == location) {
				disp.showEnd();
				break;
			}
		}

	}

	private void pressEnter() {
		disp.pressEnter();
		scanner.nextLine();
	}

	private void showDiceNumber(Player player) {
		int diceNumber = 0;
		diceNumber = dice.getDice();
		disp.showDiceNumber(diceNumber);
		dice.setDiceNumber(diceNumber);
	}

	private void showGoalSquare(int squere) {
		disp.showGoalSquare(squere);
	}

	private int moveLocation(int location) {
		int moveLocation = 0;

		switch (boardDate[location]) {
		case "1":
			disp.advanceOneSquare(boardDate[location]);
			moveLocation = Integer.parseInt(boardDate[location]);
			break;
		case "2":
			disp.advanceTwoSquare(boardDate[location]);
			moveLocation = Integer.parseInt(boardDate[location]);
			break;
		case "-2":
			disp.twoSquareBack(boardDate[location]);
			moveLocation = Integer.parseInt(boardDate[location]);
			break;
		case "10":
			disp.returnToStart(boardDate[location]);
			moveLocation = - location;
			break;
		default:
			break;
		}

		return moveLocation;
	}
	
	private void drawMap(int goal,int location) {
		for(int i = 0; goal > i;i++) {
			if(location > i) {
				System.out.print("■");
			}else {
				System.out.print("□");
			}
		}
		System.out.println("");
		
		disp.showLine();
	}
}
