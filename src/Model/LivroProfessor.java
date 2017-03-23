/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Lucas
 */
public class LivroProfessor {
    private int prof,liv;
    private String data;
    private boolean devlvido=false;

    /**
     * @return the prof
     */
    public int getProf() {
        return prof;
    }

    /**
     * @param prof the prof to set
     */
    public void setProf(int prof) {
        this.prof = prof;
    }

    /**
     * @return the liv
     */
    public int getLiv() {
        return liv;
    }

    /**
     * @param liv the liv to set
     */
    public void setLiv(int liv) {
        this.liv = liv;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the devlvido
     */
    public boolean isDevlvido() {
        return devlvido;
    }

    /**
     * @param devlvido the devlvido to set
     */
    public void setDevlvido(boolean devlvido) {
        this.devlvido = devlvido;
    }
    
}
