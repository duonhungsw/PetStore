
package model;

public class Coin {
    private int coin_id;
    private int coinNumber;

    public Coin() {
    }

    public Coin(int coin_id, int coinNumber) {
        this.coin_id = coin_id;
        this.coinNumber = coinNumber;
    }

    public int getCoin_id() {
        return coin_id;
    }

    public void setCoin_id(int coin_id) {
        this.coin_id = coin_id;
    }

    public int getCoinNumber() {
        return coinNumber;
    }

    public void setCoinNumber(int coinNumber) {
        this.coinNumber = coinNumber;
    }

    @Override
    public String toString() {
        return "Coin{" + "coin_id=" + coin_id + ", coinNumber=" + coinNumber + '}';
    }
    
    
    
}
