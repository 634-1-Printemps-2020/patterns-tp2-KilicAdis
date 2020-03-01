package materials;

import java.util.*;

public class Coin {

  private CoinState coinState;
  private static Coin uniqueCoin = new Coin();

  /**
   * Change l'état de la pièce.
   * 50% de probabilité d'obtenir HEADS, 50% de probabilité d'obtenir TAILS
   */
  public void throwCoin() {
    // TODO : Votre code ici
    double value = Math.random() * (1);

    if(value < 0.5){
      coinState = CoinState.HEADS;
    }else{
      coinState = CoinState.TAILS;
    }
  }

  public CoinState getState() {
    return coinState;
  }


}
