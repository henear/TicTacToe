
public class GameStats {
	int[] win = new int[4];
	int[] tie = new int[4];
	int[] lose = new int[4];
	int[] total = new int[4];
	double[] rate = new double[4];
	public void updateStats(int w, int t, int l, int diff){
		win[diff-1] += w;
		tie[diff-1] += t;
		lose[diff-1] += l;
		total[diff-1] ++;
		rate[diff-1] = win[diff-1] * 1.0 / total[diff-1];
	}
	
	public void printStats(){
		for(int i = 1; i <= 4;i ++){
			System.out.print("Level: " + i + " Win: " + win[i-1] + " Tie: " + tie[i-1]
					+ " Lose: " + lose[i-1]);
			System.out.printf(" Winning rate is %3.2f\n", rate[i-1]);			
		}
	}
}
