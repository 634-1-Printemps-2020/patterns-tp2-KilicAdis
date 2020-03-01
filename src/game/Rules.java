package game;

import materials.CoinState;

import java.util.List;

public class Rules {

  private static Rules uniqueRule = new Rules();
  /**
   * Cette méthode permet de déterminer si une suite d'états de pièce permet de gagner à une partie
   * @param states liste d'états pour un joueur
   * @return true si un joueur a gagné, false sinon
   */
  public boolean checkWin(List<CoinState> states) {
    // TODO: Votre code ici
    int cmpt = 0;
    for(CoinState cs: states){
      if(cs == CoinState.TAILS){
        cmpt+=1;
      }else if(cs == CoinState.HEADS){
        cmpt = 0;
      }

      if(cmpt == 3){
        return true;
      }

    }
    return false;
  }
}
