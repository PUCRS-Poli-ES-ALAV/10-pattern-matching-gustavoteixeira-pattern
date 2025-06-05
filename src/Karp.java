public class Karp {
    public static void main(String[] args) {
        System.out.println(rollingHashSearch("irth","birthboy"));
    }

    public static int search(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();
        long patHash = hash(pat, M);

        for (int i = 0; i <= N - M; i++) {
            long txtHash = hash(txt.substring(i, i+M), M);
            if (patHash == txtHash)
                return i; // ocorrência? colisão?
        }
        return N; // nenhuma ocorrência
    }
    public static long hash(String s, int M){
        int h = 0;
        int R = 0;
        for (int j = 0; j < M; j++){
            h = (h * R + s.charAt(j)) % 101;
            R = h;
        }
        return h;
    }       

    public static int rollingHashSearch(String pat, String txt){
        int M = pat.length();
        int d = 256;
        int h = 1;
        int q = 101;
        int N = txt.length();
        long  patHash = 0;
        long txtHash = 0;
        for (int i = 0; i < M - 1; i++)
            h = (h * d) % q;

        for (int i = 0; i < M; i++) {
            patHash= (d * patHash + pat.charAt(i)) % q;
            txtHash = (d * txtHash + txt.charAt(i)) % q;
        }
        for(int i = 0; i <= N - M; i++){
            if(patHash == txtHash){
                return i;
            }
            if(i < N-M){
                txtHash = (d *(txtHash - txt.charAt(i) * h) + txt.charAt(i+M)) % q;  
                if (txtHash < 0)
                    txtHash += q;
                }
            }
        return N;
    }
    
}
