package display;

import game.Player;

public class DisplayManager {

	public void showStart() {
		System.out.println("◆すごろく◆\n始めるにはEnterキーを押してください。");
	}

	public void joinPlayer(Player player) {
		System.out.println(player.getName() + "さんが参加しました。");
	}

	public void pressEnter() {
		System.out.println("Enterキーを押してさいころを振ってください。");
	}

	public void showPlayer(Player player) {
		System.out.println(player.getName() + "さんの番です。");
	}

	public void showDiceNumber(int diceNumber) {
		System.out.println("\"" + diceNumber + "\"が出ました。\n");
	}

	public void advanceOneSquare(String location) {
		System.out.println("\n\"" + location + "マス進む\"" + "のマスに止まりました。\n" + location + "マス進みます。\n");
	}

	public void advanceTwoSquare(String location) {
		System.out.println("\n\"" + location + "マス進む\"" + "のマスに止まりました。\n" + location + "マス進みます。\n");
	}

	public void twoSquareBack(String location) {
		System.out.println("\n\"" + location + "マス戻る\"" + "のマスに止まりました。\n" + location + "マス戻る。\n");
	}

	public void showGoalSquare(int i) {
		System.out.println("ゴールまで残り: " + i);
	}
	
	public void returnToStart(String string) {
		System.out.println("\"スタートへ戻る\"のマスに止まりました。\nスタートへ戻ります。\n");
	}

	public void showGoal(String name) {
		System.out.println(name + "さんがゴールしました！");
	}

	public void showLine() {
		System.out.println("*******************");
	}

	public void overSquere(int overLocation) {
		System.out.println("ゴールを超えてしまいました。\n" + overLocation + "マス戻ります。");
	}

	public void showEnd() {
		System.out.println("ゲームを終了します。");
	}
}
