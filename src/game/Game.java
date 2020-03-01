package game;

import materials.Coin;
import materials.CoinState;
import player.Player;
import utils.Statistics;

import java.util.*;

public class Game {

    private Rules rules;
    private Coin coin;
    private Map<Player, List<CoinState>> history;

    public Game() {
        history = new HashMap<>();
    }

    /**
     * Ajouter un nouveau joueur au jeu
     *
     * @param player le nouveau joueur
     */
    public void addPlayer(Player player) {
      // TODO: Votre code ici
        List<CoinState> list = new ArrayList<>();
        history.put(player, list);
    }

    /**
     * Faire joueur tous les joueurs et stocker chaque partie dans history
     */
    public void play() {
      // TODO: Votre code ici
        Rules rule = new Rules();
        for(Player p: history.keySet()){
            Coin coin = new Coin();
            while(!rule.checkWin(history.get(p))){
                p.play(coin);
                history.get(p).add(coin.getState());
            }
        }
    }

    /**
     * Calculer des statistiques de la partie précédente
     *
     * @return Statistics
     */
    public Statistics getStatistics() {
      // TODO: Votre code ici
        Map<Player, List<CoinState>> historyPrec = this.history;
        float nbToWin = 0;
        int nbMin = 0;
        int nbMax = 0;
        int nbTotalLancer = 0;
        for(Player p : historyPrec.keySet()){
            nbToWin += historyPrec.get(p).size();
            nbTotalLancer += historyPrec.get(p).size();
        }

        nbToWin = nbToWin / historyPrec.size();
        nbMin = nbMinWin(historyPrec);
        nbMax = nbMaxWin(historyPrec);

        return new Statistics(nbToWin, nbMin, nbMax, nbTotalLancer);
    }

    private int nbMinWin(Map<Player, List<CoinState>> historyPrec){
        Player p1 = (Player)historyPrec.keySet().toArray()[0];
        int min = historyPrec.get(p1).size();
        for(Player p: historyPrec.keySet()){
            if(historyPrec.get(p).size() < min){
                min = historyPrec.get(p).size();
            }
        }
        return min;
    }

    private int nbMaxWin(Map<Player, List<CoinState>> historyPrec){
        Player p1 = (Player)historyPrec.keySet().toArray()[0];
        int max = historyPrec.get(p1).size();
        for(Player p: historyPrec.keySet()){
            if(historyPrec.get(p).size() > max){
                max = historyPrec.get(p).size();
            }
        }
        return max;
    }

    /**
     * Obtenir l'historique de tous les joueurs de la partie précédente
     *
     * @return Map contenant chaque joueur et la liste des ses lancers
     */
    public Map<Player, List<CoinState>> getHistory() {
      // TODO: Votre code ici
      return this.history;
    }


    /**
     * Obtenir l'historique d'un joueur spécifique
     *
     * @param player instance du joueur pour lequel on veut avoir l'historique
     * @return la liste des lancers d'un joueur
     */
    public List<CoinState> getSpecificHistory(Player player) {
      // TODO: Votre code ici
      return history.get(player);
    }

}
