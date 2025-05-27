public class Main {
    public static int countOperations = 0;
    public static void main(String[] args) {
        String [] strings = new String[15];
        StringBuilder base = new StringBuilder("ABCDCBDCBDACBDABDCBABCDCBDCBDACBDABDCB");
        
        for(int i = 0; i < 15; i++){
            String s1 = base + "ADF";
            base = base.append(base);
            strings[i] = s1;
        }
        System.out.printf("%-10s| %-10s| %-15s | %-5s%n", "Tamanho", "Iteracoes", "Tempo(s)", "Resultado");
        System.out.println("-----------------------------------------------");

        for(String s : strings){
            
            long start = System.nanoTime();
            long resultado = match(s, "ADF");
            long end = System.nanoTime();
            System.out.printf("%-10d| %-10d| %-15.10f | %-5d%n", s.length(), countOperations, (end-start)*1e-9, resultado);
        }
        


    }
    public static int match(String s, String target){
        int index = -1;
        for(int i = 0; i < s.length(); i++){
            countOperations++;
            int j = 0;
            StringBuilder match = new StringBuilder();
            while(j < target.length()){
                countOperations++;
                if(s.charAt(i+j) == target.charAt(j)){
                    match.append(target.charAt(j));
                }
                j++;
            }
            if(match.toString().equals(target)){
                return i;
            }
        }
        return index;
    }
}