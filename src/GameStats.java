
public class GameStats {
	int[] win = new int[6];
	int[] tie = new int[6];
	int[] lose = new int[6];
	int[] total = new int[6];
	double[] rate = new double[6];
	String[] diff = new String[]{"Very Easy", "Simple", "Medium", "Hard", "Expert", "Total"};
	public void updateStats(int w, int t, int l, int diff){
		win[diff-1] += w;
		tie[diff-1] += t;
		lose[diff-1] += l;
		total[diff-1] ++;
		rate[diff-1] = win[diff-1] * 1.0 / total[diff-1];
		for(int i = 0; i < 5; i++){
			win[5]+=win[i];
			tie[5]+=tie[i];
			lose[5]+=lose[i];
			total[5]+=total[i];
		}
		rate[5] = win[5] * 1.0 / total[5];
	}
	
	public void printStats(){
		for(int i = 0; i < 6;i ++){
			System.out.printf("Level: %12s:", diff[i] );
					System.out.print(" Win: " + win[i] + " Tie: " + tie[i]
					+ " Lose: " + lose[i]);
			System.out.printf(" Winning rate is %3.2f\n", rate[i]);			
		}
	}
}
