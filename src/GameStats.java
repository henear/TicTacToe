
public class GameStats {
	int[] win = new int[5];
	int[] tie = new int[5];
	int[] lose = new int[5];
	int[] total = new int[5];
	double[] rate = new double[5];
	String[] diff = new String[]{"Very Easy", "Simple", "Medium", "Hard", "Expert"};
	public void updateStats(int w, int t, int l, int diff){
		win[diff-1] += w;
		tie[diff-1] += t;
		lose[diff-1] += l;
		total[diff-1] ++;
		rate[diff-1] = win[diff-1] * 1.0 / total[diff-1];
	}
	
	public void printStats(){
		for(int i = 0; i < 5;i ++){
			System.out.printf("Level: %12s:", diff[i] );
					System.out.print(" Win: " + win[i] + " Tie: " + tie[i]
					+ " Lose: " + lose[i]);
			System.out.printf(" Winning rate is %3.2f\n", rate[i]);			
		}
	}
}
