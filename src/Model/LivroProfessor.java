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
    private int professorId,livroId;
    private String data;
    private boolean devlvido=false;

    /**
     * @return the prof
     */
    public int getProfessorId() {
        return professorId;
    }

    /**
     * @param professorId the prof to set
     */
    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }

    /**
     * @return the liv
     */
    public int getLivroId() {
        return livroId;
    }

    /**
     * @param livroId the liv to set
     */
    public void setLivroId(int livroId) {
        this.livroId = livroId;
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
