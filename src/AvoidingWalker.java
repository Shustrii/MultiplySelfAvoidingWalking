/************
 * *
 * * Description: This program show random walker who go out from box .
 */
public class AvoidingWalker {
    public static void main(String[] args) {
        int n= 10;
        int trials = 1;
        int deadEnds =0;
        for (int i = 0; i<trials;i++){
            boolean[][] a =new boolean[n][n];
            int x = n/2, y=n/2;
            while (x > 0 && x < n-1 && y >0 && y< n-1){
                a[x][y] = true;
                if (a[x-1][y] && a[x+1][y] && a[x][y-1] && a[x][y+1]) {
                    deadEnds++; break;}
                double r = Math.random();
                if (r<0.25){
                    if (!a[x+1][y])
                        x++;
                }
                if(r<0.50){
                    if (!a[x-1][y])
                        x--;
                }
                if (r<0.75){
                    if (!a[x][y+1])
                        y++;
                }
                if (r<1.00){
                    if (!a[x][y-1])
                        y--;
                }
            }
            for(int j=0; j<n; j++) {
                for(int k=0; k<n; k++)
                    System.out.print(a[j][k] + " ");
                System.out.println();
            }
        }
        System.out.println(100*deadEnds/trials + "% dead ends");
    }
}
