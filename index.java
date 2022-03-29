public class index {
  public static String search(String word, char[][] soup) {
    int pi = -1, pj = -1;
    int fi = -1, fj = -1;
    int wi = 0;

    for (int i = 0; i < soup.length; i++) {
      for (int j = 0; j < soup[0].length; j++) {
        wi = 0;
        if (soup[i][j] == word.charAt(wi)) {
          pi = i;
          pj = j;
          wi += 1;
          if (j != 9 && soup[i][j + 1] == word.charAt(wi)) {
            // Right.
            // wi =+ 1;
            for(int l = wi; l < word.length(); l++){
              if (soup[i][j + l] != word.charAt(wi)) {
                pi = -1;   
                pj = -1;   
                fi = -1;   
                fj = -1;   
                break; 
              }else if (l == word.length() - 1){
                fi =  i;   
                fj = j + l;   
                System.out.println("Direccion: Derecha," + " Palabra: " + word);
                System.out.println("Inicio: " + pi + ", " + pj + " <-> Final: " + fi + ", " + fj);
              }
              // System.out.println("letra " + word.charAt(wi) + " encontrada en " + i + ", " + (j + l));
              wi += 1;
            }
          } else if (i < 9 && soup[i + 1][j] == word.charAt(wi)) {
            // Down.
             for(int l = wi; l < word.length(); l++){
              if (soup[i + l][j] != word.charAt(wi)) {
                pi = -1;   
                pj = -1;   
                fi = -1;   
                fj = -1;   
                break; 
              }else if (l == word.length() - 1){
                fi =  i + l;   
                fj = j;   
                System.out.println("Direccion: Abajo," + " Palabra: " + word);
                System.out.println("Inicio: " + pi + ", " + pj + " <-> Final: " + fi + ", " + fj);
              }
              // System.out.println("letra " + word.charAt(wi) + " encontrada en " + ( i + l ) + ", " + j);
              wi += 1;
            }
          } else if (j != 0 && soup[i][j - 1] == word.charAt(wi)) {
           // Left. 
            for(int l = wi; l < word.length(); l++){
              if (j - l >= 0 && soup[i][j - l] != word.charAt(wi)) {
                pi = -1;   
                pj = -1;   
                fi = -1;   
                fj = -1;   
                break; 
              }else if (l == word.length() - 1){
                fi =  i;
                fj = j - l;   
                System.out.println("Direccion: Izquierda," + " Palabra: " + word);
                System.out.println("Inicio: " + pi + ", " + pj + " <-> Final: " + fi + ", " + fj);
              }
              // System.out.println("letra " + word.charAt(wi) + " encontrada en " + i + ", " + ( j - l ));
              wi += 1;
            } 
          } else if (i > 0 && soup[i - 1][j] == word.charAt(wi)) {
            // Up.
            for(int l = wi; l < word.length(); l++){
              if (soup[i - l][j] != word.charAt(wi)) {
                pi = -1;   
                pj = -1;   
                fi = -1;   
                fj = -1;   
                break; 
              }else if (l == word.length() - 1){
                fi =  i;
                fj = j - l;   
                System.out.println("Direccion: Arriba," + " Palabra: " + word);
                System.out.println("Inicio: " + pi + ", " + pj + " <-> Final: " + fi + ", " + fj);
              }
              // System.out.println("letra " + word.charAt(wi) + " encontrada en " + ( i - l ) + ", " + j);
              wi += 1;
            }
          } else { break; } 
        }
      }
    }
    String retorno = pi + ", " + pj + "-> " + fi + ", " + fj;
    return retorno;
  }

  public static void sopas(String[] words, char[][] soup, int i, int j, int wordIndex) {
    if (wordIndex < words.length) {
      String[] positions = new String[5];
      positions[wordIndex] = search(words[wordIndex], soup);
      sopas(words, soup, 0, 0, ++wordIndex);
    }
  }

  public static void main(String[] args) {
    char[][] soup = {
      { 'a', 'b', 'c', 'a', 'm', 'a', 'l', 'o', 'i', 'j', },
      { 'e', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'c', 'j', },
      { 's', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'c', 'j', },
      { 't', 'b', 'a', 'n', 'i', 'c', 'o', 'c', 'a', 'j', },
      { 'u', 'b', 'b', 'd', 'e', 'f', 'g', 'h', 'b', 'a', },
      { 'z', 'i', 'a', 'a', 'l', 'k', 'q', 'a', 'a', 'f', },
      { 'a', 'b', 'l', 'd', 'e', 'f', 'g', 'm', 'l', 'u', },
      { 'a', 'b', 'l', 'd', 'e', 'f', 'g', 'a', 'l', 't', },
      { 'a', 'b', 'a', 'n', 'i', 'c', 'o', 'c', 'o', 's', },
      { 'n', 'c', 'o', 'l', 'c', 'h', 'o', 'n', 'k', 'e', },
    };
    String[] words = { "cama", "caballo", "cocina", "estufa", "colchon" };
    sopas(words, soup, 0, 0, 0);

    System.out.println("\n[ ]   [0] [1] [2] [3] [4] [5] [6] [7] [8] [9]");
    for (int i = 0; i < soup.length; i++) {
      System.out.print("[" + i + "]  ");
      for (int j = 0; j < soup.length; j++) {
        System.out.print("| " + soup[i][j] + " ");
      }
      System.out.println("|");
    }
  }
}
