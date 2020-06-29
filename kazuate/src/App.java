import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(final String[] args) throws Exception {
        Random rand = new Random();
        final Answer ans = new Answer();
        ans.setnum(rand.nextInt(90)+10);
        int loops = 1;
        final Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println(loops + "回目の入力 二桁の自然数を入力せよ");
            try {
                final int num = scan.nextInt();
                if (num < 10 || num > 99) {
                    System.err.println("「二桁」の「自然数」なんだわちゃんと文章読め");
                    continue;
                }
                if (ans.comparenum(num)) {
                    System.out.println(loops + "回目で正解 答えは" + ans.getnum() + "であった");
                    break;
                } else {
                    if (loops == 5) {
                        System.out.println("今回はこれで終わりだ 残念だったな");
                        break;
                    } else {
                        System.out.println("もう一度チャンスをやろう");
                        loops++;
                    }
                }
            } catch (final InputMismatchException e) {
                System.err.println("型からして違うんだわ まともにやる気がないなら帰って、どうぞ");
                break;
            }
        }
        scan.close();
    }
}

class Answer {
    int num;

    public void setnum(final int n) {
        num = n;
    }

    public int getnum() {
        return num;
    }

    public boolean comparenum(final int n) {
        if(num==n){
            System.out.println("当たり");
            return true;
        }
        if(num>n){
            System.out.println("答えはそれより大きい");
            if(num>n+20){
                System.out.println("20以上数値が離れている");
            }
            return false;
        }
        if(num<n){
            System.out.println("答えはそれより小さい");
            if(num<n-20){
                System.out.println("20以上数値が離れている");
            }
            return false;
        }
        return false;
    }
}
