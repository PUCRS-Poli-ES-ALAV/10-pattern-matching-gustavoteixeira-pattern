public class Main {
    public static int countOperations = 0;
    public static void main(String[] args) {
        String [] strings = new String[15];
        String [] testes = new String[15];

        StringBuilder base = new StringBuilder("AAAAAAAAAAAAAAAAA");
        StringBuilder testeBase = new StringBuilder("AAAA");
        for(int i = 0; i < 1; i++){
            String s1 = base + "B";
            base = base.append(base);
            strings[i] = s1;
        }
        for(int i = 0; i < 1; i++){
            String teste = testeBase+"B";
            testeBase = testeBase.append(testeBase);
            testes[i] = teste;
        }
        System.out.printf("%-10s| %-10s| %-15s | %-5s%n", "Tamanho", "Iteracoes", "Tempo(s)", "Resultado");
        System.out.println("-----------------------------------------------");

        for(int i = 0; i < strings.length ; i++){
            
            long start = System.nanoTime();
            long resultado = match(strings[i], testes[i]);
            long end = System.nanoTime();
            System.out.printf("%-10d| %-10d| %-15.10f | %-5d%n", strings[i].length(), countOperations, (end-start)*1e-9, resultado);
        }
        


    }
    public static int match(String s, String target){
        int index = -1;
        StringBuilder match = new StringBuilder();
        int j = 0;
        for(int i = 0; i < s.length(); i++){
            countOperations++;
            if(s.charAt(i) == target.charAt(j)){
                match.append(s.charAt(i));
                j++;
            }
            else{
                match = new StringBuilder();
                j = 0; 
            }
            if(match.toString().equals(target)){
                return i;
            }
        }
        return index;
    }
}